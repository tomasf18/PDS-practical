package lab08.Responsabilidades;



public class Manager extends Decorator {

    public Manager(EmployeeInterface e) {
        super(e);
    }
  
    @Override
    public void start(Date startDate) {
        System.out.println("Manager start date: " + startDate.toString());
    }

    @Override
    public void terminate(Date terminateDate) {
        System.out.println("Manager terminate date: " + terminateDate.toString());
    }

    @Override
    public void work() {
        super.work();
        this.manage();
    }

    public void manage() {
        System.out.println("Manager is managing");
    }
      
}
