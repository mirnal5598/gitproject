interface Lambda{
    public void display(int a, int b);
}
public class q2 {
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    } 
    public static int multiply(){
        return a*b;
    }
    public static void main(String[] args) {
        Lambda l=new q2()::add;
        System.out.println(l.display(4, 5));
        Lambda l1=new q2()::sub;
        System.out.println(l1.display(5, 3));
        Lambda l2=q2::multiply;
        System.out.println(l2.display(3, 5));
    }
}
