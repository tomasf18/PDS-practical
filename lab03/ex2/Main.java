package lab03.ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input_sc = new Scanner(System.in);
        boolean cont = true;
        FlightManager flightManager = new FlightManager();
    
        while (cont) {
            System.out.print("Escolha uma opção: (H para ajuda)\n> ");
            String userInput = input_sc.nextLine();
            cont = handleUserInput(userInput, flightManager, cont);
        }
    
        System.out.println("A terminar o programa...");
        input_sc.close();
        Thread.sleep(1000);
    }
    
    private static boolean handleUserInput(String userInput, FlightManager flightManager, boolean cont) {
        String[] userInputOpt = userInput.split(" ");
        String opt = userInputOpt[0].toUpperCase();
    
        switch (opt) {
            case "H":
                if (userInputOpt.length != 1) {
                    System.err.println("ERRO: Número de argumentos inválido para opção H!\n");
                    break;
                }
                showMenu();
                break;
    
            case "I":
                handleOptionI(userInputOpt, flightManager);
                break;
    
            case "M":
                handleOptionM(userInputOpt, flightManager);
                break;
    
            case "F":
                handleOptionF(userInputOpt, flightManager);
                break;
    
            case "R":
                handleOptionR(userInputOpt, flightManager);
                break;
    
            case "C":
                handleOptionC(userInputOpt, flightManager);
                break;
    
            case "Q":
                if (userInputOpt.length != 1) {
                    System.err.println("ERRO: Número de argumentos inválido para opção Q!\n");
                    break;
                }
                cont = false;
                break;
    
            default:
                System.out.printf("A opção '%s' não existe. \n", opt);
                break;
        }

        return cont;
    }
    
    private static void handleOptionI(String[] userInputOpt, FlightManager flightManager) {
        if (userInputOpt.length != 2) {
            System.err.println("ERRO: Número de argumentos inválido para opção I!\n");
            return;
        }
        String filename = userInputOpt[1];
        try {
            ArrayList<String> reservations_denied = flightManager.readFlightFromFile(filename);
            for (String reserv : reservations_denied) {
                System.out.printf("Não foi possível obter lugares para a reserva: %s. \n", reserv);
            }
            System.out.println();
    
        } catch(FileNotFoundException e) {
            System.out.println("ERRO: Ficheiro não encontrado!\n");
        }
    }
    
    private static void handleOptionM(String[] userInputOpt, FlightManager flightManager) {
        if (userInputOpt.length != 2) {
            System.err.println("ERRO: Número de argumentos inválido para opção M!\n");
            return;
        }
        String flight_code = userInputOpt[1];
        HashMap<String, Flight> flights = flightManager.getFlights();
        if (!flights.containsKey(flight_code)) {
            System.err.println("ERRO: Voo não encontrado!\n");
            return;
        }
        Flight flight = flights.get(flight_code);
        System.out.println(flight.toString());
    }
    
    private static void handleOptionF(String[] userInputOpt, FlightManager flightManager) {
        if (userInputOpt.length != 3 && userInputOpt.length != 4) {
            System.err.println("ERRO: Número de argumentos inválido para opção F!\n");
            return;
        }
        String flight_code = userInputOpt[1];
        String num_seats_executive = userInputOpt.length == 4 ? userInputOpt[2] : null;
        String num_seats_tourist = userInputOpt[userInputOpt.length - 1];
        flightManager.addFlight(flight_code, num_seats_executive, num_seats_tourist);
    }
    
    private static void handleOptionR(String[] userInputOpt, FlightManager flightManager) {
        if (userInputOpt.length != 4) {
            System.err.println("ERRO: Número de argumentos inválido para opção R!\n");
            return;
        }
        String flight_code = userInputOpt[1];
        String class_type = userInputOpt[2];
        String num_seats = userInputOpt[3];
        flightManager.addReservation(flight_code, class_type, num_seats);
    }
    
    private static void handleOptionC(String[] userInputOpt, FlightManager flightManager) {
        if (userInputOpt.length != 2) {
            System.err.println("ERRO: Número de argumentos inválido para opção C!\n");
            return;
        }
        String reservation_code = userInputOpt[1];
        flightManager.cancelReservation(reservation_code);
    }

    static void showMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("\n");
        menu.append("\n/ ============== Opções ============== / \n");
        menu.append("I <nome_ficheiro>: Lê um ficheiro de texto contento informação sobre um voo; \n");
        menu.append("M <código_voo>: Exibe o mapa das reservas de um voo; \n");
        menu.append("F <flight_code> <num_seats_executive> <num_seats_tourist>: Acrescenta um novo voo, com código, lugares em executiva, e lugares em turística; \n");
        menu.append("R <flight_code> <class number_seats>: Acrescenta uma nova reserva a um voo, com indicação do código do voo, da classe (T/E), e do número de lugares; \n");
        menu.append("C <reservation_code>: cancela uma reserva; \n");
        menu.append("Q: Termina o programa. \n");
        menu.append("/ ====================================== / \n\n");
        
        System.out.println(menu.toString());   
    }
}
