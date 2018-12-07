
var heads = 0;
var tails = 0;
var rand;
var checkbox;

//Functionality for 'Flip' button - working as expected
function flipCoin(){ 
    var numToss = document.getElementById("multi-flip").value;
    checkbox = document.getElementById("chkbx");
    rand = Math.ceil(Math.random()*2);

    if(checkbox.checked){
        for (i = 0; i < numToss; i++){
            rand = Math.ceil(Math.random()*2);

            if(rand == 1){
                heads++;
            }
            else if(rand == 2){
                tails++;
            }
        }

        document.getElementById("heads-box").value = heads;
        document.getElementById("tails-box").value = tails;

        heads = 0;
        tails = 0;
    }else {
        if(rand == 1){
            heads++;
            document.getElementById("coin-image").src = "/img/heads.png";
            document.getElementById("heads-box").value = heads;
        }
        else if(rand == 2){
            tails++;
            document.getElementById("coin-image").src = "/img/tails.png";
            document.getElementById("tails-box").value = tails;
        }
    }
} 

//Functionality for 'Reset' button
function resetFlips(){ 
    document.getElementById("multi-flip").readOnly = true;
    document.getElementById("coin-image").src = "/img/question.png";
    document.getElementById("heads-box").value = "";
    document.getElementById("tails-box").value = "";
    document.getElementById("chkbx").checked = false;
    document.getElementById("multi-flip").value = "10";
    heads = 0;
    tails = 0;
}

//Functionality for when 'Run Multiple Flips' box is checked - working as expected
function multiFlips(){ 
    checkbox = document.getElementById("chkbx");
    if(checkbox.checked){
        document.getElementById("multi-flip").readOnly = false;
        document.getElementById("coin-image").src = "/img/heads-tails.png";
        console.log("Checked!!");
    } else {
        document.getElementById("multi-flip").readOnly = true;
        document.getElementById("coin-image").src = "/img/question.png";
        console.log("Not checked!!");
    }
}