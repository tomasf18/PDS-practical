/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-20 15:42:22
 */

package ex2;

public class NullEmployee extends Employee {
    public NullEmployee() {
        this.name = "Unknown";
    }

    @Override
    public String getName() {
        return name;
    }
}
