package Test.demo.repository.Implementation;

import Test.demo.domain.Role;
import Test.demo.exception.ApiException;
import Test.demo.repository.RoleRepository;
import Test.demo.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Collection;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Map;

import static Test.demo.enumeration.RoleType.ROLE_USER;
import static Test.demo.query.RoleQuery.*;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImplementation implements RoleRepository<Role> {

    private final NamedParameterJdbcTemplate jdbc;


    @Override
    public Role create(Role data) {
        return null;

    }

    @Override
    public Collection list(int page, int pageSize) {
        return null;
    }

    @Override
    public Role get(long id) {
        return null;
    }

    @Override
    public Role update(Role data) {
        return null;
    }

    @Override
    public Boolean delete(long id) {
        return null;
    }

    @Override
    public void addRoleToUser(long userId, String roleName) {
        log.info("Add role {} to user {}", roleName, userId);
        try{
            Role role = jdbc.queryForObject(SELECT_ROLE_BY_NAME_QUERY, Map.of("roleName", roleName), new RoleRowMapper());
            jdbc.update(INSERT_ROLE_TO_USER_QUERY, Map.of("userId", userId, "roleId", requireNonNull(role).getId()));
        }catch (EmptyResultDataAccessException exception){
            log.error(exception.getMessage());
            throw new ApiException("Role not found:" + roleName);
        } catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("An error occurred, please try again");
        }
    }

    @Override
    public Role getRoleByUserId(long userId) {
        return null;
    }

    @Override
    public Role getRoleByEmail(String email) {
        return null;
    }

    @Override
    public void updateUserRole(long userId, String roleName) {

    }
}
