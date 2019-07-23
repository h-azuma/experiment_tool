var timer;
var showFlg = 0;

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
        timer = setInterval('showClock()',1000);
        showFlg++;
    }
    
    console.log(filePath);
    fetch(filePath)
    .then((response) => response.text())
    .then((text) => {
        document.getElementById("preview").innerText = text;
    })
    .catch((error) => console.log(error));
    hljs.highlightBlock(document.getElementById("preview"))
}

function showClock() {
   let min = parseInt(document.getElementById("minute").innerText, 10);
   let sec = parseInt(document.getElementById("second").innerText, 10) + 1;

   if(sec >= 60){
     sec = 0;
     min += 1;
   }

   if(min < 10){
     document.getElementById("minute").innerHTML = '0' + min;
   }else{
     document.getElementById("minute").innerHTML = min;
   }

   if(sec < 10){
     document.getElementById("second").innerHTML = '0' + sec;
   }else{
     document.getElementById("second").innerHTML = sec;
   }
}

function resetClock(){
    document.getElementById("minute").innerHTML = '00';
    document.getElementById("second").innerHTML = '00';
}

function stopTimer(){
    window.clearInterval(timer);
    window.alert(document.getElementById("minute").innerHTML + ':' + document.getElementById("second").innerHTML);
    resetClock();
}

function changeFont(){
    let code = document.getElementById("preview");
    
    let font = document.getElementById("font");
    let fontNum = font.selectedIndex;
    
    if(fontNum == 0){
        code.style.fontFamily = "Courier";
    }else if(fontNum == 1){
        code.style.fontFamily = "arial"
    }else if(fontNum == 2){
        code.style.fontFamily = "DS-dada";
    }
}

function changeHighlight(){
    let highlight = document.getElementById("highlight");
    let highlightNum = highlight.selectedIndex;
    
    if(highlightNum == 0){
        hljs.initHighlighting();
    }else if(highlightNum == 1){
        
    }else if(highlightNum == 3){
        
    }
}