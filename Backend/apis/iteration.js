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
  var φ1 = console.log(degrees_to_radians(lat1));
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
      // console.log(newList[i]['dist'])
      // console.log(typeof(newList[i]['dist']))
    }
    else
      x = 7;

    newList[i]['index'] = parseFloat((x/10)*parseFloat((newList[i]['dist'])) + 5*((10-x)/10)*parseFloat((newList[i]['priority'])));
  }

  let finalData = [];

  console.log("aslihsdiufgsdf---------------------");
  console.log(newList);
  console.log("Aslsalsdfi -------------------------------------");

  let final = sortObjectsArray(newList, "index", {order:"desc"});
  // let finalData = [];
  let t1 = '10:30';
  for(let i in final){
    let last_time = t1;
    let random1 = Math.floor(Math.random() * 25 + 6);
    let random2 = Math.floor(Math.random() *90 +40);
     
    let t=0;
    let Obj = {
      name: final[i]['name'],
      order: parseInt(i)+1,
      start_time: parseFloat((20 + random1))/(60) + parseFloat(t),
      end_time: parseFloat((20+random1))/parseFloat(60 + random2/60)
    };

    t = Obj.end_time;
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
  console.log("Remove card api");
  res.end();
});

router.get("/generateTrip", async (req, res) => {
  console.log("post req tripp");
  let data = await getData();
  let sortedData = sortObjectsArray(data, "priority", { order: "desc" });
  res.send(genItenary(sortedData));
});

module.exports = router;
