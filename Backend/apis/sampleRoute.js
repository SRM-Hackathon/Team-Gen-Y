const router = require("express").Router();

router.get("/", (req, res) => {
  console.log("Get Request @ root path");
  res.send("Root Route");
});

module.exports = router;
