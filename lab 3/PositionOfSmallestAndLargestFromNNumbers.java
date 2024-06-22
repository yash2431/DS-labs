import java.util.Scanner;
public class PositionOfSmallestAndLargestFromNNumbers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int smallest = arr[0];
        int largest = arr[0];
        int posSmallest=0;
        int posLargest=0;
        for(int i=1; i<n; i++){
            if(arr[i]<smallest){
                smallest = arr[i];
                posSmallest = i;
            }   
        }
        for(int i=1; i<n; i++){
            if(arr[i]>largest){
                largest = arr[i];
                posLargest = i;
            }
        }
        System.out.println("Smallest number is:" +smallest+ "at position:" +posSmallest);
        System.out.println("Largest number is:" +largest+ "at position:" +posLargest);
    }
}