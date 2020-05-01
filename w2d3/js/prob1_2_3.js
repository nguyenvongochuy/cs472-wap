"use strict";

/* (DOM, JQUERY, INHERITANCE) Lab */
/**
* Problem 1:	Define a JavaScript object literal named, person
* ===> USE CLASS for EXTRA POINT
 */
class Person {
	/* constructor */

	constructor(name, dateOfBirth){
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	/* getter setter for name */
	get name(){
		return this._name;
	}
	
	set name(value){
		this._name = value;
	}
	/* getter setter for dateOfBirth */
	get dateOfBirth(){
		return this._dateOfBirth;
	}
	
	set dateOfBirth(value){
		this._dateOfBirth = value;
	}
	
	/* ----------- Prob3: add toString() function ----------*/
	toString(){
		const dateFormatValue = convertDateMMDDYYYY(this.dateOfBirth);
		return `{Name: ${this.name}, DateOfBirth: ${dateFormatValue}}`;
	}
	
} 

/**
 * Function to convert date object to format MM-DD-YYYY
 */
const convertDateMMDDYYYY = function(dateValue){
	let delimiter = "-";
	let day = dateValue.getDate();
	let month = dateValue.getMonth() + 1;
	let year = dateValue.getFullYear();
	return year + delimiter + month + delimiter + day;
};

	
console.log("----- Prob1 -----");	
let person = new Person();
person.name="John";
person.dateOfBirth=new Date("December 10, 1998");
const dateFormatValue = convertDateMMDDYYYY(person.dateOfBirth);
console.log(`The person's name is ${person.name}\n${person.name} was born on ${dateFormatValue}`);


/**
* Prob2: Class Employee inheritance from Person 
 */
class Employee extends Person {
	constructor(name, dateOfBirth, salary, hiredDate){
		super(name, dateOfBirth);
		this.salary = salary;
		this.hiredDate = hiredDate;
	}
	
	doJob(jobTitle){
		this.jobTitle = jobTitle;
		let salaryFormat = formatter.format(this.salary);
		console.log(`${this.name} is a ${jobTitle} who earns ${salaryFormat}`)
	}
	
};

/**
 * Convert number to US currency
 */
const formatter = new Intl.NumberFormat('en-US', {
	  style: 'currency',
	  currency: 'USD',
	  minimumFractionDigits: 2
});

console.log("----- Prob2 -----");	
let employee = new Employee("Anna", "01/01/2000", 249955.50, new Date());
employee.doJob("Programmer");


/**
* Prob3: Implement toString() function and run
 */
console.log("----- Prob3 -----");	
console.log(person.toString());
let person1 = new Person("Peter", new Date("November 10, 1985"));
console.log(person1.toString());


