package lab05.v_1;

public class VehicleFactory {

    public static Motociclo createMotociclo(String matricula, String marca, String modelo, int potencia, String tipo) {
        return new Motociclo(matricula, marca, modelo, potencia, tipo);
    }

    public static AutomovelLigeiro createAutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String numQuadro, int capacidadeBagageira) {
        return new AutomovelLigeiro(matricula, marca, modelo, potencia, numQuadro, capacidadeBagageira);
    }

    public static Taxi createTaxi(String matricula, String marca, String modelo, int potencia, String numQuadro, int capacidadeBagageira, String numLicenca) {
        return new Taxi(matricula, marca, modelo, potencia, numQuadro, capacidadeBagageira, numLicenca);
    }

    public static PesadoPassageirosEletrico createPPEletrico(String matricula, String marca, String modelo, int potencia, int peso, String numQuadro, int numPassageiros, int autonomiaTotal) {
        return new PesadoPassageirosEletrico(matricula, marca, modelo, potencia, peso, numQuadro, numPassageiros, autonomiaTotal);

    }

    public static AutomovelLigeiroEletrico createALEletrico(String matricula, String marca, String modelo, int potencia, String numQuadro, int capacidadeBagageira, int autonomiaTotal) {
        return new AutomovelLigeiroEletrico(matricula, marca, modelo, potencia, numQuadro, capacidadeBagageira, autonomiaTotal);
    }

    public static PesadoMercadorias createPesadoMercadorias(String matricula, String marca, String modelo, int potencia, String numQuadro, int capacidadeBagageira, int pesoBruto) {
        return new PesadoMercadorias(matricula, marca, modelo, potencia, numQuadro, capacidadeBagageira, pesoBruto);
    }

    public static PesadoPassageiros createPesadoPassageiros(String matricula, String marca, String modelo, int potencia, int capacidadeBagageira, String numQuadro, int numPassageiros) {
        return new PesadoPassageiros(matricula, marca, modelo, potencia, numQuadro, capacidadeBagageira, numPassageiros);
    }


}
