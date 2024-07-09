
/**
 * @ File name: AdvancedPrinterInterface.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 18:04:23
 */

import java.util.List;

public interface AdvancedPrinterInterface {
    public int print(Document doc);

    public List<Integer> print(List<Document> docs);

    public void showQueuedJobs();

    public boolean cancelJob(int jobId);

    public void cancelAll();
}
