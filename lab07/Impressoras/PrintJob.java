/**
 * @ File name: PrintJob.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 19:54:50
 */

public class PrintJob implements Runnable {
    private Document document;

    private static int nextJobId = 0;

    private int jobId;

    public PrintJob(Document document) {
        this.document = document;
        this.jobId = nextJobId++;
    }

    public int getJobId() {
        return this.jobId;
    }

    public Document getDocument() {
        return this.document;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Running
            System.out.println("Finished Job " + this.jobId + ": \"" + this.document.toString() + "\"");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "  * Job " + this.jobId + ": \"" + this.document.toString() + "\"";
    }
}
