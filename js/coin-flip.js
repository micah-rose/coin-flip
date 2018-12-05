//TO DO's:
//add functionality to flip and reset buttons
// display flips in heads/tails textboxes
//set multiple flips checkbox to flip whatever number is in textbox
//change image depending on flip
//random number generator for flips
var heads = 0;
var tails = 0;
var rand = Math.floor(Math.random()*2) + 1; 
var checkbox = document.getElementById("chkbx");

function flipCoin(){ //working as expected
console.log("Coin is flipped");
} 

function resetFlips(){ //working as expected
    console.log("Flips are reset");

}

function multiFlips(){ //not working as expected - FIX ME
    if(checkbox.checked === true){
        console.log("Checked!!");
    } else {
        console.log("Not checked!!");
    }
}