require("dotenv").config();
const express = require("express");
const mongodb = require("mongodb");
const bodyParser = require("body-parser");

const app = express();
const router = express.Router();
const sampleRoute = require("./apis/sampleRoute");
const userRoute = require("./apis/user");

const dbUrl = process.env.dbUrl;
const mongoClient = mongodb.MongoClient;
let line = () => {
  console.log("____________________________________________\n");
};

mongoClient.connect(dbUrl, (err, db) => {
  console.log("Database connected");
  line();
});

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.use("/", sampleRoute);
app.use("/user", userRoute);

const port = 3000;
app.listen(port, () => {
  console.log(`Server is running on ${port}`);
});
