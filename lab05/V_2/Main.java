/**
 * @ File name: Main.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-03-18 15:56:39
 */


package lab05.V_2;

public class Main {
    public static void main(String[] args) { 
        final int MENUS = 4; 
        Portion[] menu = new Portion[MENUS]; 
        menu[0] = PortionFactory.create("Beverage",Temperature.COLD); 
        menu[1] = PortionFactory.create("Meat",Temperature.WARM); 
        menu[2] = PortionFactory.create("Beverage",Temperature.WARM); 
        menu[3] = PortionFactory.create("Meat",Temperature.COLD); 
 
        System.out.println("---- Thank you for choosing your meal! ----"); 
        for (Portion p : menu) 
            System.out.println(p); 
 
        Container[] containers = new Container[MENUS]; 
        for (int m = 0; m < MENUS; m++) { 
            containers[m] = ContainerFactory.create(menu[m]); 
        } 
 
        System.out.println("---- Take the packages: ----"); 
        for (Container c : containers) { 
            System.out.println(c); 
        } 
    }
}
