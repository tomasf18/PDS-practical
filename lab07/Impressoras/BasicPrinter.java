/**
 * @ File name: BasicPrinter.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-16 18:04:36
 */

public class BasicPrinter {

    private int inkAmount;
    private int paperAmount;

    // simula que impressora pode imprimir 4 documentos antes de terminar tinta e
    // papel
    public BasicPrinter() {
        this.inkAmount = 4;
        this.paperAmount = 4;
    }

    // As condições refletem o seguinte: "necessitam que sejam adicionados papel e tinta quando estes terminam"
    public boolean print(String[] content) {
        if (this.hasInk() && this.hasPaper()) {
            // simula duração da impressão (1 segundo)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StringBuilder sb = new StringBuilder();
            for (String word : content)
                sb.append(word + " ");
            System.out.println("Document printed: \"" + sb.toString().substring(0, Math.min(20, sb.toString().length() - 1)) + "...\"");
            this.inkAmount--;
            this.paperAmount--;
            if (this.inkAmount == 0 || this.paperAmount == 0) {
                System.out.println("Please refill printer.");
            }
            return true;
        }
        return false;
    }


    // Getters

    public boolean hasInk() {
        return this.inkAmount > 0;
    }

    public boolean hasPaper() {
        return this.paperAmount > 0;
    }

    // Refill methods

    public void addInk() {
        this.inkAmount += 4;
    }

    public void addPaper() {
        this.paperAmount += 4;
    }

    // Método auxiliar para simular a reposição de tinta e papel
    public void refill() {
        this.addInk();
        this.addPaper();
        System.out.println("Printer refilled.");
    }
}
