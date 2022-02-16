 class call{
    static int age=23;

static {
    System.out.println("My first name is Mirnal.");
}
public static void lastName(){
    System.out.println("My last name is Dhingra.");
}
 }
public class firstName {
   
    public static void main(String[] args) {
        call.lastName();
        System.out.println("My age is "+call.age+".");
        
    }
}
