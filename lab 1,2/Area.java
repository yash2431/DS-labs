import java.util.Scanner;
public class Area{
    public static void main(String[] args){
        int a,r;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the radius of the circle:");
        r = sc.nextInt();
        a = (int) (3.14 * r * r);
        System.out.println("The area of the circle is:" +a);
    }
}
