var timer;

function deleteCode() {
    let code = document.getElementById("preview");
    code.innerText = "";
}

function getCode(){
    let set = document.getElementById("taskSet");
    let taskSetNum = set.selectedIndex + 1;
    let setName = set.options[taskSetNum - 1].value;

    let taskNum = document.getElementById("task");
    let num = taskNum.selectedIndex;
    let str2 = taskNum.options[num].value;

    let filePath = "file:///C:/msys64/home/azhid/experiment_tool/task/" + setName + "/Task" + taskSetNum + "_" + str2 + ".java";
    timer = setInterval('showClock()',1000);
    console.log(filePath);
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