package neo.spring5.javaFeatures.java8.PredicateDemo;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {

    // All Employees who are male and age more than 21
    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }

    // All Employees who are female and age more than 18
    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }

    // All Employees whose age is more than a given age
    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }

    //
    public static List<Employee> filterEmployees (List<Employee> employees,
                                                  Predicate<Employee> predicate)
    {
        return employees.stream()
                .filter( predicate )
                .collect(Collectors.<Employee>toList());
    }
}
