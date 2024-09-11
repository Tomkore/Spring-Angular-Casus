package Test.demo.resource;

import Test.demo.domain.HttpResponse;
import Test.demo.domain.User;
import Test.demo.exception.ApiException;
import Test.demo.rowmapper.UsersRowMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static Test.demo.query.UsersQuery.GET_USERS_QUERY;


@RestController
@RequestMapping(path="")
@RequiredArgsConstructor
@Slf4j

public class UsersResource {
    private final NamedParameterJdbcTemplate jdbc;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUsers() {
        try{
            @Valid List<User> users = jdbc.query(GET_USERS_QUERY, Map.of(), new UsersRowMapper());
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                    .data(Map.of("users", users))
                    .build());
        } catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("could not fetch users");
        }
    }

}
