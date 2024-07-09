/**
 * @ File name: Company.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:34:12
 */

package EmpresaPsT;

import java.util.ArrayList;
import java.util.Vector;

public class Company {
    private Vector<Employee> employees;
    private ArrayList<Empregado> empregados;

    public Company(Vector<Employee> employees, ArrayList<Empregado> empregados) {
        this.employees = employees;
        this.empregados = empregados;
    }

    public boolean addEmployee(Employee e) {
        if (exists(e))
            return false;

        employees.add(e);
        return true;
    }

    public boolean addEmployee(Empregado e) {
        Employee employee = convert(e);
        if (exists(employee))
            return false;

        employees.add(employee);
        return true;
    }

    private boolean exists(Employee e) {
        long code = e.getEmpNum();

        for (Employee employee : employees) {
            if (code == employee.getEmpNum())
                return true;
        }

        for (Empregado empregado : empregados) {
            if (code == empregado.codigo()) {
                return true;
            }
        }

        return false;
    }

    private Employee convert(Empregado e) {
        Employee employee = new Employee(e.nome(), e.codigo(), e.salario());
        return employee;
    }

    public void deleteEmployee(long emp_num) {
        for (Employee e : employees) {
            if (e.getEmpNum() == emp_num)
                employees.remove(e);
        }
    }

    public Employee[] getAllEmployees() {
        Employee[] employeesCompany = new Employee[this.employees.size() + this.empregados.size()];
        int i = 0;

        for (Employee e : employees) {
            employeesCompany[i] = e;
            i++;
        }

        for (Empregado e : empregados) {
            Employee employee = convert(e);
            employeesCompany[i] = employee;
            i++;
        }

        return employeesCompany;
    }
}
