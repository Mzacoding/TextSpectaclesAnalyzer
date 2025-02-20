 
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"
        errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome </title>
    </head>
    <body>
         
    <h2> Text Spectacles Outcome</h2>
        
       
    <%
    Map<String,Integer> words=(Map<String,Integer>  )request.getAttribute("wordsOccurenceMap");
     for(Map.Entry<String,Integer>word:words.entrySet()){
      %>
      <p><%= word.getKey()%> has occurred <%=word.getValue() %> times</p> 
      <%}%>
    
    
    <p>Please  click  <a href="menu.html">menu</a>   to try again or Please  click  <a href="index.html">main</a>   to go back to main page</p>
    </body>
</html>
