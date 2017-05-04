function validate() {
	log.console("asdddf");
	if (document.myform.textnames.value.trim() == "") {
		alert("Please fill the Name");
		document.myform.textnames.focus();
		return false;

	}

	
	if (document.myform.age.value.trim() == "") {
		alert("Please fill your age");
		document.myform.age.focus();
		return false;

	}

	if (document.myform.company.value.trim() == "") {
		alert("Please Enter the name of your company");
		document.myform.company.focus();
		return false;
	}

	if (document.myform.address.value.trim() == "") {
		alert("Please provide your Postal Address!");
		document.myform.address.focus();
		return false;
	}

	if ((document.myform.gender[0].checked == false)
			&& (document.myform.gender[1].checked == false)) {
		alert("Please choose your Gender: Male or Female");
		return false;
	}

	if (document.myform.specialized.value == "-1") {
		alert("Please provide your specialization");

		return false;
	}

	if (document.myform.language.value == "-1") {
		alert("Please provide your language");

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


	if (document.myform.mobile.value.trim() == ""
			|| isNaN(document.myform.mobile.value)
			|| document.myform.mobile.value.length != 10) {
		alert("Please provide a Mobile No in the format 123.");
		document.myform.mobile.focus();
		return false;
	}
	return true;

};


function uservalidate()
{
	









}