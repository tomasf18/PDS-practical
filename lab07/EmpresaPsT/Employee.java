/**
 * @ File name: Employee.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:34:28
 */

package EmpresaPsT;

public class Employee {
    private String name;
    private long emp_num;
    private double salary;

    public Employee(String name, long emp_num, double salary) {
        this.name = name;
        this.emp_num = emp_num;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public long getEmpNum() {
        return emp_num;
    }

    public double getSalary() {
        return salary;
    }
}