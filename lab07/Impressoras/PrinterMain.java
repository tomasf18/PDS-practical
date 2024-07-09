/**
 * @ File name: PrinterMain.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-20 16:14:00
 */

import java.util.ArrayList;
import java.util.List;

public class PrinterMain {

    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // Adaptar tudo o que for feito em Basic Printer para Advanced Printer
        // e continuar a usar Advanced Printer de forma normal
        BasicToAdvancedPrinter printer1 = new BasicToAdvancedPrinter();
        BasicToAdvancedPrinter printer2 = new BasicToAdvancedPrinter();

        // Criar documentos e respetiva lista 
        List<Document> docs = new ArrayList<Document>();
        docs.add(new Document("text1.txt"));
        docs.add(new Document("text2.txt"));
        docs.add(new Document("text3.txt"));

        // Criar entradas para Basic Printers
        String[] longContent = {"Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit.", 
                                "Sed", "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore", 
                                "magna", "aliqua.", "Ut", "enim", "ad", "minim", "veniam,", "quis", "nostrud", 
                                "exercitation", "ullamco", "laboris", "nisi", "ut", "aliquip", "ex", "ea", "commodo", 
                                "consequat.", "Duis", "aute", "irure", "dolor", "in", "reprehenderit", "in", "voluptate", 
                                "velit", "esse", "cillum", "dolore", "eu", "fugiat", "nulla", "pariatur.", "Excepteur", 
                                "sint", "occaecat", "cupidatat", "non", "proident,", "sunt", "in", "culpa", "qui", "officia", 
                                "deserunt", "mollit", "anim", "id", "est", "al", "laborum."};

        String[] mediumContent = {"Este", "é", "um", "texto", "de", "tamanho", "médio", "para", "teste", "da", "função", 
                                  "de", "impressão", "da", "impressora.", "Ele", "contém", "algumas", "frases", "para", 
                                  "avaliar", "o", "comportamento", "do", "método."};

        
        String[] shortContent = {"Olá", "mundo!", "Este", "é", "um", "texto", "curto", "para", "teste."};


        System.out.println("\n  ========  Using Advanced Printer:  ========\n"); 
        printer1.print(docs.get(0)); // print first document only
        pause(2000); // wait for a while

        printer1.print(docs);
        printer1.showQueuedJobs();
        pause(4000); // wait for a while

        printer1.print(docs);
        printer1.cancelJob(6);
        printer1.showQueuedJobs();
        pause(4000); // wait for a while

        printer1.print(docs);
        printer1.cancelAll();
        printer1.showQueuedJobs();

        pause(2000); // wait for a while


        System.out.println("\n\n  ========  Using Basic Printer:  ========\n");
        


        printer2.print(longContent);
        pause(2000); 
        printer2.showQueuedJobs();

        printer2.print(mediumContent);
        pause(4000); 
        printer2.showQueuedJobs();

        printer2.print(shortContent);
        printer2.cancelJob(10);
        pause(1000);
        printer2.showQueuedJobs();

        printer2.print(longContent);
        printer2.cancelAll();
        printer2.showQueuedJobs();

        pause(2000); // wait for a while

    }
}
