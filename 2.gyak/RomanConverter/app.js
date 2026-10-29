function romanConverter(num) {
  return "I".repeat(num);
}

if (typeof module !== "undefined" && module.exports) {
  module.exports = { romanConverter };
}
