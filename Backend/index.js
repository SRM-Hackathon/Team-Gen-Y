require("dotenv").config();
const express = require("express");
const mongodb = require("mongodb");
const bodyParser = require("body-parser");

const app = express();
const router = express.Router();
const sampleRoute = require("./apis/sampleRoute");
const userRoute = require("./apis/user");
const iterationRoute = require("./apis/iteration");

const dbUrl = process.env.dbUrl;
const mongoClient = mongodb.MongoClient;
let line = () => {
  console.log("____________________________________________\n");
};

// app.get("/python", callName);
// console.log("In python request");
// function callName(req, res) {
//   var spawn = require("child_process").spawn;

//   var process = spawn("python", [
//     "../ML/Recommender-system-for-tourists/model1.py",
//     req.query.firstname,
//     req.query.lastname
//   ]);

//   process.stdout.on("data", function(data) {
//     console.log(data.toString());
//     res.send(data.toString());
//   });
// }

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.use("/", sampleRoute);
app.use("/user", userRoute);
app.use("/itenary", iterationRoute);

const port = 3000;
app.listen(port, () => {
  line();
  console.log(`Server is running on ${port}`);
});
