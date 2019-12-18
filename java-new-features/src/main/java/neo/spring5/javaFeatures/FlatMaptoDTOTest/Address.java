package neo.spring5.javaFeatures.FlatMaptoDTOTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private int roomNo;
    private String buildingName;
    private String area;
    private String city;
}
