const { romanConverter } = require("./app.js");

QUnit.module("Arabic numbers to Roman Converter test cases", function () {
    QUnit.test("Single symbol", function (assert) {
      assert.equal(romanConverter(1), "I", "1 should return I");
    });

    QUnit.test("Repeated I", function (assert) {
      assert.equal(romanConverter(2), "II", "2 should return II");
      assert.equal(romanConverter(3), "III", "3 should return III");
    });
    QUnit.test("Subtractive IV", function (assert) {
      assert.equal(romanConverter(4), "IV", "4 should return IV");
    });
});
