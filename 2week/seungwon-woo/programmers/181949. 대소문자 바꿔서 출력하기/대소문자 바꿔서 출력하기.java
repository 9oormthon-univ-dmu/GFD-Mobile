import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String result = "";
        char c;
        
        for(int i = 0; i < a.length(); i++){
            c = a.charAt(i);
            
            if(Character.isUpperCase(c)){
                result += Character.toLowerCase(c);
            }
            else{
                result += Character.toUpperCase(c);
            }
        }
        
        System.out.println(result);
    }
}