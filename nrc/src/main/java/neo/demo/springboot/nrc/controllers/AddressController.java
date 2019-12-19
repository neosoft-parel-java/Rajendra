package neo.demo.springboot.nrc.controllers;

import neo.demo.springboot.nrc.model.Address;
import neo.demo.springboot.nrc.services.AddressService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/address")
@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{address_id}")
    public ResponseEntity<Address> getAddress(@PathVariable("address_id") Long id){
        return new ResponseEntity<>(addressService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> saveNewAddress(@Valid @RequestBody Address address){
        Address address1 = addressService.save(address);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/address/" + address1.getId());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable("addressId") Long id,
                                     @Valid @RequestBody Address address){
        Address address1 = addressService.findById(id);
        address1.setArea(address.getArea());
        address1.setCity(address.getCity());
        addressService.save(address1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable("addressId") Long id){
        addressService.deleteById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAll(){
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }
}
