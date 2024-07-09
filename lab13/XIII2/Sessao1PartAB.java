package lab13.XIII2;

public class Sessao1PartAB {
    public static void main(String[] args) {
        Ana a = new Ana("Ana");
        System.out.println(a.getName());
    }   
}

class Ana {
    private String name;
    public Ana(String nome) {
        name = nome;
    }

    public String getName() {
        return name;
    }
}
