import java.util.Stack;
class SpecialStack extends Stack<Integer>{
   
    public Stack<Integer> min=new Stack<>();

    public void push(int num){
        if(isEmpty() ==true){
            super.push(num);
            min.push(num);
            // for(Integer i: min){
            //     System.out.println(i);
            // }
        }
        else{
            super.push(num);
            int ele=min.pop();
            if(ele<num){
                min.push(ele);
            }
            else{
                min.push(num);
            }
        }

    }
    public Integer pop(){
        int ele=super.pop();
        int minEle=min.pop();
        min.push(minEle);
        if(ele==minEle)
        min.pop();
        return ele;
    }
    public int getMin(){
        int ele=min.pop();
        min.push(ele);
        return ele;
    }
    public Integer peek(){
       int ele=super.peek();
        return ele;
    }
}
public class q3 {
    public static void main(String[] args) {
     
        SpecialStack s=new SpecialStack();
        s.push(5);
        s.push(6);
        s.push(4);
        s.push(7);
        System.out.println("Minimum Element: "+s.getMin());
        System.out.println("Element at top: "+s.peek());
        s.push(10);
        System.out.println("Minimum Element: "+s.getMin());
        System.out.println("Element at top: "+s.peek());
        System.out.println("Element removed: "+s.pop());
        System.out.println("Element at top: "+s.peek());
        System.out.println("Minimum Element: "+s.getMin());
        s.push(1);
        System.out.println("Minimum Element: "+s.getMin());
    }
}
