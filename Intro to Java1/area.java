import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class area {
    public static double areaa(double pi, int r){
        double ans=pi*r*r;
        return ans;
    }
    public static double circumference(double pi, int r){
        double ans=2*pi*r;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        double pi=3.14;
        int radius=0;
        System.out.println("*******Menu*******\n1.Calculate Area of Circle\n2.Calculate Circumference of a Circle\n3.Exit.\n");
        
        int option =sc.nextInt();
        if(option!=3){
            System.out.println("Enter radius.");
            radius=sc.nextInt();
        }
        switch(option){
            case 1: System.out.println("Enter radius.");
                    System.out.println(areaa(pi,radius));
                    break;

            case 2: System.out.println("Enter radius.");
                   System.out.println(circumference(pi,radius));
                    break;

            case 3:break;
        }
    }
}
