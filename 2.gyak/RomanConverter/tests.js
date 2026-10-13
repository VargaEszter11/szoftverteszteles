const { romanConverter } = require("./app.js");

QUnit.module("Arabic numbers to Roman Converter test cases", function () {
    QUnit.test("Edge cases and invalid inputs", function (assert) {
      assert.equal(
        romanConverter(),
        "",
        "Undefined/No argument should return empty string",
      );
      assert.equal(romanConverter(0), "", "0 should return empty string");
      assert.equal(
        romanConverter(-5),
        "",
        "Negative numbers should return empty string",
      );
    });
  
    QUnit.test("Base symbols", function (assert) {
      assert.equal(romanConverter(1), "I", "1 should return I");
      assert.equal(romanConverter(5), "V", "5 should return V");
      assert.equal(romanConverter(10), "X", "10 should return X");
      assert.equal(romanConverter(50), "L", "50 should return L");
      assert.equal(romanConverter(100), "C", "100 should return C");
      assert.equal(romanConverter(500), "D", "500 should return D");
      assert.equal(romanConverter(1000), "M", "1000 should return M");
    });
  
    QUnit.test("Subtractive notation (IV, IX, XL, etc.)", function (assert) {
      assert.equal(romanConverter(4), "IV", "4 should return IV");
      assert.equal(romanConverter(9), "IX", "9 should return IX");
      assert.equal(romanConverter(40), "XL", "40 should return XL");
      assert.equal(romanConverter(90), "XC", "90 should return XC");
      assert.equal(romanConverter(400), "CD", "400 should return CD");
      assert.equal(romanConverter(900), "CM", "900 should return CM");
    });
  
    QUnit.test("Additive notation sequences", function (assert) {
      assert.equal(romanConverter(2), "II", "2 should return II");
      assert.equal(romanConverter(3), "III", "3 should return III");
      assert.equal(romanConverter(7), "VII", "7 should return VII");
      assert.equal(romanConverter(8), "VIII", "8 should return VIII");
      assert.equal(romanConverter(20), "XX", "20 should return XX");
      assert.equal(romanConverter(30), "XXX", "30 should return XXX");
      assert.equal(romanConverter(80), "LXXX", "80 should return LXXX");
    });
  
    QUnit.test("Complex and historical numbers", function (assert) {
      assert.equal(
        romanConverter(1066),
        "MLXVI",
        "1066 should return MLXVI",
      );
      assert.equal(
        romanConverter(1776),
        "MDCCLXXVI",
        "1776 should return MDCCLXXVI",
      );
      assert.equal(
        romanConverter(1918),
        "MCMXVIII",
        "1918 should return MCMXVIII",
      );
      assert.equal(
        romanConverter(1954),
        "MCMLIV",
        "1954 should return MCMLIV",
      );
      assert.equal(
        romanConverter(1984),
        "MCMLXXXIV",
        "1984 should return MCMLXXXIV",
      );
      assert.equal(
        romanConverter(1999),
        "MCMXCIX",
        "1999 should return MCMXCIX",
      );
    });
  
    QUnit.test("Modern years", function (assert) {
      assert.equal(romanConverter(2000), "MM", "2000 should return MM");
      assert.equal(romanConverter(2001), "MMI", "2001 should return MMI");
      assert.equal(
        romanConverter(2004),
        "MMIV",
        "2004 should return MMIV",
      );
      assert.equal(
        romanConverter(2023),
        "MMXXIII",
        "2023 should return MMXXIII",
      );
      assert.equal(
        romanConverter(2024),
        "MMXXIV",
        "2024 should return MMXXIV",
      );
    });
  
    QUnit.test("Maximum standard Roman numeral", function (assert) {
      assert.equal(
        romanConverter(3999),
        "MMMCMXCIX",
        "3999 should return MMMCMXCIX",
      );
    });
  });