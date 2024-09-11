package Test.demo.repository.Implementation;

import Test.demo.domain.Role;
import Test.demo.domain.User;
import Test.demo.repository.UserRepository;
import Test.demo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Collection;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import Test.demo.exception.ApiException;
import java.util.Map;

import static Test.demo.enumeration.RoleType.*;
import static java.util.Objects.requireNonNull;
import static Test.demo.query.UserQuery.*;


@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImplementation implements UserRepository<User> {
    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User create(User user) {
        if(getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw new ApiException("email already in use");
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey()).longValue());
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
            return user;
        } catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("An error occurred, please try again");
        }
    }

    @Override
    public Collection list(int page, int pageSize) {
        return null;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public Boolean delete(long id) {
        return null;
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(User user) {
        return new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("email", user.getEmail())
                .addValue("password", encoder.encode(user.getPassword()));
    }
}
