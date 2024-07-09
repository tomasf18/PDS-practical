package lab13.XIII1;

public class Client {
    private String code;
    private String name;

    public Client(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return "Client [number=" + code + ", name=" + name + "]"; 
    }

    public void update(String notification) {
        System.out.printf("'%s' says -> Received notification: '%s'\n", this.toString(), notification);
    }
}
