package Test.demo.service;

import Test.demo.domain.User;
import Test.demo.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);
}
