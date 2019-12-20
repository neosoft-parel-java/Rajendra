package neo.demo.springboot.nrc.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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
    private Set<User> siblings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserSpouse> spouses;

    @OneToMany
    private Set<User> children;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserAddress> addressList;
}