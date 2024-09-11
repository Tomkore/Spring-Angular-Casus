package Test.demo.resource;

import Test.demo.domain.HttpResponse;
import Test.demo.domain.User;
import Test.demo.dto.UserDTO;
import Test.demo.exception.ApiException;
import Test.demo.rowmapper.UsersRowMapper;
import Test.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static Test.demo.query.UserQuery.GET_USER_QUERY;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
@Slf4j
public class UserResource {
    private final UserService userService;
    private final NamedParameterJdbcTemplate jdbc;

    @PostMapping("/register")
    public ResponseEntity<HttpResponse> saveUser(@RequestBody @Valid User user){
        UserDTO userDto = userService.createUser(user);
        return ResponseEntity.created(getUri()).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("user", userDto))
                        .message("User created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> findUserById(@PathVariable("id") Long id){
        try {
            @Valid List<User> users = jdbc.query(GET_USER_QUERY, Map.of("id", id), new UsersRowMapper());
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .data(Map.of("users", users))
                            .build());
        } catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("could not fetch user");
        }
    }

    private URI getUri() {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/get/<userId>").toUriString());
    }
}
