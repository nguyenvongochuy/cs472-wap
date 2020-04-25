/**
 * Display current time function and Immediately-Invoked Function
 */
(function currentTime() {
  var date = new Date(); 
  var hour = date.getHours();
  var min = date.getMinutes();
  var sec = date.getSeconds();
  hour = updateTime(hour);
  min = updateTime(min);
  sec = updateTime(sec);
  
  document.getElementById("clock").innerText = hour + " : " + min + " : " + sec; /* adding time to the div */
  var t = setTimeout(function(){ currentTime() }, 1000); /* setting timer */
}());

/**
 * Add first 0 to have 2 digit if only have 1 digit
 */
function updateTime(k) {
  if (k < 10) {
    return "0" + k;
  }
  else {
    return k;
  }
}

