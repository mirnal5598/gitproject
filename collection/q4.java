import java.util.HashMap;
import java.util.Map;

class Employee{
    String name, designation;
    int age, salary;
    public Employee(String name, String designation, int age, int salary){
        this.name=name;
        this.designation=designation;
        this.age=age;
        this.salary=salary;
    }
    @Override
    public String toString(){
        return "Employee as key: "+name+" "+designation+"  salary as value: "; 
    }
}
public class q4 {
    public static void main(String[] args) {
        HashMap<Employee, Integer> emp=new HashMap<>();
        Employee e=new Employee("Mirnal", "Software Engineer", 23, 660000);
        emp.put(new Employee("Raj", "Software Engineer", 23,600000),600000);
        emp.put(new Employee("Rakesh", "Manager", 23, 600000), 600000);
        emp.put(new Employee("Sonu", "Cloud Engineer", 23, 600000), 600000);
        emp.put(e, e.salary);

        for(Map.Entry<Employee, Integer> m: emp.entrySet())
        System.out.println(m.getKey()+" "+m.getValue());
    }
}
