package com.dily.controlers;

import com.dily.Mapper.UserMapper;
import com.dily.entities.User;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Andra on 4/11/2017.
 */
@Controller
public class UserControler extends SQLException
{

    private DataSource dataSource;
    JdbcTemplate jdbcTemplate =new JdbcTemplate();
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @RequestMapping("/number")
    @ResponseBody
    public List<User> findAllUsers() {
        UserMapper userMapper=new UserMapper();
        return this.jdbcTemplate.query( "select * from user_table", userMapper);
    }

}
