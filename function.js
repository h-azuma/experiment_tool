var timer;

function deleteCode(){
  let element = document.getElementById("preview");
  element.innerText = "";
}

function getCode(){
    let setName = document.getElementById("taskSet");
    let num1 = setName.selectedIndex + 1;
    let str1 = setName.options[num1].value;

    let taskNum = document.getElementById("task");
    let num2 = taskNum.selectedIndex;
    let str2 = taskNum.options[num2].value;

    let str = "/" + str1 + "/Task" + num1 + "_" + str2 + ".java";
    timeer = setInterval('showClock1()',1000);
    console.log(str);
}

function showClock1() {
   let min = parseInt(document.getElementById("minute").innerText, 10);
   let sec = parseInt(document.getElementById("second").innerText, 10) + 1;
   document.getElementById("minute").innerHTML = min;
   document.getElementById("second").innerHTML = sec;
}

function stopTimer(){
  window.alert('hogehoge')
  window.clearInterval(timer);
}
