// 配列に画像のパスと説明を格納
sliderData = [
    {
        sliderId: "slider_rpg",
        slides:[
            {img: "images/rpg/title.png", desc: "タイトル画面です。セーブデータファイルがあれば、続きから始めることができます。"},
            {img: "images/rpg/new.png", desc: "はじめから始める際の画面です。文字列の入力を受け付けています。"},
            {img: "images/rpg/name.png", desc: "入力規則があり、一定の条件を満たす必要があります。"},
            {img: "images/rpg/field.png", desc: "基本的なフィールド画面です。町、カジノ、ボス、障害物、道にそれぞれの処理があり、障害物は進めず、道を歩けば敵と確率でエンカウントします。"},
            {img: "images/rpg/battle.png", desc: "敵とのバトル画面です。攻撃・回復・逃亡を選択できます。"},
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
            {img:"images/javascript/rule.png", desc:"遊び方を確認することができます。"},
            {img:"images/javascript/title.png", desc:"タイトルページです。難易度の調整、遊び方の確認、ゲーム開始ができます。"},
            {img:"images/javascript/game.png", desc:"ゲームページです。制限時間、クリアまでの回数、タイピングのお題が表示されます。"},
            {img:"images/javascript/input.png", desc:"文字入力が可能で、お題と同じ言葉をタイプすることでクリアまでの回数を重ねられます。"},
            {img:"images/javascript/number.png", desc:"数字が降ってきます。pushのタイミングで対応した数字を押すことで成功となります。"},
            {img:"images/javascript/gameover.png", desc:"数字を逃してしまった場合、ゲームオーバーとなります。タイトルページへ戻ることが可能です。"},
            {img:"images/javascript/gameclear.png", desc:"目標回数を達成するとクリアになります。"}
        ]
    },
    {
        sliderId: "slider_user",
        slides:[
            {img:"images/jsp-servlet/login.png", desc:"ログインページです。ログイン情報のない状態で各種ページにアクセスした際はログインページへ自動で遷移されます。"},
            {img:"images/jsp-servlet/index.png", desc:"トップページです。各種ページへ飛ぶ事ができます。"},
            {img:"images/jsp-servlet/add.png", desc:"新規作成ページです。各欄にrequited属性があり、入力が求められます。入力規則に反した内容の場合、エラーが表示されます。"},
            {img:"images/jsp-servlet/create.png", desc:"正規な入力がされた場合、データベースへデータが登録されます。"},
            {img:"images/jsp-servlet/listall.png", desc:"一覧表示ページです。ログインIDをクリックするとユーザー編集ページへ遷移され、削除ボタンをクリックすると削除ページへ遷移されます。"},
            {img:"images/jsp-servlet/edit.png", desc:"ユーザーの情報を編集できます。"},
            {img:"images/jsp-servlet/update.png", desc:"正規な入力がされた場合、データベースのデータが更新されます。"},
            {img:"images/jsp-servlet/confirm.png", desc:"削除確認画面です。削除ボタンを押すと確定されます。"},
            {img:"images/jsp-servlet/delete.png", desc:"削除が実行され、データがデータベースから削除されます。"},
            {img:"images/jsp-servlet/search.png", desc:"検索ページです。送信ボタンを押すと検索結果を表示できます。"},
            {img:"images/jsp-servlet/search_all.png", desc:"空文字のまま送信されると全件表示されます。"},
            {img:"images/jsp-servlet/search_word.png", desc:"文字が送信されると部分検索の結果が表示されます。"},
            {img:"images/jsp-servlet/trans.jpg", desc:"遷移図です。"},
            {img:"images/jsp-servlet/db.jpg", desc:"データベースで使用しているテーブル構造です。"},
        ]
    }
]

sliderData.forEach(({sliderId, slides}) =>{
    const slider = document.getElementById(sliderId);

    // スライド全体を包むラッパー要素を作成
    const slideWrapper = document.createElement("div");
    slideWrapper.className = "slides-wrapper";

    slides.forEach(({img, desc}) => {
        // 非表示のスライド用<div>を作成しクラスとスタイルを設定
        const slide = document.createElement("div");
        slide.className = "slide";
        slide.style.display = "none";

        // 画像要素を作成し、画像パスを設定
        const imgEle = document.createElement("img");
        imgEle.src = img;

        // 説明文の<p>を作成
        const desEle = document.createElement("p");
        desEle.textContent = desc;

        // slideへ画像と説明文を追加
        slide.appendChild(imgEle);
        slide.appendChild(desEle);
        slideWrapper.appendChild(slide);
    });
    // sliderへslideWrapperを追加
    slider.appendChild(slideWrapper);

    // 戻るボタンと進むボタンを作成し、クラスとテキストを設定
    const prevBtn = document.createElement("button");
    prevBtn.textContent = "←";
    prevBtn.classList.add("prev");
    const nextBtn = document.createElement("button");
    nextBtn.textContent = "→";
    nextBtn.classList.add("next");

    // 現在表示中のスライドのインデックス
    let currentIndex = 0;
    const allSlides = slideWrapper.querySelectorAll(".slide");
    
    // ページ情報表示用の<p>要素を設定
    const pageInfo = document.createElement("p");
    pageInfo.className = "page-info";

    slider.appendChild(pageInfo);
    slider.appendChild(prevBtn);
    slider.appendChild(nextBtn);

    // 指定したスライドを表示し、他は非表示にする。
    function showSlide(index) {
        allSlides.forEach((slide, i) => {
            if(i === currentIndex) {
                slide.style.display = "block";
            }else {
                slide.style.display = "none";
            }
        })
        // ページ数を更新
        pageInfo.textContent = `${currentIndex+1} / ${allSlides.length}`
    }

    // 戻るボタンの処理
    // クリックされたらインデックスを一つ戻し、表示を更新する
    prevBtn.addEventListener('click', () => {
        currentIndex = (currentIndex - 1 + allSlides.length) % allSlides.length;
        showSlide();
    })

    // 進むようボタンの処理
    // クリックされたらインデックスを一つ進み、表示を更新する
    nextBtn.addEventListener("click", () =>{
        currentIndex = (currentIndex + 1 + allSlides.length) % allSlides.length;
        showSlide();
    })

    // 初期表示
    showSlide();
});
