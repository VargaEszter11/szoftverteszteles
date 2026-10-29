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
    QUnit.test("Ten and IX", function (assert) {
      assert.equal(romanConverter(9), "IX", "9 should return IX");
      assert.equal(romanConverter(10), "X", "10 should return X");
      assert.equal(romanConverter(14), "XIV", "14 should return XIV");
      assert.equal(romanConverter(20), "XX", "20 should return XX");
      assert.equal(romanConverter(30), "XXX", "30 should return XXX");
    });
});
