package lab08.Responsabilidades;



public class TeamLeader extends Decorator {

    public TeamLeader(EmployeeInterface e) {
        super(e);
    }

    @Override
    public void start(Date startDate) {
        System.out.println("Team Leader start date: " + startDate.toString());
    }

    @Override
    public void terminate(Date terminateDate) {
        System.out.println("Team Leader terminate date: " + terminateDate.toString());
    }

    @Override
    public void work() {
        super.work();
        this.plan();
    }

    public void plan() {
        System.out.println("Team Leader is planning");
    }
    
    
}
