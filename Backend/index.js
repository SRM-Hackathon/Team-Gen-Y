const express = require("express");
const mongodb = require("mongodb");
const bodyParser = require("body-parser");

const app = express();
const router = express.Router();
const sampleRoute = require("./apis/sampleRoute");

const dbUrl = "mongodb://localhost:27017/SRM-Hack";
const mongoClient = mongodb.MongoClient;
let line = () => {
  console.log("____________________________________________\n");
};

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.use("/", sampleRoute);

const port = 3000;
app.listen(port, () => {
  console.log(`Server is running on ${port}`);
});
