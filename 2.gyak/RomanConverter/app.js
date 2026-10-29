const ROMAN_SYMBOLS = [
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
