package neo.demo.springboot.nrc.services;

import neo.demo.springboot.nrc.dto.UserDto;
import neo.demo.springboot.nrc.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
    UserDto getUserInfo(Long id);
}
