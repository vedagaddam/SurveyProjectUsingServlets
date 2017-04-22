<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acknowledgement</title>
<style>
	tr
	{ border: 1px solid #000; }
	td
	{ border: 1px solid #000; }
	
		.divSurvey{
		width:80%;
		margin: auto;
		}
		body{
	background-color: #D3D3D3;
	color:#880000;
	}
	h3{
	color:blue;
	text-shadow: -4px 4px 6px dimgrey;  
	}
	.para{
	font-family: courier;
	border-collapse: collapse;
	}
	.headings{
		color: #880000;
	}
	.link{
	font-size: 16pt;
	}
	</style>
</head>
<body>
	<h2> Student Details</h2>
	<br>
	
	<strong>Name:</strong> ${ student.getStudentName()}<br>
	<strong>GMU ID:</strong> ${ student.getGmuId()}<br>
	<strong>Street Address:</strong> ${ student.getStreetAddress()}<br>
	<strong>City:</strong> ${ student.getCity() }<br>
	<strong>State:</strong> ${ student.getState()}<br>
	<strong>Zip code:</strong> ${ student.getZip() }<br>
	<strong>Telephone: </strong>${ student.getTelephone()}<br>
	<strong>E-mail:</strong> ${ student.getEmail()}<br>
	<strong>URL:</strong> ${ student.getUrl()}<br>
	<strong>Date Of Survey:</strong> ${ student.getDateOfSurvey()}<br>
	<strong>What Did You Like The Most In Campus?:</strong> ${student.getLikes()}<br>
	<strong>How Made You Interested In the university? :</strong> ${student.getInterested()}<br>
	<strong>Month Of Graduation: </strong>${student.getGraduationMonth()}<br>
	<strong>Year Of Graduation:</strong> ${student.getGraduationYear()}<br>
	<strong>Comments:</strong> ${student.getAdditionalComments()}<br>
	<strong>How Likely Would You Recommend the university:</strong> ${student.getLikelyhood()}<br>
	<div id="ttp">
	<a href="https://www2.gmu.edu">
	<img  border="0" alt="GMU LOGO" src="gmulogo.png" width="100" height="100" title="Click here to visit the GMU website" align="right" >
	</a>
	</div>
	Content created by Veda Gaddam
</body>
</html>		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		