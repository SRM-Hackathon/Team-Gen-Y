const router = require("express").Router();
const dbUrl = process.env.dbUrl;
const mongoClient = require("mongodb").MongoClient;
const sortObjectsArray = require("sort-objects-array");

function degrees_to_radians(degrees)
{
  var pi = Math.PI;
  return degrees * (pi/180);
}

let calcDistance = ( [lat1, lon1], [lat2, lon2]) => {
  var R = 6371e3; // metres
  var φ1 = (degrees_to_radians(lat1));
  var φ2 = degrees_to_radians(lat2);
  var Δφ = degrees_to_radians(lat2-lat1);
  var Δλ =  degrees_to_radians(lon2-lon1);

  var a =
    Math.sin(Δφ / 2) * Math.sin(Δφ / 2) +
    Math.cos(φ1) * Math.cos(φ2) * Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

  return R * c;
};

function getD(lat1,lon1,lat2,lon2) {
  var R = 6371; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1); 
  var a = 
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
    Math.sin(dLon/2) * Math.sin(dLon/2)
    ; 
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
  var d = R * c; // Distance in km
  return d;
}
function distance(lat1,lon1,lat2,lon2) {
	var R = 6371; // km (change this constant to get miles)
	var dLat = (lat2-lat1) * Math.PI / 180;
	var dLon = (lon2-lon1) * Math.PI / 180;
	var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		Math.cos(lat1 * Math.PI / 180 ) * Math.cos(lat2 * Math.PI / 180 ) *
		Math.sin(dLon/2) * Math.sin(dLon/2);
	var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	var d = R * c;
	if (d>1) return Math.round(d)+"km";
	else if (d<=1) return Math.round(d*1000)+"m";
	return d;
}

let tamb = ['12.9249','80.1000']



function addMinutes(time, minsToAdd) {
  function D(J){ return (J<10? '0':'') + J;};
  var piece = time.split(':');
  var mins = piece[0]*60 + +piece[1] + +minsToAdd;

  return D(mins%(24*60)/60 | 0) + ':' + D(mins%60);  
}  
let genItenary = data => {
  let newList = [];
  for (let i in data) {
    if (i <= 8) {
      newList.push(data[i]);
        newList[i]['dist'] = getD(data[i]['lat'], data[i]['long'],tamb[0],tamb[1]);
        if(newList[i]['dist']>100){newList[i]['dist'] /= 1000};
        newList[i]['dist'] = newList[i]['dist'].toFixed(2);
    }
    console.log(getD(Math.abs(parseInt(newList[0]['lat'])), Math.abs(parseInt(newList[0]['long'])), tamb[0], tamb[1]));
  }

  let = sortObjectsArray(newList, "priority", { order: "desc" })
  for(let i in newList){
    let x = 1;
    if(parseFloat(newList[i]['dist'])> 25){
      x = 0.5;
    }
    if(parseFloat(newList[i]['dist'])>15){
      x = 5;
    }
    else
      x = 7;

    newList[i]['index'] = parseFloat((x/10)*parseFloat((newList[i]['dist'])) + 5*((10-x)/10)*parseFloat((newList[i]['priority'])));
  }

  let finalData = [];

  let final = sortObjectsArray(newList, "index", {order:"desc"});
  let t1 = '1030';
  let budget = 15000;
  let balance = 15000;
  for(let i in final){

    let last_time = t1;
    function generateRandomInteger(min, max) {
      return Math.floor(min + Math.random()*(max + 1 - min))
    }  

    let r1 = generateRandomInteger(20,50);
    let r2 = generateRandomInteger(30,40);
    let random1 = generateRandomInteger(20,60);
    let random2 = generateRandomInteger(30,90);

    addMinutes(t1, r1);
    addMinutes('18:15:00', '20');


    let cost1 = parseInt(generateRandomInteger(100, 500));
    cost1 = Math.ceil(cost1 / 10) * 10;
    
    if(Object.keys(final[i])[6]=="cost"){
      cost1 = 0;
      
      let andart = t1;
      

    }
    let Obj = {
      name: final[i]['name'],
      order: parseInt(i)+1,
      start_time: 1,
      end_time: 2,
      cost: cost1
    };
    balance = balance - cost1;
    last_time = Obj.end_time;
    finalData.push(Obj);
  }
  return finalData;
};

function deg2rad(deg) {
  return deg * (Math.PI/180)
}
let getData = () => {
  return new Promise((resolve, reject) => {
    mongoClient.connect(dbUrl, (err, db) => {
      if (err) reject(err);
      let dbo = db.db("SRM-Hack");
      dbo
        .collection("new_tourist_spot")
        .find()
        .toArray((dbErr, result) => {
          resolve(result);
          db.close();
        });
    });
  });
};


router.post("/remove-card", (req, res) => {
  console.log("req.body");

  let order = req.body.order;
  res.end();
});

router.post("/added-card", (req,res)=>{
  console.log(req.body);



})





router.get("/generateTrip", async (req, res) => {
  console.log("post req tripp");
  let data = await getData();
  let sortedData = sortObjectsArray(data, "priority", { order: "desc" });
  let finalData = (genItenary(sortedData));
  finalData.unshift({
    name:"flight",
    from: 'Mumbai Airport',
    to:'Chennai Airport',
    start_time: '9:30',
    end_time: '11:30',
    order: 0,
    cost: 2000,
  })

  mongoClient.connect(dbUrl, (err,db)=>{
    let dbo = db.db("SRM-Hack");
    for(let i in finalData){
      dbo.collection("Current_Iternary").insertOne(finalData[i], (errr,res)=>{
        console.log("inserted");
      })
    }
  })

  console.log(genItenary(finalData));
  res.send((genItenary(finalData)));
});

module.exports = router;
