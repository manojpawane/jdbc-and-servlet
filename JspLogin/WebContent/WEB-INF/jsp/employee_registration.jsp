<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<script type="text/javascript"  src="validate.js"></script>
	
<!-- 	<script>
	function validate()
	{
	if (document.myform.textnames.value.trim() == "") {
		alert("Please fill the Name");
		document.myform.textnames.focus();
		return false;
	}
	return true;
	}
	</script> -->

</head>
<body>
<form name="myform" action="Employee_register"  method="get" onsubmit="return validate()">


<table cellpadding="2" width="20%" bgcolor="orange" align="center"
			cellspacing="2">

			<tr>

				<td colspan=2>

					<center>
						<font size=4><b>Registration Form</b></font>
					</center>

				</td>

			</tr>

			<tr>

				<td>Name</td>

				<td><input type=text name="textnames" id="textname" size="30"></td>

			</tr>
			
			<tr>

				<td>Mobile-Number</td>

				<td><input type=text name="mobile" id="mobile" size="30"></td>

			</tr>
			
			<tr>
			<td>Address</td>
			
			<td><textarea rows="2" cols="25" name=address></textarea></td>
			</tr>
			
			
			<tr>
			<td>Company Name</td>
			<td><input type=text name=company size="30"></td>
			</tr>
			
			
			<tr>
			<td>Age</td>
			
			<td><input type=number name=age size="10"></td>
			</tr>
			
			
			<tr>

				<td>Gender</td>

				<td><input type="radio" name="gender" value="male" size="10">Male

					<input type="radio" name="gender" value="Female" size="10">Female</td>

			</tr>
			
			<tr>

				<td>Specialized</td>

				<td><select name="specialized">

						<option value="-1" selected>select..</option>

						<option value="JAVA">JAVA</option>

						<option value="MEAN">MEAN</option>

						<option value="IOS">IOS</option>

						<option value="ANDROID">ANDROID</option>

				</select></td>

			</tr>			
			
			<tr>

				<td>Languages Known</td>

				<td><select name="language">

						<option value="-1" selected>select..</option>

						<option value="JAVA">JAVA</option>

						<option value="ANGULAR">ANGULAR</option>

						<option value="iOS">IOS</option>

						<option value="ANDROID">ANDROID</option>

						<option value="NODE">NODE</option>
						
						<option value="JAVA SCRIPT">JAVA SCRIPT</option>
						
						<option value="PHP">PHP</option>
				</select></td>

			</tr>	
			
			<tr>		
				<td colspan="2">
				<center><input type="reset"><input type="submit" value="Submit"  /></center></td>
			</tr>
</table>
</form>			
</body>
</html>