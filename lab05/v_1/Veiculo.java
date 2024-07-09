package lab05.v_1;



public class Veiculo implements KmPercorridosInterface {
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private int kmstotal = 0;
	private int kmstemp = 0;

    public Veiculo(String matricula, String marca, String modelo, int potencia) {
        if(isMatriculaValida(matricula)) {
            this.matricula = matricula;
        }
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
	public void trajeto(int quilometros) {
		kmstemp = quilometros;
		kmstotal += quilometros;
	}

	@Override
	public int ultimoTrajeto() {
		return kmstemp;
	}

	@Override
	public int distanciaTotal() {
		return kmstotal;
	}

    @Override
    public String toString() {
        return "Matrícula: " + this.getMatricula() + "\nMarca: " + this.getMarca() + "\nModelo: " +this.getModelo();
    }

    public boolean isMatriculaValida(String matricula) {
        if (matricula.length() != 8 || matricula.charAt(2) != '-' || matricula.charAt(5) != '-') {
            return false;
        }

        int nums = 0, chars = 0;
 
        for (int i = 0; i < matricula.length(); i++) {
            if (Character.isLetter(matricula.charAt(i))) {
                if (matricula.charAt(i) == (matricula.toUpperCase().charAt(i))) {
                    ++chars;
                    continue;
                }
            }

            if (Character.isDigit(matricula.charAt(i))) {
                ++nums;
            }
 
            if (i == 2) {
                if (nums != 2 && chars != 2) {
                    return false;
                }
            }

            if (i == 4) {
                if ((nums != 2 || chars != 2) && (nums != 4)) {
                    return false;
                }
            }
 
        }

        if (nums == 4 && chars == 2) {
            return true;
        }
        return false;
    }
}
