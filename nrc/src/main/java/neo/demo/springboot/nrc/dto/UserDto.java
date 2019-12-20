package neo.demo.springboot.nrc.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Null;
import java.util.Set;

@Data
@Builder
public class UserDto {
    private Long userId;
    private String userName;
    @Null
    private String motherName;
    @Null
    private String fatherName;

    private Set<String> siblingsNames;

    private Set<String> spousesNames;

    private Set<String> childrenName;

    private String city;
}
