function romanConverter(num) {
  if (num === 4) {
    return "IV";
  }

  return "I".repeat(num);
}

if (typeof module !== "undefined" && module.exports) {
  module.exports = { romanConverter };
}
