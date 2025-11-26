module.exports = {
  default: {
    require: [
      "step-definitions/*.js",
      "hooks/hooks.js"
    ],
    format: ["progress"],
    publishQuiet: true,
    parallel: 1,
   timeout: 60000

  }
};
