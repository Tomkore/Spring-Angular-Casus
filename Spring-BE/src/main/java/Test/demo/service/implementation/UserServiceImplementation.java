package Test.demo.service.implementation;

import Test.demo.domain.User;
import Test.demo.dto.UserDTO;
import Test.demo.dtomapper.UserDTOMapper;
import Test.demo.repository.UserRepository;
import Test.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
