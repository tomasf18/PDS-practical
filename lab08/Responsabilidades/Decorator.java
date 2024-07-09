package lab08.Responsabilidades;



public class Decorator implements EmployeeInterface {
    private EmployeeInterface e;

    public Decorator(EmployeeInterface e) {
        this.e = e;
    }

    @Override
    public void start(Date startDate) {
        e.start(startDate);
        
    }

    @Override
    public void terminate(Date terminateDate) {
        e.terminate(terminateDate);
     
    }

    @Override
    public void work() {
        e.work();
        
    }


}
