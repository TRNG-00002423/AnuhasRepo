package Day3.src.main.java.com.Revature.constructors;


public class PersonManager {

    public static void main(String[] args) {
        
        Person person = new Person("Alice", "40");
        System.out.println(person.displayPerson());

        Person Jane = new Person();

        Jane.setName("Jane");
        Jane.setAge(20);
        System.out.println("Name : "+Jane.getName());
        System.out.println(Jane.displayPerson());

    }
}
