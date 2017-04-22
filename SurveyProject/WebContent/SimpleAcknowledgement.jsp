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
<h2> Thank you for filling out the form.</h2>
<br>
<h3>Your Mean: ${dBean.getMean() }<br>
Standard Deviation: ${dBean.getStadardDeviation() }<br>
</h3>
Your details are saved.<br>

The list of students are: (Click on the link to get more information)<br>

		<% String[] idstring = (String[])request.getAttribute("ids");
		for (int i=0;i<idstring.length;i++) {
			String stuid = idstring[i];
		%>
		<li><a href="/SurveyProject/GatherData?id=<%=stuid%>"><%=stuid%></a>	</li><br>
		<%
			}
		%>

<div id="ttp">
<a href="https://www2.gmu.edu">
<img  border="0" alt="GMU LOGO" src="gmulogo.png" width="100" height="100" title="Click here to visit the GMU website" align="right" >
</a>
</div>
Content created by Veda Gaddam
</body>
</html>		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		