package lab08.Responsabilidades;




public class Employee implements EmployeeInterface {

    public void start(Date startDate) {
        System.out.println("Employee start date: " + startDate.toString());
    }

    public void terminate(Date terminateDate) {
        System.out.println("Employee terminate date: " + terminateDate.toString());
    }

    public void work() {
        System.out.println("Employee is working.");
    }

}
