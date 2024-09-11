package Test.demo.dtomapper;

import Test.demo.domain.User;
import Test.demo.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

@Component
public class UserDTOMapper {
    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
    public static User toUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
