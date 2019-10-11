const router = require("express").Router();

router.post("/remove-card", (req, res) => {
  console.log("Remove card api");
  res.end();
});

module.exports = router;
