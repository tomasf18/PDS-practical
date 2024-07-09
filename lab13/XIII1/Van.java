package lab13.XIII1;

public class Van implements Product {

    private String code;
    private String description;
    private double points;

    public Van(String code, String description, double points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double points() {
        return points;
    }

    public String toString() {
        return String.format("Van [code=%s, descr=%s, points=%s]", code, description, points);
    }
    
}
