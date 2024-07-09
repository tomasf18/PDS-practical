/**
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-05-20 15:42:26
 */

package ex2;

class Programmer extends Employee {
    public Programmer(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}
}
