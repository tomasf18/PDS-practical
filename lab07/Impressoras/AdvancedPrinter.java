
/**
 * @ File name: AdvancedPrinter.java
 * @ Author1: Danilo Silva 113384
 * @ Modified time: 2024-04-16 19:57:31
 * @ Modified time: 2024-04-20 15:56:46
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AdvancedPrinter implements AdvancedPrinterInterface {

    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ExecutorService.html
    class PrinterService implements Runnable {
        private final LinkedBlockingQueue<PrintJob> printQueue;
        private final ExecutorService pool;

        // este serviço simula a fila de impressão e a impressão de um documento de cada
        // vez
        public PrinterService() {
            printQueue = new LinkedBlockingQueue<>();
            pool = Executors.newFixedThreadPool(1);
        }

        public void run() { // run the service
            try {
                for (;;) {
                    PrintJob j = printQueue.take();
                    pool.submit(j).get();
                }
            } catch (java.util.concurrent.RejectedExecutionException ex) {
                System.out.println("Job rejected by spool: service shutting down?");
            } catch (ExecutionException e) {
                System.out.println("Error");
                e.printStackTrace();
            } catch (InterruptedException ex) {
                this.shutdownAndAwaitTermination();
            }
        }

        public int newPrintJob(Document doc) {
            PrintJob j = new PrintJob(doc);
            printQueue.add(j);
            return j.getJobId();
        }

        public boolean cancelJob(int job) {
            for (PrintJob j : printQueue) {
                if (j.getJobId() == job) {
                    printQueue.remove(j);
                    System.out.println("Cancelled Job " + job + ": \"" + j.getDocument().toString() + "\"");
                    return true;
                }
            }
            return false;
        }

        void shutdownAndAwaitTermination() {
            pool.shutdown(); // Disable new tasks from being submitted
            try {
                // Wait a while for existing tasks to terminate
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    pool.shutdownNow(); // Cancel currently executing tasks
                    // Wait a while for tasks to respond to being cancelled
                    if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                        System.err.println("Spool did not terminate.");
                }
            } catch (InterruptedException ie) {
                // (Re-)Cancel if current thread also interrupted
                pool.shutdownNow();
                printQueue.clear();
                // Preserve interrupt status
                Thread.currentThread().interrupt();
            }
        }

        public LinkedBlockingQueue<PrintJob> getPrintQueue() {
            return printQueue;
        }

    }

    private PrinterService spool;

    public AdvancedPrinter() {
        this.spool = new PrinterService();
        new Thread(this.spool).start();
    }

    public int print(Document doc) {
        System.out.println("Spooling 1 documents.");
        return this.spool.newPrintJob(doc);
    }

    public List<Integer> print(List<Document> docs) {
        System.out.println("Spooling " + docs.size() + " documents.");
        List<Integer> jobs = new ArrayList<>();
        for (Document doc : docs) {
            jobs.add(this.spool.newPrintJob(doc));
        }
        return jobs;
    }

    public void showQueuedJobs() {
        if (this.spool.getPrintQueue().isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("No spooled jobs.");
            return;
        }
        System.out.println("Spooled jobs:");
        for (PrintJob j : this.spool.getPrintQueue()) {
            System.out.println(j.toString());
        }
        System.out.println();
    }

    public boolean cancelJob(int jobId) {
        return this.spool.cancelJob(jobId);
    }

    public void cancelAll() {
        this.spool.pool.shutdownNow();
        this.spool.printQueue.clear();
    }
}