package Day3.src.main;
import java.util.Scanner;


public class DemoMethods {

    public static void main(String[] args) {
        
        System.out.println("Hello VS Code...");

        // Calling The Function
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        // Call Or Invoke The Method
        String result = greet(name);
        System.out.println(result);
    }


    static String greet(String name){

        return "Hello" + name;
    }

}