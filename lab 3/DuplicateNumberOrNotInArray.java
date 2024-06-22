import java.util.Scanner;
public class DuplicateNumberOrNotInArray{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of an array:");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            }
            boolean flag = false;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    if(arr[i] == arr[j]){
                        System.out.println("Duplicate number is: "+arr[i]);
                        flag = true;
                        break;
                        }
                        }
                        if(flag){
                            break;
                        }
                    }
                    if(!flag){
                        System.out.println("No duplicate number found");
                    }
                }
        }