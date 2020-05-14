/* Convert date time to "dddd, mmmm dD, yyyy, hh:MM:ss TT" */
const convertFullDateTime = function(dateValue){
	let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	let dayofWeek = days[dateValue.getDay()];
	let day = dateValue.getDate();
	day = day<10?"0"+day:day;
	let months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	let month = months[dateValue.getMonth()];
	let year = dateValue.getFullYear();
	let hour = dateValue.getHours();
	let ampm = hour >= 12 ? 'PM' : 'AM';
	hour = hour % 12;
  	hour = hour ? hour : 12; // the hour '0' should be '12'
	hour = hour<10?"0"+hour:hour;
	let minute = dateValue.getMinutes();
	minute = minute<10?"0"+minute:minute;
	let second = dateValue.getSeconds();
	second = second<10?"0"+second:second;
	return dayofWeek+", " + day + " " + month +" "+ year + " " + hour + ":" + minute + ":" + second + " " + ampm;
};