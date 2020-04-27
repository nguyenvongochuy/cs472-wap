"use strict";

/* Add event for button bigger */
var button = document.getElementById("bigger");
button.onclick = doBiggerClick;
/**
 * Function to change textarea to become bigger by click "Bigger Decorations!" button
 * @returns change font size by add/remove css dynamically
 */
function doBiggerClick() {
	//alert("doBiggerClick");
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
/**
 * Function to change Bling checkbox with background-color and font style
 * @returns change background-color and font style by add/remove css dynamically
 */
function doBling() {
	//alert("doBling");
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
/**
 * Function to modify all lines with all words to pig latin
 * @returns update to textarea with Pig latin
 */
function modifyWord() {
	let allLines = document.getElementById("textarea").value.trim();
	//console.log(allLines);
	let result = [];
	let lines = allLines.split("\n");
	for (let i=0; i<lines.length; i++) { 
		let words = lines[i].split(" ");
		words = words.map(w => {
			if (isLetter(w)) {
				return convertToPigLatin(w);
			} else {
				return w;
			}
		})
		result.push(words.join(" "));
	}
		document.getElementById("textarea").value = result.join("\n");
}

/**
 * Function to convert word to Pig Latin with rules:
 * Words beginning in a consonant (or consonant cluster) have that consonant (or consonant cluster) moved to the end and -ay tacked on following.
 * Words beginning in a vowel simply have -ay tacked on the end.
 * @param word a word need to convert to pig latin
 * @returns the pig latin of a word. E.g. Words "Pig Latin" will display to "Igpay Atinlay"
 */
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

/**
 * Function to check whether character is letter or not
 * @param s character
 * @returns true: if character is from a-z, false: if character is not from a-z
 */
function isLetter(s){
	return s.match(/[a-z]/i);
}

/**
 * Function to check whether character is vowel or not
 * @param c character
 * @returns true: if character is vowel, false: if character is not vowel
 */
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

/**
 * This function to make the first Character in word to uppercase
 * @param s string
 * @returns Capitalize for 1st character to uppercase
 */
function capitalize(s){
	return s[0].toUpperCase() + s.slice(1);
}

/* "Malkovitch" function: that causes words of >= 5 characters in length to be replaced with the word "Malkovich" */
var changeWord = document.getElementById("malKovitch");
changeWord.onclick = malkovitch;

/**
 * Function to change word in lines if word's length is greater or equal than 5 and replace by "Malkovic" 
 */
function malkovitch() {
	let newLines=[];
	let allLines = document.getElementById("textarea").value;
	let lines = allLines.split("\n");
	for (let i=0; i<lines.length; i++) {
		let words = lines[i].split(" ");
		words = words.map(w => w.length>=5? "Malkovic": w);
		newLines.push(words.join(" "));
	}
	document.getElementById("textarea").value = newLines.join("\n");
}




