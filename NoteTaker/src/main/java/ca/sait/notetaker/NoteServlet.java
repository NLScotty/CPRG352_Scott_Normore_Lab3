/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.notetaker;

import ca.sait.notetaker.javabeans.Note;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Scott
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/note"})
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getQueryString();
        
        if (query != null && query.contains("edit")){
            String path = getServletContext().getRealPath("/WEB-INF/noteFile.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            String title = br.readLine();
            String contents = br.readLine();

            Note note = new Note(title,contents);

            request.setAttribute("note", note);
            
            getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp").forward(request,response);
        }else {
            String path = getServletContext().getRealPath("/WEB-INF/noteFile.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String title = br.readLine();
            String contents = br.readLine();

            Note note = new Note(title,contents);

            request.setAttribute("note", note);

            getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        
        System.out.println(content.replace("/n", ""));
        
        String path = getServletContext().getRealPath("/WEB-INF/noteFile.txt");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path,false)));
        pw.println(title);
        pw.println(content);
        
        pw.close();
        
        Note note = new Note(title, content);
        request.setAttribute("note",note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
    }
}
