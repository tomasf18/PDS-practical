import java.util.ArrayList;

public class SocialSecurity {
    private static ArrayList<Person> persons = new ArrayList<Person>();
    
    public static void regist(Person p) {
        persons.add(p);
        System.out.println("Person registered in Social Security: " + p.getName());
    } 
}
