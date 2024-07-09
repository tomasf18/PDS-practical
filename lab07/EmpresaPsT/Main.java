/**
 * @ File name: Main.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 17:35:03
 */

package EmpresaPsT;

import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Registos registos = new Registos();

        Employee employee1 = new Employee("John", 1, 1000);
        Employee employee2 = new Employee("Mary", 2, 2000);
        Employee employee3 = new Employee("Joseph", 3, 3000);

        Empregado empregado1 = new Empregado("Filipe", "Silva", 1, 1000);
        Empregado empregado2 = new Empregado("José", "Santos", 2, 2000);
        Empregado empregado3 = new Empregado("Maria", "Costa", 3, 3000);

        database.addEmployee(employee1);
        database.addEmployee(employee2);
        database.addEmployee(employee3);

        registos.insere(empregado1);
        registos.insere(empregado2);
        registos.insere(empregado3);

        ArrayList<Empregado> empregados = (ArrayList<Empregado>) registos.listaDeEmpregados();
        Vector<Employee> employees = new Vector<>();

        Employee[] aux = database.getAllEmployees();
        for (Employee e : aux) {
            employees.add(e);
        }

        System.out.println("Employees:");
        for (Employee e : employees) {
            System.out.println("Name: " + e.getName() + ", Number: " + e.getEmpNum() + ", Salary: " + e.getSalary());
        }

        System.out.println("\nEmpregados:");
        for (Empregado e : empregados) {
            System.out.println("Nome: " + e.nome() + ", Apelido: " + e.apelido() + ", Código: " + e.codigo()
                    + ", Salário: " + e.salario());
        }

        Company company = new Company(employees, empregados);

        Employee employee4 = new Employee("Elis", 5, 1000);
        Employee employee5 = new Employee("Julia", 1, 2000);
        Employee employee6 = new Employee("Jim", 6, 3000);

        Empregado empregado4 = new Empregado("Rodrigo", "Silva", 7, 1000);
        Empregado empregado5 = new Empregado("Marta", "Santos", 8, 2000);
        Empregado empregado6 = new Empregado("Gonçalo", "Costa", 9, 3000);

        System.out.println("\nAdding employee4: " + company.addEmployee(employee4));
        System.out.println("Adding employee5: " + company.addEmployee(employee5));
        System.out.println("Adding employee6: " + company.addEmployee(employee6));

        System.out.println("Adding empregado4: " + company.addEmployee(empregado4));
        System.out.println("Adding empregado5: " + company.addEmployee(empregado5));
        System.out.println("Adding empregado6: " + company.addEmployee(empregado6));

        Employee[] allEmployees = company.getAllEmployees();

        System.out.println("\nAll employees:");
        for (Employee e : allEmployees) {
            System.out.println("Name: " + e.getName() + ", Number: " + e.getEmpNum() + ", Salary: " + e.getSalary());
        }

    }
}
