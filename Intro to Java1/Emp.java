class Employee{
private String firstName,lastName,designation;
private int age;

public Employee(){
    System.out.println("Default Constructor");
}
public Employee(String firstName, String  lastName, String designation, int age){
    System.out.println("Second constructor: My first name is: "+firstName+" ,my last name is: "+lastName+" ,my designation is: "+designation+" ,my age is: "+age);
}
public String getfirstName(){
    return firstName;
}
public void setfirstName(String firstName){
    this.firstName=firstName;
}
public String getlastName(){
    return lastName;
}
public void  setlastName(String lastName){
    this.lastName=lastName;;
}
public String getdesignation(){
    return designation;
}
public void  setdesignation(String designation){
    this.designation=designation;;
}
public int getAge(){
    return age;
} 
public void setAge(int age){
    this.age=age;
}
public String toString(){
    return "First Name: "+getfirstName()+" Last Name: "+getlastName()+" Designation: "+getdesignation()+" Age:"+getAge();
}
}
public class Emp {
    public static void main(String[] args) {
        
        new Employee();
        Employee e=new Employee();
        e.setfirstName("Mirnal");
        e.setlastName("Dhingra");
        e.setdesignation("Software Engineer");
        e.setAge(23);

        Employee e1=new Employee(e.getfirstName(), e.getlastName(), e.getdesignation(),  e.getAge());
        System.out.println(e);
    }
}
