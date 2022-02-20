import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Employee implements Comparable<Employee> {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age=age;
        this.salary=salary;
    }

    @Override
    public int compareTo(Employee that) {
        return this.name.compareTo(that.name);
    }
    
    public String toString(){
        return "Name: "+name+" Age: "+age+" Salary: "+salary;
    }
}

public class Q2 {

     public static void main(String args[]) {
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new Employee("Mirnal Dhingra ", 23, 660000));
        e.add(new Employee("Mohit Dhingra ", 29, 600000));
        e.add(new Employee("Raj Yadav ", 21, 360000));
        e.add(new Employee("Rakesh Kumar ", 22, 440000));
        e.add(new Employee("Sonu Kumar ", 26, 450000));
        e.add(new Employee("Karan Kumar ", 30, 850000));

        Collections.sort(e, new Comparator<Employee>(){
            @Override
            public int compare(Employee e1, Employee e2){
                return Double.compare(e1.salary, e2.salary);
            }
        });
        for(Employee i: e){
            System.out.println(i);
            }
    }

}