package lab08.Responsabilidades;




public class TeamMember extends Decorator {

    public TeamMember(EmployeeInterface e) {
        super(e);
    }

    @Override
    public void start(Date startDate) {
        System.out.println("Team Member start date: " + startDate.toString());
    }

    @Override
    public void terminate(Date terminateDate) {
        System.out.println("Team Member terminate date: " + terminateDate.toString());
    }

    @Override
    public void work() {
        super.work();
        this.colaborate();
    }

    public void colaborate() {
        System.out.println("Team Member is colaborating");
    }
    
}
