package neo.demo.springboot.nrc.services;

import neo.demo.springboot.nrc.model.UserSpouse;

import java.util.List;

public interface UserSpouseService {

    UserSpouse save(UserSpouse userSpouse);
    UserSpouse findById(Long id);
    List<UserSpouse> findAll();
    void deleteById(Long id);
}
