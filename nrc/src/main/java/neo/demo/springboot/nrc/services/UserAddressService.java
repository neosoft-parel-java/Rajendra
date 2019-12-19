package neo.demo.springboot.nrc.services;

import neo.demo.springboot.nrc.model.UserAddress;

import java.util.List;

public interface UserAddressService {
    UserAddress save(UserAddress userAddress);
    UserAddress findById(Long id);
    List<UserAddress> findAll();
    void deleteById(Long id);
}
