package neo.demo.springboot.nrc.services;

import neo.demo.springboot.nrc.model.Address;
import neo.demo.springboot.nrc.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
