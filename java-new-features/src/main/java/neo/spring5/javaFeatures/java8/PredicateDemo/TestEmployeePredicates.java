package neo.spring5.javaFeatures.java8.PredicateDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static neo.spring5.javaFeatures.java8.PredicateDemo.EmployeePredicates.*;

public class TestEmployeePredicates {

    public static void main(String[] args) {

        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,45,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,26,"F","Cristine","Maria");
        Employee e6 = new Employee(6,13,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,68,"M","Alex","Gussin");
        Employee e9 = new Employee(9,13,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = new ArrayList<Employee>(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));

        System.out.println("i) "+ filterEmployees(employees, isAdultMale()) );

        System.out.println("ii) "+ filterEmployees(employees, isAdultFemale()) );

        System.out.println("iii) "+ filterEmployees(employees, isAgeMoreThan(35)) );

        //Employees other than above collection of "isAgeMoreThan(35)"
        //can be get using negate()
        System.out.println("iv) "+ filterEmployees(employees, isAgeMoreThan(35).negate()));

        System.out.println(" sort : "+ sortAsc(employees));
    }

    public static List<Employee> sortAsc(List<Employee> employeeList){
        employeeList.sort(Comparator.comparing(Employee::getId));
        employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));

        return employeeList;
    }
}

/*
OUTPUT :
       i) [1 - 23, 3 - 43, 4 - 26, 8 - 79, 10 - 45]
      ii) [5 - 19, 7 - 68]
     iii) [3 - 43, 7 - 68, 8 - 79, 10 - 45]
      iv) [1 - 23, 2 - 13, 4 - 26, 5 - 19, 6 - 15, 9 - 15]
 */