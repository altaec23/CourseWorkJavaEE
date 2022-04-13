package ru.alon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alon.model.Jedi;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class JediDaoJdbcTemplateImpl implements JediDao {
    private final JdbcTemplate template;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public static final String SQL_SELECT_JEDI = "select * from jedi where first_name = ?";
    public static final String SQL_SELECT_JEDI_BY_ID = "select * from jedi where id = :id";
    public static final String SQL_INSERT = "insert into jedi (first_name,last_name) values (:firstName,:lastName)";

    @Autowired
    public JediDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<Jedi> find(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<Jedi> users = namedParameterJdbcTemplate.query(SQL_SELECT_JEDI_BY_ID, params, jediRowMapper);
        if (users.isEmpty()) {
            return Optional.empty();

        }
        return Optional.of(users.get(0));
    }

    private RowMapper<Jedi> jediRowMapper = (ResultSet rs, int i) -> Jedi.builder().id(rs.getInt("id"))
            .firstName(rs.getString("first_name"))
            .lastName(rs.getString("last_name"))
            .build();

    @Override
    public void save(Jedi model) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", model.getFirstName());
        params.put("lastName", model.getLastName());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    @Override
    public List<Jedi> findAllByJediName(String firstName) {
        return template.query(SQL_SELECT_JEDI, new JediMapper(), firstName);
    }

    static class JediMapper implements RowMapper<Jedi> {

        @Override
        public Jedi mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Jedi.builder().id(rs.getInt("id"))
                    .firstName(rs.getString("first_name"))
                    .lastName(rs.getString("last_name"))
                    .build();
        }
    }
}
