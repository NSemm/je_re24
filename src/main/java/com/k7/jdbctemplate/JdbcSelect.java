package com.k7.jdbctemplate;

import com.k7.dto.Note;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class JdbcSelect {
    QueryControl queryControl = new QueryControl();
    JdbcTemplate dbNote = queryControl.createConnectionJdbs(
            "jdbc:postgresql://localhost:5432/notes",
            "postgres",
            "12345678");

    public List<Note> getAll() throws SQLException {
        String noteAll = "SELECT id,name,description,ctime FROM notes";
        RowMapper noteMapper = rs -> {
            Note note = new Note();
            note.setName(rs.getString("name"));
            note.setDescription(rs.getString("description"));
            note.setCtime(rs.getTimestamp("ctime"));
            return note;
        };

        List<Note> noteList = dbNote.query(noteAll, noteMapper);
        return noteList;

    }

    public void addNote(Note note) throws SQLException {
        String noteInsert = "INSERT INTO notes (name,description,ctime) " +
                "VALUES " +
                "(?,?,?)";
        Condition conditionsAddNote = new Condition();
        conditionsAddNote.set(note.getName());
        conditionsAddNote.set(note.getDescription());
        conditionsAddNote.set(LocalDateTime.now());
        dbNote.update(noteInsert, conditionsAddNote.getList());
    }
    public void removeNote(int id) throws SQLException {
        String noteDelete = "DELETE FROM notes WHERE id = ?";
        Condition conditionsDeleteContact = new Condition();
        conditionsDeleteContact.set(id);
        dbNote.update(noteDelete, conditionsDeleteContact.getList());
    }
}
