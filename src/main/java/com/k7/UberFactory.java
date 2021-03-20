package com.k7;

import com.k7.jdbctemplate.JdbcSelect;

public class UberFactory {
    private static final UberFactory INSTANCE = new UberFactory();

    public static UberFactory instance() {
        return INSTANCE;
    }

    private JdbcSelect jdbcSelect;

    private UberFactory() {
        this.jdbcSelect = new JdbcSelect();
    }

    public JdbcSelect getJdbcSelect() {
        return jdbcSelect;
    }
}
