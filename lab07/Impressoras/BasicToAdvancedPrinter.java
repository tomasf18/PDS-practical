/**
 * @ File name: BasicPrinter.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 18:04:36
 */

import java.io.FileWriter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;

public class BasicToAdvancedPrinter implements AdvancedPrinterInterface {

    private AdvancedPrinter advancedPrinter;

    public BasicToAdvancedPrinter() {
        this.advancedPrinter = new AdvancedPrinter();
    }


    public int print(Document doc) {
        return advancedPrinter.print(doc);
    }

    public List<Integer> print(List<Document> docs) {
        return advancedPrinter.print(docs);
    }
    
    // Converter para ser usado da mesma forma que AdvancedPrinter
    public boolean print(String[] content) {
        String filePath = "doc" + content.length + ".txt";

        StringBuilder sb = new StringBuilder();
            for (String word : content)
                sb.append(word + " ");
        String texto = sb.toString();   
        
        try (FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(texto);
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
            return false;
        }

        print(new Document(filePath));
        return true;
    }

    public void showQueuedJobs() {
        advancedPrinter.showQueuedJobs();
    }

    public boolean cancelJob(int jobId) {
        return advancedPrinter.cancelJob(jobId);
    }

    public void cancelAll() {
        advancedPrinter.cancelAll();
    }
}
