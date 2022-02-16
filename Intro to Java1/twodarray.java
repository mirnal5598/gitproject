import java.util.Scanner;
public class twodarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[][]={{1,3,5},{3,5,6},{4,6,1}};
    
        int colSum=0;
        int rowSum=0;
        int row, col,count=0;
        for(int i=0; i<3; i++){
            row=col=0;
            count++;
            for(int j=0; j<3; j++){
                col+=arr[j][i];    
                colSum+=arr[j][i];
                row+=arr[i][j];    
                rowSum+=arr[i][j];
            }
            System.out.println("Sum of column "+count+": "+col+"\nSum of row "+count+": "+row);
        }
        System.out.println("Sum of all columns: "+colSum+" "+"Sum of all rows: "+rowSum);
    }
}
