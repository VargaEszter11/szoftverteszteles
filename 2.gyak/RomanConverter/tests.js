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
    QUnit.test("Fifties and hundreds", function (assert) {
      assert.equal(romanConverter(40), "XL", "40 should return XL");
      assert.equal(romanConverter(50), "L", "50 should return L");
      assert.equal(romanConverter(58), "LVIII", "58 should return LVIII");
      assert.equal(romanConverter(80), "LXXX", "80 should return LXXX");
      assert.equal(romanConverter(90), "XC", "90 should return XC");
      assert.equal(romanConverter(100), "C", "100 should return C");
    });
    QUnit.test("Five hundreds and thousands", function (assert) {
      assert.equal(romanConverter(400), "CD", "400 should return CD");
      assert.equal(romanConverter(500), "D", "500 should return D");
      assert.equal(romanConverter(900), "CM", "900 should return CM");
      assert.equal(romanConverter(1000), "M", "1000 should return M");
      assert.equal(romanConverter(1994), "MCMXCIV", "1994 should return MCMXCIV");
    });
    QUnit.test("Historical and modern years", function (assert) {
      assert.equal(romanConverter(1066), "MLXVI", "1066 should return MLXVI");
      assert.equal(romanConverter(1776), "MDCCLXXVI", "1776 should return MDCCLXXVI");
      assert.equal(romanConverter(1918), "MCMXVIII", "1918 should return MCMXVIII");
      assert.equal(romanConverter(1954), "MCMLIV", "1954 should return MCMLIV");
      assert.equal(romanConverter(1984), "MCMLXXXIV", "1984 should return MCMLXXXIV");
      assert.equal(romanConverter(1999), "MCMXCIX", "1999 should return MCMXCIX");
      assert.equal(romanConverter(2000), "MM", "2000 should return MM");
      assert.equal(romanConverter(2024), "MMXXIV", "2024 should return MMXXIV");
    });

    QUnit.test("Maximum Roman numeral", function (assert) {
      assert.equal(romanConverter(3999), "MMMCMXCIX", "3999 should return MMMCMXCIX");
    });
    QUnit.test("Zero, negative and missing input", function (assert) {
      assert.equal(romanConverter(), "", "No argument should return empty string");
      assert.equal(romanConverter(0), "", "0 should return empty string");
      assert.equal(romanConverter(-5), "", "-5 should return empty string");
    });
});
