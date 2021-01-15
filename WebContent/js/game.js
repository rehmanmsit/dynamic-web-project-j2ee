
var nextValue = 1;

function rollBtn() {

	var rollNumber = Math.floor(Math.random() * (7 - 1)) + 1;
	
	document.getElementById("diceInput").value = rollNumber;
	 
	var srcText = "./img/" + rollNumber + ".png";
	
	document.getElementById("diceImg").src = srcText;
	
	document.getElementById("diceNumber").value = rollNumber;
	
	document.getElementById("gameForm").submit()
  
}

