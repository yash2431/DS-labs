import java.util.Scanner;

public class BinarySearchRecursion {
    
    public static int recursive(int arr[],int left,int right,int search){
        int middle = (left + right)/2;
        
        while(left <= right){
            if(arr[middle] == search){
                return middle;
            }
            else if(arr[middle] < search){
                return recursive(arr,left,middle-1,search);
            }
            else{
                return recursive(arr,middle+1,right,search);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array :");
        int size = sc.nextInt();
        int arr [] = new int [size];
        int left = 0, right = size-1;

        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter Element : ");
        int search = sc.nextInt();

        int ans = recursive(arr,left,right,search);
        System.out.print("recursive answer = "+ans);
    }
}