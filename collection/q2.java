import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable <Employee>{
    int age; 
    double salary;
    String name;

    public Employee(String name, int age, double salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    public int compareTo (Employee that){
        return this.name.compareTo(that.name);
    }
    public String toString(){
        return "Name: "+name+" Age: "+age+" salary: "+salary;
    }
}
public class q2 {
    public static void main(String[] args) {
        
        ArrayList<Employee> e1=new ArrayList<Employee>();
        e1.add(new Employee("Mirnal Dhingra", 23, 660000));
        e1.add(new Employee("Mohit Dhingra", 29, 600000));
        e1.add(new Employee("Raj Yadav", 21, 360000));
        e1.add(new Employee("Rakesh Kumar", 22, 440000));
        e1.add(new Employee("Sonu Kumar", 26, 450000));
        e1.add(new Employee("karan Kumar", 30, 850000));
        
        Collections.sort(e1);
        for(Employee i: e1){
        System.out.println(i);
        }
    }
}
