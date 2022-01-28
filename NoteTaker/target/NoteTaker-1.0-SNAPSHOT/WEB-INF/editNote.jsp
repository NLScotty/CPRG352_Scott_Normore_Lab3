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
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="note" method="post">
            <label>Title:</label>
            <input type="text" name="title" id="title" placeholder="Title" value="${note.title}">
            <label>Content:</label>
            <input type="text" name="content" id="content" placeholder="Contents" value="${note.contents}">
            <button type="submit">Submit</button>
        </form>
        <a href="note?edit">Edit Note</a>
    </body>
</html>

