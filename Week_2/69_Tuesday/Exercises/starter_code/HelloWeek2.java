// JAVADOC :
// TODO :  Create HelloWeek2.java with public class HelloWeek2
// Implement public static void main(String[] args):
   // - If args.length >= 1, greet: `Hello, <args[0]>!`
   // - Else greet: `Hello, trainee!`
   // - Print one line showing Runtime version, e.g. `Runtime.version()` or `System.getProperty("java.version")`


public class HelloWeek2 {
    

    
    public static void main(String[] args) {

        System.out.println(" \n\n");
        
        if (args.length>1) {
            System.out.println("Hello, <args[0]>");
        } else {
            System.out.println("Hello, Trainee");
        }


        // Print 1 line showing Runtime version
        System.out.println(Runtime.version());
        System.out.println(System.getProperty("java.version"));
        System.out.println(" \n\n");

    }
}
