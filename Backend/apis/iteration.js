const router = require("express").Router();
const dbUrl = process.env.dbUrl;
const mongoClient = require("mongodb").MongoClient;

let calcDistance = ({ lat1, lon1 }, { lat2, lon2 }) => {
  var R = 6371e3; // metres
  var φ1 = lat1.toRadians();
  var φ2 = lat2.toRadians();
  var Δφ = (lat2 - lat1).toRadians();
  var Δλ = (lon2 - lon1).toRadians();

  var a =
    Math.sin(Δφ / 2) * Math.sin(Δφ / 2) +
    Math.cos(φ1) * Math.cos(φ2) * Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

  return R * c;
};

let getData = () => {
  return new Promise((resolve, reject) => {
    mongoClient.connect(dbUrl, (err, db) => {
      if (err) reject(err);
      let dbo = db.db("SRM-Hack");
      dbo
        .collection("new_tourist_spot")
        .find()
        .project({ _id: 0 })
        .toArray((dbErr, result) => {
          console.log(result);
          resolve(result);
          db.close();
        });
    });
  });
};

let genNewIndex = data => {
  let co = [12.9249, 80.1];
  for (let item in data) {
    let co2 = [data[item]["lat"], data[item]["long"]];
    console.log(co2);
  }
};

router.post("/remove-card", (req, res) => {
  console.log("Remove card api");
  res.end();
});

router.post("/generateTrip", async (req, res) => {
  console.log("post req tripp");
  let data = await getData();
  // console.log(data);
  genNewIndex(data);
});

module.exports = router;
