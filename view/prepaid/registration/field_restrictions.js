function numbers(evt) {
	if (!evt) var evt = window.event;
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) return false;
    return true;
}

function english(e, decimal) {
	var key;
	var keychar;
	if (window.event) {
		key = window.event.keyCode;
	} else if (e) {
		key = e.which;
	} else {
		return true;
	}
	keychar = String.fromCharCode(key);
 
	if ((key==null) || (key==0) || (key==8) ||  (key==9) || (key==13) || (key==27) ) {
		return true;
	} else if ((("0123456789ABCDEFGHIJKLMNOPQRSTUVXYZWQ@-. ,_:/").indexOf(keychar) > -1)) {
		return true;
	} else if (decimal && (keychar == ".")) { 
		return true;
	} else return false;
}
 
function englishnospace(e, decimal) {
	var key;
	var keychar;
 
	if (window.event) {
		key = window.event.keyCode;
	} else if (e) {
		key = e.which;
	} else {
		return true;
	}
	keychar = String.fromCharCode(key);
 
	if ((key==null) || (key==0) || (key==8) ||  (key==9) || (key==13) || (key==27) ) {
		return true;
	} else if ((("0123456789ABCDEFGHIJKLMNOPQRSTUVXYZWQ@-.,_:/").indexOf(keychar) > -1)) {
		return true;
	} else if (decimal && (keychar == ".")) { 
		return true;
	} else return false;
}
 
 
function datesonly(e, decimal) {
	var key;
	var keychar;
 
	if (window.event) {
		key = window.event.keyCode;
	} else if (e) {
		key = e.which;
	} else {
		return true;
	}
	keychar = String.fromCharCode(key);
 
	if ((key==null) || (key==0) || (key==8) ||  (key==9) || (key==13) || (key==27) ) {
		return true;
	} else if ((("0123456789-").indexOf(keychar) > -1)) {
		return true;
	} else if (decimal && (keychar == ".")) { 
		return true;
	} else return false;
}

