import java.util.Scanner;
public class Secondsintohms{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Seconds:");
        int s = sc.nextInt();
        int h = s/3600;
        int m = (s%3600)/60;
        int sec = s%60;
        System.out.println("Total hours:"+h+"Total minutes:"+m+"Total Seconds:"+sec);
        
    }

}