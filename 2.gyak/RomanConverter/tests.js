const { romanConverter } = require("./app.js");

QUnit.module("Arabic numbers to Roman Converter test cases", function () {
    QUnit.test("Single symbol", function (assert) {
      assert.equal(romanConverter(1), "I", "1 should return I");
    });
});
