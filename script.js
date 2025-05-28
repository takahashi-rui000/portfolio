sliderData = [
    {
        sliderId: "slider_rpg",
        slides:[
            {img: "images/rpg/title.png", desc: "タイトル画面です。セーブデータファイルがあれば、続きから始めることができます。"},
            {img: "images/rpg/new.png", desc: "はじめから始める際の画面です。文字列の入力を受け付けています。"},
            {img: "images/rpg/name.png", desc: "入力規則があり、一定の条件を満たす必要があります。"},
            {img: "images/rpg/field.png", desc: "基本的なフィールド画面です。町、カジノ、ボス、障害物、道にそれぞれの処理があり、障害物は進めず、道を歩けば敵と確率でエンカウントします。"},
            {img: "images/rpg/battle.png", desc: "敵とのバトル画面です。"},
            {img: "images/rpg/selectEnemy.png", desc: "敵を選択する画面です。すでに倒れている敵は赤く表示されます。"},
            {img: "images/rpg/atack.png", desc: "敵を攻撃する画面です。赤いバーが左端から右に移動します。Enterキーを押したときのバーの位置によって攻撃の威力が増減します。これは相手の攻撃の際にも表示されます。"},
            {img: "images/rpg/slay.png", desc: "敵に勝利した時の画面です。経験値とゴールドがもらえる他、レベルアップ判定を行います。レベルアップをするとステータスが向上するほか、ステータスポイントが付与されます。"},
            {img: "images/rpg/status.png", desc: "ステータス画面です。レベルアップによって付与されたポイントを使用することによってステータスを増強することができます。"},
            {img: "images/rpg/buy.png", desc: "ショップでは、回復アイテムや装備を買うことができます。"},
            {img: "images/rpg/equip.png", desc: "装備を変更することができます。"},
            {img: "images/rpg/save.png", desc: "Jacksonによってjson形式に出力し、データをセーブすることができます。"},
            {img: "images/rpg/savedata.png", desc: "Jacksonによって一つのjsonファイルに出力しています。"},
            {img: "images/rpg/command.png", desc: "デバッグ用にコマンドを使用できるようにしました。マップの切り替えやステータスの増強、ゴールドの追加などを行えます。"},
            {img: "images/rpg/bj.png", desc: "ブラックジャックを遊べるようにしました。ゲーム内のゴールドを賭けて遊ぶことができます。"},
            {img: "images/rpg/bj_win.png", desc: "ブラックジャックの勝利画面です。"},
        ]
    },
    {
        sliderId: "slider_js",
        slides:[
            {img:"", desc:""},
        ]
    }
]

sliderData.forEach(({sliderId, slides}) =>{
    const slider = document.getElementById(sliderId);

    const slideWrapper = document.createElement("div");
    slideWrapper.className = "slides-wrapper";

    slides.forEach(({img, desc}) => {
        const slide = document.createElement("div");
        slide.className = "slide";
        slide.style.display = "none";

        const imgEle = document.createElement("img");
        imgEle.src = img;
        imgEle.alt = desc;

        const desEle = document.createElement("p");
        desEle.textContent = desc;

        slide.appendChild(imgEle);
        slide.appendChild(desEle);
        slideWrapper.appendChild(slide);
    });
    slider.appendChild(slideWrapper);

    const prevBtn = document.createElement("button");
    prevBtn.textContent = "←";
    prevBtn.classList.add("prev");
    const nextBtn = document.createElement("button");
    nextBtn.textContent = "→";
    nextBtn.classList.add("next");


    let currentIndex = 0;
    const allSlides = slideWrapper.querySelectorAll(".slide");
    
    const pageInfo = document.createElement("p");
    pageInfo.className = "page-info";
    slider.appendChild(pageInfo);

    slider.appendChild(prevBtn);
    slider.appendChild(nextBtn);

    function showSlide(index) {
        allSlides.forEach((slide, i) => {
            if(i === currentIndex) {
                slide.style.display = "block";
            }else {
                slide.style.display = "none";
            }
        })
        pageInfo.textContent = `${currentIndex+1} / ${allSlides.length}`
    }

    prevBtn.addEventListener('click', () => {
        currentIndex = (currentIndex - 1 + allSlides.length) % allSlides.length;
        showSlide();
    })

    nextBtn.addEventListener("click", () =>{
        currentIndex = (currentIndex + 1 + allSlides.length) % allSlides.length;
        showSlide();
    })

    showSlide();
});
