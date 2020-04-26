/* Add event for button bigger */
var button = document.getElementById("bigger");
button.onclick = doBiggerClick;

function doBiggerClick() {
	let textarea = document.getElementById("textarea");
	let currentFontSize = window.getComputedStyle(textarea, null).getPropertyValue('font-size');
	//console.log(currentFontSize);
	if (currentFontSize.includes("px")) //convert font-size px to pt
		currentFontSize = 3/4 * parseInt(currentFontSize);
	//console.log(currentFontSize);
	textarea.style.fontSize = (currentFontSize + 2 ) + "pt";
	setInterval(function() {doBiggerClick()}, 500);
}


/* Add event for checkbox */
var checkbox = document.getElementById("bling");
checkbox.onchange = doBling;

function doBling() {
	let textarea = document.getElementById("textarea");
	if (checkbox.checked) {
		textarea.className = "changeStyle";
		document.body.className = "changeBg";
	} else {
		textarea.classList.remove("changeStyle");
		document.body.classList.remove("changeBg");
	}
	
}


/* "pig Latin" function */
var changeWord = document.getElementById("pigLatin");
changeWord.onclick = modifyWord;

function modifyWord() {
	let allLines = document.getElementById("textarea").value.trim();
	//console.log(allLines);
	let result = [];
	let lines = allLines.split("\n");
	for (let i=0; i<lines.length; i++) { 
		let words = lines[i].split(" ");
		words.map(w => {
			if (isLetter(w)) {
				result.push(convertToPigLatin(w));
			} else {
				result.push(w);
			}
		})
		
		if (i!==lines.length-1)
			result.push("\n");
	}
		//console.log(convertArrayToHtml(result));
		document.getElementById("textarea").value = convertArrayToHtml(result);
}


function convertToPigLatin(word) {
	let isFirstCharUppercase = (word[0] === word[0].toUpperCase());
	//console.log(isFirstCharUppercase);
	let newWord="";
	for (let c of word) {
		c= c.toLowerCase();
		if (newWord.length==0) {
			newWord += c;
		} else {
		    newWord = newWord.substring(0, newWord.length-1) + c + newWord.substring(newWord.length-1);
		}
	}
	
	newWord += "ay";
	if (isFirstCharUppercase){
		newWord = capitalize(newWord);
	}
	return newWord;
}

function isLetter(s){
	return s.match(/[a-z]/i);
}

function isBeginWithVowel(c) {
	if (c.toLowerCase() ==='a' ||
			c.toLowerCase() ==='e' ||
			c.toLowerCase() ==='i' ||
			c.toLowerCase() ==='o' ||
			c.toLowerCase() ==='u')
		return true;
	else
		return false;
}

function capitalize(s){
	return s[0].toUpperCase() + s.slice(1);
}

function convertArrayToHtml(arr) {
	let result = "";
	for (let i=0; i<arr.length; i++) {
		if (arr[i]=="\n") {
			result += "\n"
		} else {
			if (i!==arr.length-1)
				result += arr[i] + " ";
			else
				result += arr[i];
		}
	}
	
	return result;
}


/* "Malkovitch" function: that causes words of >= 5 characters in length to be replaced with the word "Malkovich" */
var changeWord = document.getElementById("malKovitch");
changeWord.onclick = malkovitch;

function malkovitch() {
	let newLines="";
	let allLines = document.getElementById("textarea").value;
	let lines = allLines.split("\n");
	for (let i=0; i<lines.length; i++) {
		let words = lines[i].split(" ");
		words = words.map(w => w.length>=5? "Malkovic": w);
		if (i!==lines.length-1)
			newLines += words.join(" ") + "\n";
		else
			newLines += words.join(" ");
	}
	//console.log(newLines);
	document.getElementById("textarea").value = newLines;
	
}




