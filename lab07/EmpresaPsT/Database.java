/**
 * @ File name: Database.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:44:36
 */

package EmpresaPsT;
// Dois tipos de objetos Employee e Empregado

// Vamos ter um adapter entre estas duas classes

// Queremos a Empregado, então vamos criar um employee adapter, que vai ter a mesma interface que empregado.
// No construtor da classe que implementa a interface que queremos vai ter referencia para o outro objeto

// O empregado vai virar a interface de employee (adaptação de emprefgado para employy) por causa do apelido vs nome
// Empregado vai para employee, ou seja, implementas employee

import java.util.Vector;

public class Database { // Data elements
    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        for (Employee e : employees) {
            if (e.getEmpNum() == employee.getEmpNum())
                return false;
        }

        employees.add(employee);
        return true;
    }

    public void deleteEmployee(long emp_num) {
        for (Employee e : employees) {
            if (e.getEmpNum() == emp_num)
                employees.remove(e);
        }
    }

    public Employee[] getAllEmployees() {
        Employee[] employees = new Employee[this.employees.size()];

        for (int i = 0; i < this.employees.size(); i++) {
            employees[i] = this.employees.get(i);
        }

        return employees;
    }
}
