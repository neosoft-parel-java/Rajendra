package neo.demo.springboot.nrc.services;

import neo.demo.springboot.nrc.model.UserSpouse;
import neo.demo.springboot.nrc.repositories.UserSpouseRepository;

import java.util.List;

public class UserSpouseServiceImpl implements UserSpouseService {

    private final UserSpouseRepository userSpouseRepository;

    public UserSpouseServiceImpl(UserSpouseRepository userSpouseRepository) {
        this.userSpouseRepository = userSpouseRepository;
    }

    @Override
    public UserSpouse save(UserSpouse userSpouse) {
        return userSpouseRepository.save(userSpouse);
    }

    @Override
    public UserSpouse findById(Long id) {
        return userSpouseRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserSpouse> findAll() {
        return userSpouseRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userSpouseRepository.deleteById(id);
    }
}
