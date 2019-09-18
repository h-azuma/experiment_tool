let taskSet = "practice";
let hl = "full";
let fnt = "nonPropotional";
let taskSetNum; // taskSetの番号(呼び出すフォルダを管理する)
let taskNum = 0;　// 現在のtask番号を保持
let status = 0;

window.onload = function () {
    parseUrlParam = () => {
        const url = window.location.search.substring(1);
        let params = [];
        const _params = url.split('&');

        for (let i = 0; i < _params.length; i++) {
            let kv = _params[i].split('=');
            params[kv[0]] = kv[1];
        }
        return params
    };
    const params = parseUrlParam();
    console.log(params);

    if (params['__uid'] != undefined) {
        taskSetNum = params['taskset'];
        taskNum = params['tasknum'];
        status = params['status'];

        switchStatus();

        // define button behavior
        const button = document.getElementById('nextButton')
        button.addEventListener('click', () => {
            if (params['__next'] != "28") {
                location.href = '/_redirect.html' +
                    '?uid=' + params['__uid'] +
                    '&next=' + params['__next'];
            } else {
                window.alert('以上で実験は終了です.\nお疲れ様でした．');
            }
        });

        getCode();
    } else {
        document.getElementById("preview").innerHTML = 'URLにIDを入力してください．';
    }

};

function getCode() {

    if (taskSetNum == 0) {
        taskSet = 'practice'
    } else if (taskSetNum == 1) {
        taskSet = 'control_list';
    } else if (taskSetNum == 2) {
        taskSet = 'control_string';
    } else if (taskSetNum == 3) {
        taskSet = 'mathmatical';
    } else if (taskSetNum == 4) {
        taskSet = 'conditional_branch';
    }

    let filePath = "task/" + taskSet + "/Task" + taskSetNum + "_" + taskNum + ".java";

    fetch(filePath)
        .then((response) => response.text())
        .then((text) => changeHighlight(text))
        .then(() => changeFont())
        .catch((error) => console.log(error));
}

function switchStatus() {
    switch (status) {
        case "1":
            hl = "full";
            fnt = "nonPropotional";
            break;
        case "2":
            hl = "preserved";
            fnt = "nonPropotional";
            break;
        case "3":
            hl = "gray";
            fnt = "nonPropotional";
            break;
        case "4":
            hl = "random";
            fnt = "nonPropotional";
            break;
        case "5":
            hl = "preserved";
            fnt = "propotional";
            break;
        case "6":
            hl = "preserved";
            fnt = "kawaii";
            break;
        default:
            hl = "random";
            fnt = "kawaii";
            break;
    }
}

function changeFont() {
    let code = document.getElementById("preview");

    if (fnt == "nonPropotional") {
        // non propotional font
        code.style.fontFamily = "Courier";
    } else if (fnt == "propotional") {
        // propotional font
        code.style.fontFamily = "arial";
    } else if (fnt == "kawaii") {
        // kawaii font
        code.style.fontFamily = "Segoe Script";
    }
}

function changeHighlight(text) {
    if (hl == "full") {
        // full highlight
        document.getElementById("style").href = "lib/styles/vs.css";
        document.getElementById("preview").innerHTML = hljs.highlight("java", text).value;
    } else if (hl == "preserved") {
        // preserved word highlight
        document.getElementById("style").href = "lib/styles/ascetic.css";
        document.getElementById("preview").innerHTML = hljs.highlight("java", text).value;
    } else if (hl == "gray") {
        // gray
        document.getElementById("preview").innerHTML = text;
    } else if (hl == "random") {
        // random highlight
        let code = "";
        let tokens = text.split(" ");
        for (var i = 0; i < tokens.length; i++) {
            code += "<font color=\"#" + createRandomColorValue() + "\">" + tokens[i] + "</font> ";
        }
        document.getElementById("preview").innerHTML = code;
    }
}

function createRandomColorValue() {
    let colorValue = "";

    for (let i = 0; i < 3; i++) {
        var rand = Math.floor(Math.random() * 128);
        colorValue += rand.toString(16);
    }
    return colorValue;
}
