package com.siva.SpringJDBC.repository;

import com.siva.SpringJDBC.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienRepo    {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void  save(Alien alien ){
        String sql = "insert into alien (id,name,tech) values(?,?,?)";
        jdbcTemplate.update(sql,alien.getId(),alien.getName(),alien.getTech());
    }

    public List<Alien> findAll(){
        String sql = "select * from alien";
        RowMapper<Alien> rowMapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien = new Alien();
                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));
                return alien;
            }
        };
        List<Alien> alien = jdbcTemplate.query(sql,rowMapper);
        return  alien;
    }
}
