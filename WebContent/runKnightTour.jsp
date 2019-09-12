<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import ="java.util.ArrayList" %>
 <%@ page import ="com.prog32758.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%= request.getAttribute("title") %></title>

<style>
	.container{
	 width:80%;
	 margin: 0 auto;
	 text-align: center;
	}
	
	table {
    	border-collapse: collapse;
    	margin: auto;
	}

	table, th, td {
    	border: 1px solid black;
	}
	td{
		height: 30px;
		width:30px;
		text-align: center;
	}
	.trial{
		width: 100%;
		justify-content: center;
	}
</style>
</head>
<body>
<div class="container">
<h2><%= request.getAttribute("title") %></h2>
<% ArrayList<Knight> knights = (ArrayList<Knight>) request.getAttribute("knights"); 

	for(int i = 0; i < knights.size(); i++){
		Knight knight = knights.get(i);
		int[][] board = knight.getBoard();
		
		out.println("<div class='trial'>");
		out.println("<h4>Trial " + (i+1) +  ": The Knight was able to successfully touch " + knight.getStep() + " squares.</h4>");
		out.println("<table>");
		for(int j = 0; j < 8; j++){
			out.println("<tr>");
			for(int k = 0; k < 8; k++){
				out.print("<td>" + board[j][k] + "</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
	}

%>
</div>

</body>
</html>