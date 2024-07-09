package lab13.XIII1;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// Notas:
// Não altere o código apresentado na alinea 1
// Deve completar o código das alineas 2 e 3
// Pode comentar código para garantir que vai executando parcialmente


// Adapter OldJeep vs Jeep
// (State)
// Iterator
// Bridge/Strategy/"""Visitor"""
// Observer


// Ler o guião com atenção, porque a ler à pressa, pode escapar alguma coisa que seria de caras um padrão, por exeemplo o Singleton, basta uma coisinha ou outra diz logo que é um Singleton

// Escrever os padrões todos de cabeça num papel
// Ler o enunciado e apontar de ínicio os padrões encontrados

public class XIII1 {
	// No 2, alinea 1, Criar uma classe que tem um metodo que retorna um arraylist de produtos

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("pds2022.txt"));
		test(System.out); // executa e escreve na consola
		fl.println(System.getProperty("user.dir"));
		fl.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		test(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) {
		question1(out);
		question2(out);
		question3(out);
	}

	private static void question1(PrintStream out) {
		out.println("\nQuestion 1) ----------------------------------\n");
		ToShare market = new ToShare();
		Product[] cars = {
			new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
			new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
			new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
			new Car("BB44ZB", "Ford Mustang, Red, 2021", 150), 
		};
		for (Product item : cars) 
			market.add(item);

		out.println("--- All Products :");
		for (Product item : market.getProducts())
			out.println(item);		
	
		Client u1 = new Client("187", "Peter Pereira");
		Client u2 = new Client("957", "Anne Marques");
		Client u3 = new Client("826", "Mary Monteiro");
		market.share("ZA11ZB", u1);
		market.share(cars[2], u2);
		market.share("BB44ZB", u3);

		out.println("--- Shared Products :\n" + market.sharedProducts());
		market.giveBack(cars[0]);
		market.giveBack("BB44ZB");
		out.println("--- Shared Products :\n" + market.sharedProducts());
		
		market.remove("ZA11ZB");
		OldJeep oj = new OldJeep("JJ0011;Some old SUV;88.5"); // assume "code;description;points"
		market.add(new Jeep(oj));
		out.println("--- All Products :");
		for (Product item : market)
			out.println(item);	
	}

	private static void question2(PrintStream out) {
		out.println("\nQuestion 2 (output example) ----------------------------------\n");

		ToShare market = new ToShare();

		Product[] cars = {
			new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
			new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
			new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
			new Car("BB44ZB", "Ford Mustang, Red, 2021", 150), 
		};

		market.setReader(new ListReader(cars));
		market.readFrom();

		market.setReader(new FileReader("products.txt")); 
		market.readFrom();

		out.println("--- All Products ---\nTotal: " + market.totalProducts());
		for (Product item : market)
			out.println("\t"+item);
	}

	private static void question3(PrintStream out) {
		out.println("\nQuestion 3) ----------------------------------\n");
		// Completar
		Client u1 = new Client("187", "Peter Pereira");
		Client u2 = new Client("957", "Anne Marques");

		ToShare shareIt = new ToShare();

		Product[] cars = {
				new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
				new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
				new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
				new Car("BB44ZB", "Ford Mustang, Red, 2021", 150),
		};
		for (Product item : cars) {
			shareIt.add(item);
		}

		out.println("Shared products: " + shareIt.sharedProducts());
		shareIt.share("ZA11ZB", u1); 	// true
		shareIt.share("ZA11ZB", u2);  	// false (já está emprestada)

		out.println("Shared products: " + shareIt.sharedProducts());
		shareIt.giveBack("ZA11ZB");  	// true
		out.println("Shared products: " + shareIt.sharedProducts());
		shareIt.giveBack("ZA11ZB");  	// true
		out.println("Shared products: " + shareIt.sharedProducts());
	}
}
