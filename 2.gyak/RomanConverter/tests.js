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
    QUnit.test("Five and its sequences", function (assert) {
      assert.equal(romanConverter(5), "V", "5 should return V");
      assert.equal(romanConverter(6), "VI", "6 should return VI");
      assert.equal(romanConverter(7), "VII", "7 should return VII");
      assert.equal(romanConverter(8), "VIII", "8 should return VIII");
    });
});
