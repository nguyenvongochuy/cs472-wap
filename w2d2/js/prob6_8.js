"use strict";

/**
* Problem 6: updated for add and reset function for Module of javascript
 */
var add = (function(){
	var counter = 0;
	const add = function(){
		return counter += 1;
	};
	const reset = function(){
		counter = 0;
	};
	const getCounter = function(){
		return counter;
	};
	/*
	const setCounter = function(newCounter){
		counter = newCounter;
	};
	*/
	return {
		add: add,
		reset: reset,
		getCounter: getCounter,
		//setCounter: setCounter
	};	
})();

console.log("----- Prob6 -----");
console.log(add.getCounter());
add.add();
console.log(add.getCounter());
add.add();
console.log(add.getCounter());
add.reset();
console.log(add.getCounter());
add.add();
console.log(add.getCounter());



/**
* Problem 8: implement make_adder(inc) function to increase value inc
 */

add.make_adder = function(inc) {
	//add.setCounter(add.getCounter() + inc);
	for (let i=0; i<inc; i++){
		add.add();
	}
};


console.log("----- Prob8 -----");
add.reset();
console.log(add.getCounter());
add.make_adder(5); add.make_adder(5); add.make_adder(5); //final counter value is 15
console.log(add.getCounter());

add.reset();
add.make_adder(7); add.make_adder(7); add.make_adder(7); //final counter value is 21
console.log(add.getCounter());



