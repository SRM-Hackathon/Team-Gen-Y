const express = require("express");
const mongodb = require("mongodb");
const bodyParser = require("body-parser");
const app = express();

const dbUrl = "mongodb://localhost:27017/SRM-Hack";
const mongoClient = mongodb.MongoClient;
let line = () => {
  console.log("_____________________________________\n");
};

// mongoClient.connect(dbUrl, (err, db) => {
//   line();
//   if (err) throw err;
//   let dbo = db.db("SRM-Hack");

//   dbo
//     .collection("Trip")
//     .find()
//     .toArray((error, result) => {
//       if (error) throw err;
//       console.log(result);
//     });
// });

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.get("/", (req, res) => {
  console.log("Get request Home Route");
  res.send("Hello World");
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server is running on ${port}`);
});
