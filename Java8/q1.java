@FunctionalInterface
interface Lambda1{
    public boolean greaterThan(int a, int b);
}
@FunctionalInterface
interface Lambda2{
    public int increment(int a);
}
@FunctionalInterface
interface Lambda3{
    public String concat(String a, String b);
}
@FunctionalInterface
interface Lambda4{
    public String upperCase(String a);
}
public class q1 {
    public static void main(String[] args) {
        Lambda1 a=(num1,num2)->num1>num2;
        System.out.println(a.greaterThan(3,4));
        Lambda2 b=(num)->num+1;
        System.out.println(b.increment(5));
        Lambda3 c=(s1,s2)->s1+s2;
        System.out.println(c.concat("Hello My name ", "is Mirnal"));
        Lambda4 d=(str)->str.toUpperCase();
        System.out.println(d.upperCase("hello"));
    }
}
