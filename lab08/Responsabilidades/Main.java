package lab08.Responsabilidades;



public class Main {
    public static void main(String[] args) {
        Date startDate1 = new Date(14, 4, 2024);
        Date terminDate = new Date(14, 4, 2025);
        EmployeeInterface e = new Employee();

        e.start(startDate1);
        e.terminate(terminDate);
        e.work();

        
        System.out.println("\n ==== Wrapping with TeamMember ==== \n");

        Date startDate3 = new Date(12, 7, 2031);
        Date terminDate3 = new Date(12, 9, 2032);
        EmployeeInterface tm = new TeamMember(e);
        tm.start(startDate3);
        tm.terminate(terminDate3);
        tm.work();
        
        System.out.println("\n ==== Wrapping with TeamLeader ==== \n");
        
        Date startDate4 = new Date(1, 5, 2022);
        Date terminDate4 = new Date(31, 5, 2023);
        EmployeeInterface tl = new TeamLeader(tm);
        tl.start(startDate4);
        tl.terminate(terminDate4);
        tl.work();
        
        System.out.println("\n ==== Wrapping with Manager ==== \n");
    
        Date startDate2 = new Date(21, 3, 2017);
        Date terminDate2 = new Date(21, 3, 2018);
        EmployeeInterface m = new Manager(tl);
        m.start(startDate2);
        m.terminate(terminDate2);
        m.work();

    }
}
