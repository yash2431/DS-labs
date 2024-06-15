import java.util.Scanner;
public class Daysintoywd{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int years = days / 365;
        int remainingDays = days % 365;
        int weeks = remainingDays / 7;
        remainingDays = remainingDays % 7;
        System.out.println(years + " years " + weeks + " weeks " + remainingDays + "days");    
    }
}