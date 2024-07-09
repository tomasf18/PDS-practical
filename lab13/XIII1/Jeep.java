package lab13.XIII1;

public class Jeep implements Product {
    private String code;
    private String description;
    private double points;
    private OldJeep oj;

    public Jeep(OldJeep oj) {
        this.oj = oj;
        String[] data = oj.getData().split(";");
        code = data[0];
        description = data[1];
        points = Double.parseDouble(data[2]) ;
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
        return String.format("Jeep [code=%s, descr=%s, points=%s]", code, description, points);
    }
    
}
