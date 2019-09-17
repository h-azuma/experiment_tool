let timer;
let showFlg = true;
let min = 0;
let sec = 0;
let taskSet = "practice";
let hl = "full";
let fnt = "nonPropotional";
let isOnTimer = false;
let isFinishedTask = true;
let isEnteredID = false;
let ID;
let times = new Array(28);
let taskSetNum;
let taskNum = 0;
let taskSetOrder = new Array(4);
let taskOrder = new Array(7);
let statusOrder = new Array(28);
//let setParam = "?taskSet=practice&task=practice&hl=full&font=nonPropotional&view=true";
//location.search = setParam;

window.onload = function() {
    showButton = document.getElementById("showButton");
    nextButton = document.getElementById("nextButton");
    stopButton = document.getElementById("stopButton");
    giveUpButton = document.getElementById("giveUpButton");
    finishButton = document.getElementById("finishButton");
    finishLink.style.color = "white";
}

function getID() {
    ID = document.forms.input.inputForm.value;
    if (ID > -1 && ID < 21 && !isEnteredID) {
        nextButton.style.display = "inline";
        finishLink.style.color = "";
        
        getOrder();
        getStatusOrder(1);
        getStatusOrder(2);
        getStatusOrder(3);
        getStatusOrder(4);
        
        isEnteredID = true;
    } else if (isEnteredID) {
        window.alert("IDはすでに入力されています．");
    } else {
        window.alert("IDを正しく入力してください．");
    }
}

function getOrder() {
    let req1 = new XMLHttpRequest();
    req1.open("get", "square/taskSet.csv", true);
    req1.send(null);
	
    req1.onload = function(){
        let tmp = req1.responseText.split("\n");
        taskSetOrder = tmp[ID].split(',');
    }
    
    let req2 = new XMLHttpRequest();
    req2.open("get", "square/taskNumber.csv", true);
    req2.send(null);
	
    req2.onload = function(){
        let tmp = req2.responseText.split("\n");
        taskOrder = tmp[ID].split(',');
    }
}

function getStatusOrder(i) {
    let req1 = new XMLHttpRequest();
    req1.open("get", "square/status" + i + ".csv", true);
    req1.send(null);
	
    req1.onload = function(){
        let tmp1 = req1.responseText.split("\n");
        let tmp2 = tmp1[ID].split(',');
        for (let j = 0; j < tmp2.length; j++) {
                statusOrder[(i - 1) * 7 + j] = tmp2[j];
        }
    }
}

function deleteCode() {
    let code = document.getElementById("preview");
    code.innerText = "";
    showFlg = false;
}

function getCode(){
    if (!isOnTimer && !isFinishedTask) {
        showButton.style.display = "none";
        nextButton.style.display = "none";
        stopButton.style.display = "inline";
        giveUpButton.style.display = "inline";
        
        if(taskSetNum == 1){
            taskSet = "control_list";
        }else if(taskSetNum == 2){
            taskSet = "control_string";
        }else if(taskSetNum == 3){
            taskSet = "mathmatical";
        }else if(taskSetNum == 4){
            taskSet = "conditional_branch";
        }

        let filePath = "task/" + taskSet + "/Task" + taskSetNum + "_" + taskOrder[(taskNum - 1) % 7] + ".java";
    
        if(!showFlg){
            console.log("Timer Start")
            timer = setInterval('startClock()',1000);
            showFlg = true;
            isOnTimer = true;
            // console.log(filePath);
            fetch(filePath)
            .then((response) => response.text())
            .then((text) => changeHighlight(text))
            .then(() => changeFont())
            .catch((error) => console.log(error));
        }
    }
}

function startClock() {
    sec++;

    if(sec >= 60){
        sec = 0;
        min += 1;
    }
    
    if (min == 5) {
        window.alert("タイムアップです．");
        stopTimer();
    }
    
    /*let logmin = min;
    let logsec = sec;
    if(min < 10){
        logmin = '0' + min;
    }

    if(sec < 10){
        logsec = '0' + sec;
    }
    console.log(logmin + ':' + logsec);*/
}

function resetClock(){
    min = 0;
    sec = 0;
}

function stopTimer(){
    if (isOnTimer) {
        showButton.style.display = "none";
        nextButton.style.display = "inline";
        stopButton.style.display = "none";
        giveUpButton.style.display = "none";
        
        window.clearInterval(timer);
        if(min < 10){
            min = '0' + min;
        }

        if(sec < 10){
            sec = '0' + sec;
        }
        
        times[(taskSetNum - 1) * 7 + parseInt(taskOrder[(taskNum - 1) % 7], 10) - 1] = min + ":" + sec;
        isOnTimer = false;
        isFinishedTask = true;
        resetClock();
    }
    
}

function giveUp(){
    stopTimer();
    times[(taskSetNum - 1) * 7 + parseInt(taskOrder[(taskNum - 1) % 7], 10) - 1] = "-";
}

function goNextTask(){
    if (showFlg && isFinishedTask && isEnteredID && taskNum < 28) {
        showButton.style.display = "inline";
        nextButton.style.display = "none";
        stopButton.style.display = "none";
        giveUpButton.style.display = "none";
        
        deleteCode();
        isFinishedTask = false;
        
        taskNum++;
        document.getElementById("presentTask").innerHTML = taskNum;
        
        switch(statusOrder[taskNum - 1]){
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
        
        taskSetNum = parseInt(taskSetOrder[parseInt((taskNum - 1) / 7)], 10);
        //console.log(taskSetNum);
        
        document.getElementById("taskSet").innerHTML = (parseInt((taskNum - 1) / 7) + 1) + "セット目";
        document.getElementById("task").innerHTML = "タスク" + (taskNum - parseInt((taskNum - 1) / 7) * 7);
    } else if(taskNum == 28) {
        window.alert("実験は終了です．お疲れ様でした．")
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
        code.style.fontFamily = "Segoe Script";
    }
}

function changeHighlight(text){
    if(hl == "full"){
        // full highlight
        document.getElementById("style").href = "lib/styles/vs.css";
        document.getElementById("preview").innerHTML = hljs.highlight("java", text).value;
    }else if(hl == "preserved"){
        // preserved word highlight
        document.getElementById("style").href = "lib/styles/ascetic.css";
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

function finish() {
    let content = "";
    let setNum = 1;
    for (let i = 0; i < times.length; i++) {
        content += setNum + "-" + ((i % 7) + 1) + "," + times[i];
        if (i != times.length - 1) {
            content += "\n";
        }
        
        if ((i + 1) % 7 == 0) {
            setNum++;
        }
    }
    
    let blob = new Blob([ content ], { "type" : "text/csv" });
    
    document.getElementById("finishLink").download = "ID" + ID + "_result.csv";
    
    document.getElementById("finishLink").href = window.URL.createObjectURL(blob);
}