package Test.demo.rowmapper;


import Test.demo.domain.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {


    @Override
    public Role mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Role.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("title"))
                .permission(resultSet.getString("permissions"))
                .build();
    }
}
