package com.k7;


import com.k7.dto.Note;
import com.k7.dto.NoteResponse;
import com.k7.jdbctemplate.JdbcSelect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MyNotes extends JsonServlet {
    private JdbcSelect jdbcSelect = UberFactory.instance().getJdbcSelect();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Note> noteList = jdbcSelect.getAll();
            req.setAttribute("notes", noteList);
            req.getRequestDispatcher("WEB-INF/view/ex.jsp").forward(req, resp);
            int start = req.getContextPath().length()+req.getServletPath().length();
            String id = req.getRequestURI().substring(start+1);
            if (noteList.isEmpty()) {
                NoteResponse noteResponse = new NoteResponse().setError("List is empty");
                writeJson(noteResponse, resp);
            } else {
                NoteResponse noteResponse = new NoteResponse().setStatus("ok").setNotes(noteList);
                writeJson(noteResponse, resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Note note = readJson(Note.class, req);
        try {
            jdbcSelect.addNote(note);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
