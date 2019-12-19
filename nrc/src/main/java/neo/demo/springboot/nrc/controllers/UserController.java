package neo.demo.springboot.nrc.controllers;

import neo.demo.springboot.nrc.model.User;
import neo.demo.springboot.nrc.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> userList(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        userService.save(newUser);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/api/v1/user/"+newUser.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long id,
                                           @RequestBody User user){
        User user1 = userService.findById(id);
        if(user1 != null){
            user1.setName(user.getName());
            userService.save(user1);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long id){
        userService.deleteById(id);
    }


}
