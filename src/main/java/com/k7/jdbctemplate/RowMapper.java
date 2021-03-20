package com.k7.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper <T> {
    T map(ResultSet rs) throws SQLException;
}
