import java.util.ArrayList;
import java.util.Iterator;

public class q1 {
    public static void main(String[] args) {
        float sum=0;
        ArrayList<Float> al=new ArrayList<Float>();
        al.add(0.7f);
        al.add(0.17f);
        al.add(0.10f);
        al.add(0.9f);
        al.add(0.48f);
        al.add(0.12f);
        for(Iterator <Float> it=al.iterator(); it.hasNext();){
            sum+=it.next();
        }
        System.out.println(sum);
    }    
}
