package neo.demo.springboot.nrc.services;

import neo.demo.springboot.nrc.dto.UserDto;
import neo.demo.springboot.nrc.model.User;
import neo.demo.springboot.nrc.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserInfo(Long id) {
//        ModelMapper modelMapper = new ModelMapper();
        User user = userRepository.findById(id).orElse(null);
//        TypeMap<User, UserDto> typeMap =
//                modelMapper.createTypeMap(User.class, UserDto.class);
//
//        typeMap.addMappings(mapper -> {
//            mapper.map(src -> src.getMother().getName(), UserDto::setMotherName);
//            mapper.map(src -> src.getFather().getName(), UserDto::setFatherName);
//            mapper.map(src -> src.getChildren().stream().map(User::getName).collect(Collectors.toSet()), UserDto::setChildrenName);
//        });
        UserDto userDto = UserDto.builder()
                .userId(user.getId())
                .userName(user.getName())
                .childrenName(user.getChildren().stream().map(User::getName).collect(Collectors.toSet()))
                .spousesNames(user.getSpouses().stream().map(userSpouse -> userSpouse.getSpouse().getName())
                        .collect(Collectors.toSet()))
                .siblingsNames(user.getSiblings().stream().map(User::getName).collect(Collectors.toSet()))
                .city(user.getAddressList().stream().map(userAddress -> userAddress.getAddress().getCity())
                        .collect(Collectors.joining()))
                .build();
        if(user.getMother()!=null) userDto.setMotherName(user.getMother().getName());
        if(user.getFather()!=null) userDto.setFatherName(user.getFather().getName());

        return userDto;
    }
}
