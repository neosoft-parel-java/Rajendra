package neo.demo.springboot.nrc.services;

import neo.demo.springboot.nrc.model.UserAddress;
import neo.demo.springboot.nrc.repositories.UserAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    private final UserAddressRepository userAddressRepository;

    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public UserAddress save(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public UserAddress findById(Long id) {
        return userAddressRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserAddress> findAll() {
        return userAddressRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userAddressRepository.deleteById(id);
    }
}
