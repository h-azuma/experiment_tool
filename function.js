var timer;
var showFlg = 0;
let min = 0;
let sec = 0;
let setParam = '?taskSet=practice&task=practice&hl=full&font=nonPropotional&view=true';
location.search = setParam;

function deleteCode() {
    let code = document.getElementById("preview");
    code.innerText = "";
    showFlg = 0;
}

function getCode(){
    let set = document.getElementById("taskSet");
    let taskSetNum = set.selectedIndex + 1;
    let setName = set.options[taskSetNum - 1].value;

    let taskNum = document.getElementById("task");
    let num = taskNum.selectedIndex;
    let str2 = taskNum.options[num].value;

    let filePath = "task/" + setName + "/Task" + taskSetNum + "_" + str2 + ".java";
    
    if(showFlg == 0){
        timer = setInterval('startClock()',1000);
        showFlg++;
    }
    
    // console.log(filePath);
    fetch(filePath)
    .then((response) => response.text())
    .then((text) => changeHighlight(text))
    .then(() => changeFont())
    .catch((error) => console.log(error));
    
}

function startClock() {
    sec++;

    if(sec >= 60){
        sec = 0;
        min += 1;
    }
    
    let logmin = min;
    let logsec = sec;
    if(min < 10){
        logmin = '0' + min;
    }

    if(sec < 10){
        logsec = '0' + sec;
    }
    console.log(logmin + ':' + logsec);
}

function resetClock(){
    min = 0;
    sec = 0;
}

function stopTimer(){
    window.clearInterval(timer);
    if(min < 10){
        min = '0' + min;
   }

   if(sec < 10){
       sec = '0' + sec;
   }
    window.alert(min + ':' + sec);
    resetClock();
}

function goNextTask(){
    deleteCode();
    let paramList = new Object;
    let param = location.search.substring(1).split('&');
    let paramSplit;
    for (let i = 0; param[i]; i++) {
        paramSplit = param[i].split('=');
        paramList[paramSplit[0]] = paramSplit[1];
    }
    if (paramList["taskSet"] == "practice") {
        paramList["taskSet"] = "control_list";
        paramList["task"] = "1";
        paramList["view"] = "false";
    }
    
    param = "";
    for (key in paramList){
        param += key + "=" + paramList[key] + "&";
    }
    param = param.slice(0, -1);
    
    console.log(param);
    window.location.search = param;
}

function changeFont(){
    let code = document.getElementById("preview");
    
    let font = document.getElementById("font");
    let fontNum = font.selectedIndex;
    
    if(fontNum == 0){
        // non propotional font
        code.style.fontFamily = "Courier";
    }else if(fontNum == 1){
        // propotional font
        code.style.fontFamily = "arial";
    }else if(fontNum == 2){
        // kawaii font
        code.style.fontFamily = "Mv Boli";
    }
}

function changeHighlight(text){
    let highlight = document.getElementById("highlight");
    let highlightNum = highlight.selectedIndex;
    
    if(highlightNum == 0){
        // full highlight
        document.getElementById("style").href = "lib/styles/vs.css"
        document.getElementById("preview").innerHTML = hljs.highlight("java", text).value;
    }else if(highlightNum == 1){
        // preserved word highlight
        document.getElementById("style").href = "lib/styles/ascetic.css"
        document.getElementById("preview").innerHTML = hljs.highlight("java", text).value;
    }else if(highlightNum == 2){
        // gray
        document.getElementById("preview").innerHTML = text;
    }else if(highlightNum == 3){
        // random highlight
        let code = "";
        let tokens = text.split(" ");
        for(var i = 0; i < tokens.length; i++){
            code += "<font color=\"#" + createRandomColorValue() + "\">" + tokens[i] + "</font> ";
        }
        document.getElementById("preview").innerHTML = code;
    }
}

function createRandomColorValue(){
    let colorValue = "";
    
    for(let i = 0; i < 3; i++){
        var rand = Math.floor(Math.random() * 128);
        colorValue += rand.toString(16);
    }
    return colorValue;
}