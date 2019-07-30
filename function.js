var timer;
var showFlg = 0;
let min = 0;
let sec = 0;
let taskSet = "practice"
let task = 1;
let hl = "full";
let fnt = "nonPropotional";
//let setParam = "?taskSet=practice&task=practice&hl=full&font=nonPropotional&view=true";
//location.search = setParam;

function deleteCode() {
    let code = document.getElementById("preview");
    code.innerText = "";
    showFlg = 0;
}

function getCode(){
    let taskSetNum = 0;
    if(taskSet == "control_list"){
        taskSetNum = 1;
    }else if(taskSet == "control_string"){
        taskSetNum = 2;
    }else if(taskSet == "mathmatical"){
        taskSetNum = 3;
    }else if(taskSet == "conditional_branch"){
        taskSetNum = 4;
    }

    let filePath = "task/" + taskSet + "/Task" + taskSetNum + "_" + task + ".java";
    
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
    
    let taskNum = parseInt(document.getElementById("presentTask").innerHTML, 10);
    document.getElementById("presentTask").innerHTML = taskNum + 1;
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
    /*
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
    location.search = param;
    */
    deleteCode();
    
    if(taskSet == "practice"){
        taskSet = "control_list";
        document.getElementById("taskSet").innerHTML = "セット1";
        document.getElementById("task").innerHTML = "タスク" + task;
    }else{
        if(task == 6){
            switch(taskSet){
                case "control_list":
                    taskSet = "control_string";
                    document.getElementById("taskSet").innerHTML = "セット2";
                    break;
                case "control_string":
                    taskSet = "mathmatical";
                    document.getElementById("taskSet").innerHTML = "セット3";
                    break;
                case "mathmatical":
                    taskSet = "conditional_branch";
                    document.getElementById("taskSet").innerHTML = "セット4";
                    break;
            }
            task = 0;
        }
        task++;
        switch(task){
            case 1:
                hl = "full";
                fnt = "nonPropotional";
                break;
            case 2:
                hl = "preserved";
                fnt = "nonPropotional";
                break;
            case 3:
                hl = "gray";
                fnt = "nonPropotional";
                break;
            case 4:
                hl = "random";
                fnt = "nonPropotional";
                break;
            case 5:
                hl = "preserved";
                fnt = "propotional";
                break;
            case 6:
                hl = "preserved";
                fnt = "kawaii";
                break;
        }
        
        document.getElementById("task").innerHTML = "タスク" + task;
        switch(highlight){
            case "full":
                document.getElementById("highlight").innerHTML = "フルハイライト";
            case "preserved":
                document.getElementById("highlight").innerHTML = "予約語";
            case "gray":
                document.getElementById("highlight").innerHTML = "白黒";
            case "random":
                document.getElementById("highlight").innerHTML = "ランダム";
        }
        
        switch(font){
            case "nonPropotional":
                document.getElementById("font").innerHTML = "等幅フォント";
            case "propotional":
                document.getElementById("font").innerHTML = "非等幅フォント";
            case "kawaii":
                document.getElementById("font").innerHTML = "Kawaiiフォント";    
        }
    }
}

function changeFont(){
    let code = document.getElementById("preview");
    
    if(fnt == "nonPropotional"){
        // non propotional font
        code.style.fontFamily = "Courier";
    }else if(fnt == "propotional"){
        // propotional font
        code.style.fontFamily = "arial";
    }else if(fnt == "kawaii"){
        // kawaii font
        code.style.fontFamily = "Mv Boli";
    }
}

function changeHighlight(text){
    if(hl == "full"){
        // full highlight
        document.getElementById("style").href = "lib/styles/vs.css"
        document.getElementById("preview").innerHTML = hljs.highlight("java", text).value;
    }else if(hl == "preserved"){
        // preserved word highlight
        document.getElementById("style").href = "lib/styles/ascetic.css"
        document.getElementById("preview").innerHTML = hljs.highlight("java", text).value;
    }else if(hl == "gray"){
        // gray
        document.getElementById("preview").innerHTML = text;
    }else if(hl == "random"){
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