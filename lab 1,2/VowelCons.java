import java.util.Scanner;
public class VowelCons{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=sc.nextLine();
        int vowel=0,cons=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a' || ch=='e' ||ch=='i' || ch=='o' || ch=='u'){
                vowel++;
            }
            else{
                cons++;
            }
    }
    System.out.println("Number of vowels:" +vowel);
    System.out.println("Number of consonants:" +cons);
}
}