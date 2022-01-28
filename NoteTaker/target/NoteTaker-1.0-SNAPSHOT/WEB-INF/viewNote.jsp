<%-- 
    Document   : viewNote
    Created on : Jan. 28, 2022, 8:59:15 a.m.
    Author     : Scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p>Title: ${note.title}</p>
        <p>Content: ${note.contents}</p>
        
        <a href="note?edit">Edit Note</a>
    </body>
</html>
