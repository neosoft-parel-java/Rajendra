package neo.demo.springboot.nrc.repositories;

import neo.demo.springboot.nrc.model.UserSpouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpouseRepository extends JpaRepository<UserSpouse, Long> {

}
