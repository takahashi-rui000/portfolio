"use strick";
// indexScript
const startButton = document.querySelector("#startButton");
const close = document.querySelector("#close");
const rule = document.querySelector("#rule");
const ruleArea = document.querySelector("#ruleArea");

console.log(startButton);
startButton.addEventListener("click", function (event) {
  wordMode = document.querySelector('input[name="wordMode"]:checked')?.value;
  numMode = document.querySelector('input[name="numMode"]:checked')?.value;

  localStorage.setItem("wordMode", wordMode);
  localStorage.setItem("numMode", numMode);
  window.location.replace("game.html");
});

close.addEventListener("click", function (event) {
  ruleArea.style.opacity = "0";
  close.style.pointerEvents = "none";
});

rule.addEventListener("click", function (event) {
  ruleArea.style.opacity = "1";
  close.style.pointerEvents = "auto";
});
