const router = require("express").Router();

router.post("/register", (req, res) => {
  console.log(req.body["tags"]);
  for (i in req.body["tags"]);
  console.log(i);

  res.json({
    success: true
  });
});

module.exports = router;
