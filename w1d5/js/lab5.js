"use strict";
/**
 * 1.	Define a function max() that takes two numbers as arguments and returns the largest of them. 
 * Use the if-then-else construct available in Javascript.
 */

const max = function(n1, n2){
	if (n1>n2){
		return n1;
	} else {
		return n2;
	}
}

console.log("Prob1 max(5,4): " + max(5,4));


/**
 * 2.	Define a function maxOfThree() that takes three numbers as arguments and returns the largest of them.
 */

const maxOfThree = function(n1, n2, n3){
	let max = n1;
	if (max<n2) {
		max = n2;
	}
	if (max<n3) {
		max = n3;
	}
	return max;
}

console.log("Prob2 maxOfThree(10,-10,40): " + maxOfThree(10,-10,40));


/**
 * 3.	Write a function isVowel() that takes a character (i.e. a string of length 1) and returns true if it is a vowel, false otherwise.
 */
const isVowel = function(character){
	if (character.toLowerCase()==="a" || character.toUpperCase()==="e" || character.toUpperCase()==="i" || character.toUpperCase()==="o" || character.toUpperCase()==="u") {
		return true;
	} else {
		return false;
	}
}

console.log("Prob3 (isVowel(\"a\")): " + isVowel("a"));


/**
 * 4.	Define a function sum() and a function multiply() that sums and multiplies (respectively) all the numbers in an input array of numbers. 
 * For example, sum([1,2,3,4]) should return 10, and multiply([1,2,3,4]) should return 
 * 24. Note/Hint: Do these using Imperative programming approach (i.e. for…loop or while…loop)
 */

const sum = function(array){
	let result=0;
	for (let i=0; i<array.length; i++) {
		result += array[i];
	}
	return result;
}

const multiply = function(array){
	let result=1;
	for (let i=0; i<array.length; i++) {
		result *= array[i];
	}
	return result;
}

console.log("Prob4 (sum([1,2,3,4])): " + sum([1,2,3,4]))
console.log("Prob4 (multiply([1,2,3,4])): " + multiply([1,2,3,4]))


/**
 * 5.	Define a function reverse() that computes the reversal of a string. For example, reverse("jag testar") should return the string "ratset gaj".
 */

const reverse = function(s){
	let result="";
	for (let i=s.length-1;i>=0; i--){
		result += s[i];
	}
	return result;
}

console.log("Prob5 (reverse(\"jag testar\")): " + reverse("jag testar"));


/**
 * 6.	Write a function findLongestWord() that takes an array of words and returns the length of the longest one.
 */

const findLogestWord = function(arr){
	let longestWord;
	if (arr===null || arr==="undefined"){
		return -1;
	} else {
		longestWord = arr[0];
		for (let i=1; i<arr.length; i++){
			if (longestWord.length < arr[i].length){
				longestWord = arr[i];
			}
		}
	}
	return longestWord.length;
}

console.log("Prob6 (findLogestWord([\"hello\",\"World\",\"Iowa Jefferson\"])): " + findLogestWord(["hello","World","Iowa Jefferson"]));


/**
 * 7.	Write a function filterLongWords() that takes an array of words and an integer i and returns 
 * a new array containing only those words that were longer than i characters.
 */

const filterLongWords = function(arr, len){
	let result = [];
	let count=0;
	for (let i=0; i<arr.length; i++){
		if (arr[i].length > len) {
			result[count] = arr[i];
			count++;
		}
	}
	return result;
}

console.log("Prob7 (filterLongWords([\"hi\",\"World\",\"Iowa Jefferson\"], 2))): " + filterLongWords(["hi","World","Iowa Jefferson"], 2));


/**
 * 8.	Write a function named, computeSumOfSquares, that takes as input, an array of numbers and calculates and returns the sum of the squares of each number 
 * in the input array. E.g. computeSumOfSquares([1,2,3]) should be computed as 1^2 + 2^2 + 3^2 = 14. Note: Write your Javascript code without using Imperative programming. i.e. 
 * Do NOT use any explicit looping construct; instead use functional programming style/approach.
 */

const computeSumOfSquares = function (nums) {
	return nums.reduce((acc, v) => acc + v*v, 0);
}

console.log("Prob8 (computeSumOfSquares([1,2,3])): " + computeSumOfSquares([1,2,3]));



/**
 * 9.	Write a function named, printOddNumbersOnly, that takes as input, an array of integral numbers and it finds and prints only the numbers which are odd.
 */

const printOddNumbersOnly = function (nums) {
	return nums.filter(v => v%2!==0);
}

console.log("Prob9 (printOddNumbersOnly([1,2,3])): " + printOddNumbersOnly([1,2,3]));



/**
 * 10.	Write a function named, computeSumOfSquaresOfEvensOnly, that takes as input, an array of integral numbers and calculates 
 * and returns the sum of the squares of only the even numbers in the input array.
 *  E.g. computeSumOfSquaresOfEvensOnly ([1,2,3,4,5]) should be computed as 2^2 +4^2 = 20.
 */

const computeSumOfSquaresOfEvensOnly = function (nums) {
	
	return nums.filter(v => v%2==0).reduce((acc, v) => acc + Math.pow(v,2), 0);
	
}

console.log("Prob10 (computeSumOfSquaresOfEvensOnly([1,2,3,4,5])): " + computeSumOfSquaresOfEvensOnly([1,2,3,4,5]));


/**
 * 11.	Using the Array.reduce(…) function, re-implement your functions, sum(…) and multiply(…) (defined in Problem 4 above) without 
 * using Imperative programming. i.e. Do NOT use any explicit looping construct; instead use functional programming style/approach. 
 */

const sumFunc = function(array){
	return array.reduce((acc, v) => acc + v, 0);
}

const multiplyFunc = function(array){
	return array.reduce((acc, v) => acc * v, 1);
}


console.log("Prob11 (sumFunc([1,2,3,4])): " + sumFunc([1,2,3,4]));
console.log("Prob11 (multiplyFunc([1,2,3,4])): " + multiplyFunc([1,2,3,4]));



/**
 * 12.	Implement Javascript code for a function named, findSecondBiggest, which takes as input, 
 * an array of numbers and finds and returns the second biggest of the numbers. 
 * For example, findSecondBiggest([1,2,3,4,5]) should return 4. And findSecondBiggest([19,9,11,0,12]) should return 12. (Note: Do not use sorting!)
 */

const findSecondBiggest = function(array) {
	const firstBiggest = array.reduce((p, v) => p>v?p:v);
	return array.filter(v=> v!==firstBiggest).reduce((p, v) => p>v?p:v);
}

console.log("Prob12 (findSecondBiggest([1,2,3,4,5])): " + findSecondBiggest([1,2,3,4,5]));
console.log("Prob12 (findSecondBiggest([19,9,11,0,12])): " + findSecondBiggest([19,9,11,0,12]));

/**
 * 13.	Write a function named printFibo, that takes as input, a given length, n, and any two starting numbers a and b, 
 * and it prints-out the Fibonacci sequence, e.g. (0, 1, 1, 2, 3, 5, 8, 13, 21, 34,…) of the given length, beginning with a and b. 
 * (e.g. printFibo(n=1, a=0, b=1), prints-out: "0", as output; printFibo(n=2, a=0, b=1), prints-out: "0, 1", 
 * as output; printFibo(n=3, a=0, b=1), prints-out: "0, 1, 1", as output; printFibo(n=6, a=0, b=1), prints-out: "0, 1, 1, 2, 3, 5", 
 * as output; and printFibo(n=10, a=0, b=1), prints-out: "0, 1, 1, 2, 3, 5, 8, 13, 21, 34", as output).
 */

var printFibo = function(n, a, b) {
	const array = [];
	for (let i=0; i<n; i++) {
		if (i===0) array[i] = a;
		else if (i===1) array[i] = b;
		else {
			array[i] = array[i-1] + array[i-2];
		}
	}
	return array;
	
}


console.log("Prob12 (printFibo(1, 0 ,1)): " + printFibo(1, 0, 1));
console.log("Prob12 (printFibo(2, 0, 1)): " + printFibo(2, 0, 1));
console.log("Prob12 (printFibo(10, 0 ,1)): " + printFibo(10, 0, 1));


