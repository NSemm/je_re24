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

public class MyNotes2 extends JsonServlet {
    private JdbcSelect jdbcSelect = UberFactory.instance().getJdbcSelect();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Note note = readJson(Note.class, req);
        try {
            jdbcSelect.removeNote(2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
