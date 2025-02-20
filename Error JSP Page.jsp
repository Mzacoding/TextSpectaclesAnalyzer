 
<%@page contentType="text/html" pageEncoding="UTF-8"
        isErrorPage="true"
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>


        <h1>Error</h1>
        <% Exception erromessage = (Exception) request.getAttribute("errorMessage");%>
        <h4>Sorry, an error occurred while trying to access the page.</h4>
        <h3>Error Details: <%= erromessage.getMessage()%></h3>
        <p>Please try the following:</p>
        <ul>
            <li><a href="menu.html">Return to Menu</a></li>
            <li><a href="index.html">Return to Main Page</a></li>
        </ul>
        <button onclick="history.back()">Back to Previous Page</button>

    </body>
</html>
