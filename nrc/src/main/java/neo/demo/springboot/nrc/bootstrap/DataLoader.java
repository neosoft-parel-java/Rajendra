package neo.demo.springboot.nrc.bootstrap;

import neo.demo.springboot.nrc.model.Address;
import neo.demo.springboot.nrc.model.User;
import neo.demo.springboot.nrc.model.UserAddress;
import neo.demo.springboot.nrc.model.UserSpouse;
import neo.demo.springboot.nrc.repositories.AddressRepository;
import neo.demo.springboot.nrc.repositories.UserAddressRepository;
import neo.demo.springboot.nrc.repositories.UserRepository;
import neo.demo.springboot.nrc.repositories.UserSpouseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

//@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserAddressRepository userAddressRepository;
    private final UserSpouseRepository userSpouseRepository;

    public DataLoader(UserRepository userRepository, AddressRepository addressRepository, UserAddressRepository userAddressRepository, UserSpouseRepository userSpouseRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userAddressRepository = userAddressRepository;
        this.userSpouseRepository = userSpouseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Creation of User.(ROOT)
        User user1 = new User();
        user1.setName("Walter White");
        userRepository.save(user1);

        //Creation of user's Spouse.(ROOT)
        User userSpouse = new User();
        userSpouse.setName("Skyler White");
        userRepository.save(userSpouse);

        //Added Users and user's Spouse Relation and Details.
        UserSpouse userSpouse1 = new UserSpouse();
        userSpouse1.setId(3L);
        userSpouse1.setUser(user1);
        userSpouse1.setSpouse(userSpouse);
        userSpouse1.setMarriedFrom(LocalDate.now().minusYears(25));
        userSpouse1.setMarriedUpto(LocalDate.now());
        userSpouseRepository.save(userSpouse1);

        //Setting user and spouse relation to user.
        user1.setSpouses(Collections.singleton(userSpouse1));
        userRepository.save(user1);

        //Created User's Child, and added to ROOT.
        User userChild = new User();
        userChild.setName("WalterJr White");
        userRepository.save(userChild);

        //Setting Children and spouses to User.
        user1.setChildren(Collections.singleton(userChild));
        user1.setSpouses(Collections.singleton(userSpouse1));
        userRepository.save(user1);
        System.out.println("########## - Added User - ##########");

        //Setting father and mother to Children.
        userChild.setFather(user1);
        userChild.setMother(userSpouse);
        userRepository.save(userChild);

        //Creating an Address.
        Address address1 = new Address();
        address1.setArea("Parel");
        address1.setCity("Mumbai");
        addressRepository.save(address1);
        System.out.println("########## - Added Address - ##########");

        // Mapping address and user.
        UserAddress userAddress = new UserAddress(2L, user1, address1, LocalDate.now().minusYears(2), LocalDate.now());
        userAddressRepository.save(userAddress);
        System.out.println("########## - Added UserAddress - ##########");

        user1.setAddressList(Collections.singleton(userAddress));
        userRepository.save(user1);

    }
}
