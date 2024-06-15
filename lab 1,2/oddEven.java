//4.	W.A.P. to check given number is odd or even using bitwise operator.

import java.util.Scanner;

public class oddEven {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Any Numbers:");
        int num = s.nextInt();
        
        if((num & 1)==1){
            System.out.println("The Number is odd");
        }else{
            System.out.println("The Number is even");
        }
    }
}