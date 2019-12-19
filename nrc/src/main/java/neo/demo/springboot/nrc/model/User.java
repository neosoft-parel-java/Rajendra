package neo.demo.springboot.nrc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne
    private User mother;

    @OneToOne
    private User father;

    @OneToMany
    private List<User> siblings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserSpouse> spouses;

    @OneToMany
    private List<User> children;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAddress> addressList;
}