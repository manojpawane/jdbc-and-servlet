function validate() {
	if (document.myform.textnames.value.trim() == "") {
		alert("Please fill the Name");
		document.myform.textnames.focus();
		return false;

	}

	if (document.myform.fathername.value.trim() == "") {
		alert("Please fill the father Name");
		document.myform.fathername.focus();
		return false;

	}
	if (document.myform.uname.value.trim() == "") {
		alert("Please fill the Username");
		document.myform.uname.focus();
		return false;

	}

	if (document.myform.password.value.trim() == "") {
		alert("Please Enter the correct password");
		document.myform.password.focus();
		return false;
	}

	if (document.myform.paddress.value.trim() == "") {
		alert("Please provide your Postal Address!");
		document.myform.paddress.focus();
		return false;
	}

	if ((myform.gender[0].checked == false)
			&& (myform.gender[1].checked == false)) {
		alert("Please choose your Gender: Male or Female");
		return false;
	}

	if (document.myform.course.value == "-1") {
		alert("Please provide your Course!");

		return false;
	}

	if (document.myform.district.value == "-1") {
		alert("Please provide your Select District!");

		return false;
	}

	if (document.myform.state.value == "-1") {
		alert("Please provide your Select State!");

		return false;
	}

	if (document.myform.pincode.value == ""
			|| isNaN(document.myform.pincode.value)
			|| document.myform.pincode.value.length != 6) {
		alert("Please provide a pincode in the format ######.");
		document.myform.pincode.focus();
		return false;
	}

	var x = document.myform.emailid.value;
	var atposition = x.indexOf("@");
	console.log(atposition);
	var dotposition = x.lastIndexOf(".");
	if (atposition < 1 || dotposition < atposition + 2
			|| dotposition + 2 >= x.length) {
		alert("Please enter a valid e-mail address");
		return false;
	}

	if (document.myform.dob.value.trim() == "") {
		alert("Please provide your DOB!");
		document.myform.dob.focus();
		return false;
	}

	if (document.myform.mobile.value.trim() == ""
			|| isNaN(document.myform.mobile.value)
			|| document.myform.mobile.value.length != 10) {
		alert("Please provide a Mobile No in the format 123.");
		document.myform.mobile.focus();
		return false;
	}
	return true;

};

function deletevalidate() {

	if (document.login.username.value.trim() == "") {
		alert("Please fill the Username");
		document.myform.uname.focus();
		return false;

	}

	if (document.login.password.value.trim() == "") {
		alert("Please fill password");
		document.myform.password.focus();
		return false;
	}

	return true;
}
