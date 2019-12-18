package neo.demo.springboot.nrc.services;

import neo.demo.springboot.nrc.model.Address;

import java.util.List;

public interface AddressService {
    Address save(Address address);
    Address findById(Long id);
    List<Address> findAll();
    void deleteById(Long id);
}
