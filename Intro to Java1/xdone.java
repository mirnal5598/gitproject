import java.util.Scanner;

public class xdone {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any text or enter XDONE to exit.");
        String text=sc.next();
        while(!text.equals("XDONE")){
            text=sc.next();
            if(text.equals("XDONE"))
            System.out.println("Your entered text is: "+text);
        }
    }
}
