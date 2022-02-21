interface inter{
    public void print();
    public default void display(){
        System.out.println("Default method");
    }
}
class A implements inter{

    @Override
    public void print(){
        System.out.println("Class A print method.");
    }
    @Override
    public void display(){
        System.out.println("Class A default method");
    }
}
class B implements inter{
    @Override
    public void print(){
        System.out.println("Class B print method.");
    }
}
public class q5 {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        a.display();
        a.print();
        b.print();
    }
}
