import java.util.ArrayList;

public class Insurance {
    private static ArrayList<Person> persons = new ArrayList<Person>();

    public static ArrayList<Person> regist(Person p) {
        persons.add(p);
        System.out.println("Person insurance activated: " + p.getName());
        return persons;
    } 
}
