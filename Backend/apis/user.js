const router = require("express").Router();

router.post("/register", (req, res) => {
  console.log(req.body);
  res.json({
    success: true
  });
});

module.exports = router;
