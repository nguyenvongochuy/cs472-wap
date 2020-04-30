"use strict";

/**
* Problem 10: using the reveal module pattern to create Employee object
 */

const Employee = (function(){
	let name;
	let age;
	let salary;
	
	const setName = function(newName){
		name = newName;
	};
	const setAge = function(newAge){
		age = newAge;
	};
	const setSalary = function(newSalary){
		salary = newSalary;
	};
	const getName = function(){
		return name;
	};
	const getAge = function(){
		return age;
	};
	const getSalary = function(){
		return salary;
	};
	const increaseSalary = function(percentage){
		setSalary(getSalary() + getSalary()*percentage);
	};
	const incrementAge = function(){
		setAge(getAge()+1);
	};
	
	return {
		setName: setName,
		setAge: setAge,
		setSalary: setSalary,
		increaseSalary: increaseSalary,
		incrementAge: incrementAge,
		//getName: getName,
		//getAge: getAge,
		//getSalary: getSalary
	};
	
})();

//console.log("----- Prob 10 -----");
Employee.setName("John"); Employee.setAge("30"); Employee.setSalary("20000");
//console.log("Name: " + Employee.getName() + ", age: " + Employee.getAge() + ", salary:" + Employee.getSalary());

const addressFunc = (function(emp){
	let address;
	emp.getAddress = function(){
		return address;
	};
	emp.setAddress = function(newAddress){
		address = newAddress;
	};
	return emp;
})(Employee);

console.log("----- Prob 11 -----");
//const addr = Employee.addressFunc();
//addr.setAddress("FF Iowa");
addressFunc.setAddress("FF Iowa");
console.log(addressFunc.getAddress());
//console.log("Name: " + addressFunc.getName() + ", age: " + addressFunc.getAge() + ", salary:" + addressFunc.getSalary());
