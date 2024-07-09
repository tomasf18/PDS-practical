import java.util.ArrayList;

public class Parking {

    private static ArrayList<Person> allowedPersons = new ArrayList<Person>();
    
    public static void allow(Person p) {
        allowedPersons.add(p);
        System.out.println("Allowed parking: " + p.getName());
    } 
}
