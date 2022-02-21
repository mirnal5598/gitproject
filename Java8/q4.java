import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Employee{
    String name;
    Long salary;
    String city;
    Employee(String name, Long salary, String city) {
        this.name = name;
        this.salary = salary;
        this.city = city;
    }
    public String getName(){
        return this.name;
    }
    public Long getSalary(){
        return this.salary;
    }
    public String getCity(){
        return this.city;
    }
}
public class q4 {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(10,11,12,3,14,15,6,7,8,9);
        System.out.println(l1.stream().filter(e -> e%2 == 0).collect(Collectors.toList()));
        Employee emp1 = new Employee("Mirnal Dhingra", 6600L, "Gurgaon");
        Employee emp2 = new Employee("Raj Kumar", 5000L, "Delhi");
        Employee emp3 = new Employee("Mohit Dhingra", 2000L, "Delhi");
        Employee emp4 = new Employee("Rakesh Kumar", 3000L, "Delhi");
        List<Employee> li = Arrays.asList(emp1, emp2, emp3, emp4);
        System.out.println(li.stream()
                .filter(salary->salary.getSalary()<5000)
                .filter(city->city.getCity().equals("Delhi"))
                .map(name->name.getName().split(" ")[0])
                .collect(Collectors.toList()));
    }
}