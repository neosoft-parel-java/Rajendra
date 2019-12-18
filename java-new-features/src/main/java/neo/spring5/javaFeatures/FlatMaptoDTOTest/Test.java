package neo.spring5.javaFeatures.FlatMaptoDTOTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        Address address = new Address(310, "Tridental", "trident", "Mumbai");
        Employee employee = new Employee(1L, "Rajendra", address);
        Stream<List> listStream = Stream.of(
                Collections.singletonList(employee.getId()),
                Collections.singletonList(employee.getName()),
                Arrays.asList( address.getRoomNo(), address.getBuildingName(), address.getArea(), address.getCity())
        );
/*
        listStream.flatMap(Collection::stream)
                .forEach(System.out::println);*/

        List<Object> list = listStream
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


    }
}
