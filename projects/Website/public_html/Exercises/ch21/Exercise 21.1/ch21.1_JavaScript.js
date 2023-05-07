var names = ["Jack", "Carter", "Thomas", "Ichigo", "Naruto", "Goku", "Rias"];
var namesNum = prompt("Pick a number between 1-7");
alert("The seventh name is: " + names[namesNum - 1]);
var myName = "carter";
var userName = prompt("Whats your name? ");
userName = userName.toLowerCase();
if (myName == userName) {
  alert("That's my name too");
} else alert(`Your name: "${userName}" is different than mine`);

var myVar = prompt("Pick a number between 1 & 10: ");
if (myVar > 5) {
  alert("Your number is among the upper 6-10");
} else alert("Your number is among the lower 0-5");
