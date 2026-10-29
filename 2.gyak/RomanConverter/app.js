const ROMAN_SYMBOLS = [
  ["C", 100],
  ["XC", 90],
  ["L", 50],
  ["XL", 40],
  ["X", 10],
  ["IX", 9],
  ["V", 5],
  ["IV", 4],
  ["I", 1],
];

function romanConverter(num) {
  let result = "";

  for (const [symbol, value] of ROMAN_SYMBOLS) {
    result += symbol.repeat(Math.floor(num / value));
    num %= value;
  }

  return result;
}

if (typeof module !== "undefined" && module.exports) {
  module.exports = { romanConverter };
}
