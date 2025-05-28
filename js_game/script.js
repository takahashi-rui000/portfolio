"use strict";

const romaToKana = {
  a: "あ",
  i: "い",
  u: "う",
  e: "え",
  o: "お",
  la: "ぁ",
  li: "ぃ",
  lu: "ぅ",
  le: "ぇ",
  lo: "ぉ",
  xa: "ぁ",
  xi: "ぃ",
  xu: "ぅ",
  xe: "ぇ",
  xo: "ぉ",
  ka: "か",
  ca: "か",
  ki: "き",
  kya: "きゃ",
  kyi: "きぃ",
  kyu: "きゅ",
  kye: "きぇ",
  kyo: "きょ",
  ku: "く",
  cu: "く",
  ke: "け",
  ko: "こ",
  co: "こ",
  ga: "が",
  gi: "ぎ",
  gya: "ぎゃ",
  gyi: "ぎぃ",
  gyu: "ぎゅ",
  gye: "ぎぇ",
  gyo: "ぎょ",
  gyo: "ぎょ",
  gu: "ぐ",
  ge: "げ",
  go: "ご",
  sa: "さ",
  si: "し",
  shi: "し",
  sya: "しゃ",
  sha: "しゃ",
  syu: "しゅ",
  shu: "しゅ",
  syo: "しょ",
  sho: "しょ",
  su: "す",
  se: "せ",
  so: "そ",
  za: "ざ",
  zi: "じ",
  ji: "じ",
  zya: "じゃ",
  ja: "じゃ",
  zyu: "じゅ",
  ju: "じゅ",
  zyo: "じょ",
  jo: "じょ",
  zu: "ず",
  ze: "ぜ",
  zo: "ぞ",
  ta: "た",
  ti: "ち",
  tti: "ち",
  chi: "ち",
  tya: "ちゃ",
  tya: "ちゃ",
  cha: "ちゃ",
  cha: "ちゃ",
  tyu: "ちゅ",
  tyu: "ちゅ",
  chu: "ちゅ",
  chu: "ちゅ",
  tyo: "ちょ",
  tyo: "ちょ",
  cho: "ちょ",
  cho: "ちょ",
  tu: "つ",
  ltu: "っ",
  xtu: "っ",
  te: "て",
  te: "て",
  to: "と",
  to: "と",
  da: "だ",
  da: "だ",
  di: "ぢ",
  di: "ぢ",
  dya: "ぢゃ",
  dya: "ぢゃ",
  dyu: "ぢゅ",
  dyu: "ぢゅ",
  dyo: "ぢょ",
  dyo: "ぢょ",
  du: "づ",
  du: "づ",
  de: "で",
  de: "で",
  do: "ど",
  do: "ど",
  na: "な",
  na: "な",
  ni: "に",
  nya: "にゃ",
  nya: "にゃ",
  nyu: "にゅ",
  nyu: "にゅ",
  nyo: "にょ",
  nyo: "にょ",
  nu: "ぬ",
  nu: "ぬ",
  ne: "ね",
  ne: "ね",
  no: "の",
  no: "の",
  ha: "は",
  ha: "は",
  hi: "ひ",
  hi: "ひ",
  hya: "ひゃ",
  hya: "ひゃ",
  hyu: "ひゅ",
  hyu: "ひゅ",
  hyo: "ひょ",
  hyo: "ひょ",
  hu: "ふ",
  hu: "ふ",
  fu: "ふ",
  fu: "ふ",
  fya: "ふゃ",
  fya: "ふゃ",
  fyu: "ふゅ",
  fyu: "ふゅ",
  fyo: "ふょ",
  fyo: "ふょ",
  fa: "ふぁ",
  fa: "ふぁ",
  fi: "ふぃ",
  fi: "ふぃ",
  fe: "ふぇ",
  fe: "ふぇ",
  fo: "ふぉ",
  fo: "ふぉ",
  he: "へ",
  he: "へ",
  ho: "ほ",
  ho: "ほ",
  ba: "ば",
  ba: "ば",
  bi: "び",
  bi: "び",
  bya: "びゃ",
  bya: "びゃ",
  byi: "びぃ",
  byi: "びぃ",
  byu: "びゅ",
  byu: "びゅ",
  bye: "びぇ",
  bye: "びぇ",
  byo: "びょ",
  byo: "びょ",
  bu: "ぶ",
  bu: "ぶ",
  be: "べ",
  be: "べ",
  bo: "ぼ",
  bo: "ぼ",
  pa: "ぱ",
  pa: "ぱ",
  pi: "ぴ",
  pi: "ぴ",
  pya: "ぴゃ",
  pya: "ぴゃ",
  pyi: "ぴぃ",
  pyi: "ぴぃ",
  pyu: "ぴゅ",
  pyu: "ぴゅ",
  pye: "ぴぇ",
  pye: "ぴぇ",
  pyo: "ぴょ",
  pyo: "ぴょ",
  pu: "ぷ",
  pu: "ぷ",
  pe: "ぺ",
  pe: "ぺ",
  po: "ぽ",
  po: "ぽ",
  ma: "ま",
  ma: "ま",
  mi: "み",
  mi: "み",
  mya: "みゃ",
  mya: "みゃ",
  myi: "みぃ",
  myi: "みぃ",
  myu: "みゅ",
  myu: "みゅ",
  mye: "みぇ",
  mye: "みぇ",
  myo: "みょ",
  myo: "みょ",
  mu: "む",
  mu: "む",
  me: "め",
  me: "め",
  mo: "も",
  mo: "も",
  ya: "や",
  ya: "や",
  lya: "ゃ",
  lya: "ゃ",
  xya: "ゃ",
  xya: "ゃ",
  yu: "ゆ",
  yu: "ゆ",
  lyu: "ゅ",
  lyu: "ゅ",
  xyu: "ゅ",
  xyu: "ゅ",
  yo: "よ",
  yo: "よ",
  lyo: "ょ",
  lyo: "ょ",
  xyo: "ょ",
  xyo: "ょ",
  ra: "ら",
  ra: "ら",
  ri: "り",
  ri: "り",
  rya: "りゃ",
  rya: "りゃ",
  ryi: "りぃ",
  ryi: "りぃ",
  ryu: "りゅ",
  ryu: "りゅ",
  rye: "りぇ",
  rye: "りぇ",
  ryo: "りょ",
  ryo: "りょ",
  ru: "る",
  ru: "る",
  re: "れ",
  re: "れ",
  ro: "ろ",
  ro: "ろ",
  wa: "わ",
  wa: "わ",
  wo: "を",
  wo: "を",
  nn: "ん",
};
const words_easy = [
  "さくら",
  "さかな",
  "いぬ",
  "ねこ",
  "みかん",
  "やさい",
  "しんぶん",
  "ちず",
  "とり",
  "ごはん",
  "たまご",
  "さくらんぼ",
  "あさごはん",
  "にんじん",
  "こまかい",
  "たてもの",
  "たんけん",
  "うみ",
  "くるま",
  "じかん",
  "おおきい",
  "こども",
  "あかちゃん",
  "みずうみ",
  "わたし",
  "あなた",
  "にわとり",
  "おみせ",
  "あんぜん",
  "よる",
  "おかし",
  "あんまり",
  "うんてん",
  "おみやげ",
  "ゆきだるま",
  "わらいごえ",
  "はるかぜ",
  "ほうき",
  "きょうしつ",
  "おしごと",
  "ふるさと",
  "とけい",
  "おもちゃ",
  "きょうみ",
  "おおかみ",
  "おとこ",
  "おんな",
  "りんご",
];
const words_normal = [
  "しんしょうひん",
  "りゅうこうご",
  "まだらもよう",
  "ないすあしすと",
  "はなしがい",
  "どんでんがえし",
  "おせっかいやき",
  "ほっとこーひー",
  "つーりすと",
  "なみだぶくろ",
  "せいとてちょう",
  "えいようほきゅう",
  "まもののたいぐん",
  "けっこんかつどう",
  "だいごさん",
  "あまいにおい",
  "ほういする",
  "まんげきょう",
  "まくどなるど",
  "きかんげんてい",
  "あおにさい",
  "あーかいぶ",
  "ちょこれーと",
  "ばれんたいん",
  "ほわいとでー",
  "あいこくしん",
  "あいいれない",
  "あかのたにん",
  "あばらぼね",
  "あらひとがみ",
  "いたちごっこ",
  "かんむりょう",
  "さいしょから",
  "あしたのわだい",
  "あなたのわらい",
  "しょうてすと",
  "しょうがっこう",
  "ちゅうがっこう",
  "こうとうがっこう",
  "ようちえん",
  "ほいくえん",
  "きまつしけん",
  "あにめーしょん",
  "えいがかんとく",
  "ぬりつぶし",
  "さつじんき",
  "あいらぶゆー",
  "つきがきれい",
  "あんぱんまん",
  "ねうしとらうたつみ",
  "きんがしんねん",
  "すまーとふぉん",
  "きねんさつえい",
  "ぱーそなりてぃ",
  "えんでぃんぐ",
  "おーぷにんぐ",
  "ぼーかろいど",
  "ぷろでゅーさー",
  "すたいるしーと",
  "すくりぷと",
  "ほーむぺーじ",
  "むげんだい",
  "たいこのたつじん",
  "はらんばんじょう",
  "うぇぶさいと",
  "ぷろぐらみんぐ",
  "こーでぃんぐ",
  "かいはつこうすう",
  "だいばくはつ",
  "えんじょう",
  "かっこいい",
  "こんすとらくた",
  "いんすとらくた",
  "いんすたんす",
];
const words_hard = [
  "つきがきれいですね",
  "なつふぇすてぃばる",
  "てりやきばーがー",
  "せかいのはんぶん",
  "おーぶんとーすたー",
  "しんしょっぷおーぷん",
  "にわにはにわにわとりがいた",
  "ちゃうちゃうちゃうんちゃうん",
  "しょぎょうむじょう",
  "いんがおうほう",
  "じゅうとうほういはん",
  "ぼういんぼうしょく",
  "こんとうすんぜん",
  "りゅうとうだび",
  "いちなんさってまたいちなん",
  "こーでぃんぐさぎょう",
  "おーばーらいど",
  "たいぴんぐれんしゅう",
  "せかいどうめい",
  "しょぎょうむじょう",
  "さいおうがうま",
  "こいんらんどりー",
  "すたーばっくす",
  "きかんげんてい",
  "ひゃくぱーせんとおふ",
  "まるまるもりもり",
  "しようしょさくせい",
  "かのえいこうのかこのえいこう",
  "たんじょうびぱーてぃー",
  "せかいたいかい",
  "しょうわへいせいれいわ",
  "たいしょううまれのたいしょう",
  "ぐーぐるくろむ",
  "えくすぷろーらー",
  "せいぎのみかた",
  "ゆきだるまつくろう",
  "だらんべーるのあやまり",
  "ばっかるこーん",
  "おうごんのりんご",
  "めとかーふのほうそく",
  "あんもくのるーる",
  "あるふぁるふぁ",
  "へびーすもーかー",
  "もんぶらんけーき",
  "きゅうせいあるこーるちゅうどく",
  "でんでんだいこ",
  "くれむりのろじー",
  "ろすとてくのろじー",
  "かじばのばかぢから",
];

const keys = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"];

const inputElement = document.querySelector("#input");
const themeElement = document.querySelector("#theme");
const timeElement = document.querySelector("#time");
const scoreElement = document.querySelector(".scoreManager");
const resultElement = document.querySelector(".result");
const clearStatusElement = document.querySelector("#clearStatus");
const timeValueElement = document.querySelector("#time-value");
const scoreValueElement = document.querySelector("#score-value");
const countdownElement = document.querySelector(".countdown");
const timeManagerElement = document.querySelector(".timeManager");
const titleButton = document.querySelector("#titleButton");
let str = "";
let elapsedTime = -1;
const timeLimit = 30;
const requiredScore = 5;
let isEnd = false;
let wordMode = 2;
let numMode = 2;
let numInterval = 3000;
let isAnomaly = false;
let startTime;
let endTime;
let time = 0;
let sumTime = 0;
let count = 0;
let avgTime = 0;
let words;
let randomWord;
let bloodInterval_bool = false;
let dropNotes;
let dropNumSum = 0;
let missedNum = 0;
let score = 0;

// ラジオボタンの受け取り
const checkedWordMode = localStorage.getItem("wordMode");
const checkedNumMode = localStorage.getItem("numMode");
wordMode = checkedWordMode;
numMode = checkedNumMode;
countdown(3);
titleButton.style.pointerEvents = "none";
// カウントダウン
function countdown(num) {
  let count = num;
  countdownElement.textContent = count;
  countdownElement.classList.add("countdownAnime");
  countdownElement.addEventListener("animationend", () => {
    if (count > 1) {
      count--;
      countdownElement.textContent = count;
      countdownElement.classList.remove("countdownAnime");
      countdownElement.offsetHeight;
      countdownElement.classList.add("countdownAnime");
    } else {
      start();
    }
  });
}

//  ゲームスタート
function start() {
  // ano_blood();
  time = 0;
  sumTime = 0;
  count = 0;
  avgTime = 0;
  isEnd = false;
  missedNum = 0;
  dropNumSum = 0;
  score = 0;
  elapsedTime = timeLimit;
  switch (wordMode) {
    case "0":
      words = words_easy;
      break;
    case "1":
      words = words_normal;
      break;
    case "2":
      words = words_hard;
      break;
  }
  switch (numMode) {
    case "0":
      numInterval = 6000;
      break;
    case "1":
      numInterval = 4000;
      break;
    case "2":
      numInterval = 2000;
      break;
    case "3":
      numInterval = 1000;
      break;
  }
  reset();
  start_dropNote();
  timeManager();
}

function gameEnd() {
  // window.alert("END");
  isEnd = true;
  titleButton.style.pointerEvents = "auto";
  if (requiredScore <= score) {
    clearStatusElement.textContent = "クリア！";
  } else {
    clearStatusElement.textContent = "失敗！";
  }
  scoreValueElement.textContent = score + "/" + requiredScore;
  timeValueElement.textContent = avgTime;
  resultElement.classList.add("result-animation");
}

function timeManager() {
  const timeLimit = setInterval(() => {
    if (isEnd) {
      clearInterval(timeLimit);
    }
    elapsedTime--;
    timeManagerElement.textContent = elapsedTime;
    if (elapsedTime <= 0) {
      clearInterval(timeLimit);
      gameEnd();
    }
  }, 1000);
}
resultElement.addEventListener("animationend", () => {
  resultElement.style.opacity = "1";
  resultElement.classList.remove("result-animation");
});

// お題を変更
function changeRandomWord() {
  const randInt = getRandomInt(0, words.length);
  console.log("rand:", randInt, ",length:", words.length);
  randomWord = words[randInt];
}

// キー入力の取得
document.addEventListener("keydown", function (event) {
  inputKey(event.key);
  checkMatch();
});
themeElement.textContent = randomWord;

// キーの処理
function inputKey(key) {
  if (!isEnd) {
    if (key >= "a" && key <= "z") {
      str = str + key;
      inputElement.textContent = str;
      normalizeInput(str);
    } else if (key === "-") {
      str += "ー";
    } else if (key === "Backspace") {
      console.log(key);
      backspace();
    } else if (key >= "0" && key <= "9") {
      pushKey(key);
    }
  }
  inputElement.textContent = str;
}
// バックスペースの処理(一文字削除)
function backspace() {
  if (str.length >= 1) {
    str = str.slice(0, -1);
  }
}

//  正規化
function normalizeInput(inpStr) {
  let tempStr;
  let found = false;
  let tuJud = false;
  for (let i = 0; i < inpStr.length; i++) {
    tuJud = false;
    found = false;
    for (let j = 1; j <= 3; j++) {
      tuJud = false;
      if (i + (j - 1) >= str.length) {
        break;
      }
      //  文字変換可能か判断
      tempStr = str.substring(i, i + j);
      if (romaToKana[tempStr]) {
        found = true;
        if (i >= 1) {
          if (str[i] == str[i - 1]) {
            if (
              str[i] != "a" &&
              str[i] != "i" &&
              str[i] != "u" &&
              str[i] != "e" &&
              str[i] != "o" &&
              str[str.length - 1] !== "ん"
            ) {
              tuJud = true;
            }
          } else {
            if (str[i - 1] == "n") {
              str = str.slice(0, i - 1) + "ん" + str.slice(i);
              str;
            }
          }
        }
        if (tuJud) {
          str = str.slice(0, -(j + 1));
          // result = result.slice(0, -1);
          str += "っ";
        } else {
          str = str.slice(0, -j);
        }
        str += romaToKana[tempStr];
        i = i + (j - 1);
        break;
      }
    }
  }
}

function checkMatch() {
  if (randomWord === str) {
    success();
  }
}

function success() {
  score++;
  scoreElement.textContent = score + "/" + requiredScore;
  endTime = new Date();
  console.log("--------");
  count++;
  time = endTime - startTime;
  sumTime = sumTime + time;

  if (count > 0) {
    avgTime = sumTime / count;
  }

  console.log("count   : ", count);
  console.log("time    : ", time);
  console.log("sumtime : ", sumTime);
  console.log("avgtime : ", avgTime);

  timeElement.textContent = time;
  inputElement.classList.add("successAnime");
  setTimeout(() => {
    if (requiredScore <= score) {
      gameEnd();
    }
  }, 0.5);
}

inputElement.addEventListener("animationend", () => {
  console.log("end");
  inputElement.classList.remove("successAnime");
  reset();
});

function reset() {
  str = "";
  inputElement.textContent = str;
  changeRandomWord();
  themeElement.textContent = randomWord;
  startTime = new Date();
}

function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min)) + min;
}

let activeNotes = [];
const main = document.querySelector(".main");

//
function start_dropNote() {
  dropNotes = setInterval(() => {
    if (isEnd) {
      clearInterval(dropNotes);
    }
    if (elapsedTime <= 5) {
      clearInterval(dropNotes);
    }
    dropNumSum++;
    const newNote = createNote();
    activeNotes.push(newNote);

    const interval = setInterval(() => {
      newNote.interval = interval;
      newNote.position += 3;
      newNote.element.style.top = newNote.position + "px";
      // 500~560
      if (newNote.position >= 560) {
        clearInterval(interval);
        if (!isEnd) {
          newNote.passed = true;
          newNote.element.remove();
          gameEnd();
        }
      }
    }, 20);
  }, numInterval);
}

const checkPassed = setInterval(() => {
  for (let i = 0; i < activeNotes.length; i++) {
    if (activeNotes[i].passed) {
      activeNotes.splice(i, 1);
      i--;
    }
  }
}, 20);

function pushKey(key) {
  for (const n of activeNotes) {
    if (n.key === key) {
      if (n.position >= 500 && n.position <= 560) {
        n.element.style.color = "red";
        console.log("OK");
        clearInterval(n.interval);
        setTimeout(() => {
          n.passed = true;
          n.element.remove();
        }, 200);
      }
    }
  }
}

function createNote() {
  const note = document.createElement("div");
  note.classList.add("note");
  const randomKey = keys[getRandomInt(0, keys.length)];
  note.textContent = randomKey;
  note.style.left = getRandomInt(-280, 280) + "px";
  main.appendChild(note);

  return {
    element: note,
    key: randomKey,
    position: 0,
    passed: false,
    intnerval: null,
  };
}

titleButton.addEventListener("click", function (event) {
  window.location.replace("index.html");
});
