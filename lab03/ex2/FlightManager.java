package lab03.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class FlightManager {

    public HashMap<String, Flight> flights = new HashMap<>();

    public HashMap<String, Flight> getFlights() {
        return flights;
    }



    public void addFlight(String flight_code, String num_seats_executive, String num_seats_tourist) {

        if (flights.containsKey(flight_code)) {
            System.err.println("ERRO: O voo já existe!");
            return;
        }

        int[][] executive = null;
        int[][] tourist = null;

        if (num_seats_executive != null) {
            executive = getSeats(num_seats_executive);
        }

        tourist = getSeats(num_seats_tourist);

        Flight newFlight = new Flight(flight_code, executive, tourist);
        flights.put(flight_code, newFlight);
    }



    public int[][] getSeats(String num_seats) {
        String regex = "^(\\d+)x(\\d+)$";
        if (!num_seats.matches(regex)) {
            System.err.println("ERRO: Formato inválido (IntegerxInteger)!");
            return null;
        }
        int rows = Integer.parseInt(num_seats.split("x")[0]);
        int cols = Integer.parseInt(num_seats.split("x")[1]);
        return new int[rows][cols];
    }



    public void addReservation(String flight_code, String ticket_class, String num_tickets) {
        Flight flight = flights.get(flight_code);
        if (validReservation(flight, ticket_class)) {
            try {
                int n_tickets = Integer.parseInt(num_tickets);
                int reserv_id = flight.getNext_reserv_id();
                String reservation = ticket_class + " " + n_tickets;
                if (mayReserve(flight, reserv_id, reservation)) {
                    flight.getReservations().put(reserv_id, reservation);
                    flight.setNext_reserv_id(reserv_id+1);
                    printOutputOptR(flight_code, reserv_id, ticket_class);
                } else {
                    System.err.println("ERRO: Não foi possível obter lugares para a reserva!");
                }
                
            } catch (NumberFormatException e) {
                System.err.println("ERRO: Número de bilhetes inválido!");
                return;
            
            }
        }    
    }



    public boolean validReservation(Flight flight, String ticket_class) {
        if (flight == null) {
            System.err.println("ERRO: Voo não encontrado!");
            return false;
        }
        if (ticket_class.equals("E") && flight.getExecutive() == null) {
            System.err.println("ERRO: Classe Executiva inexistente!");
            return false;
        } else if (!ticket_class.equals("T") && !ticket_class.equals("E")){
            System.err.println("ERRO: Classe inválida!");
            return false;
        }
        return true;
    }



    public ArrayList<String> readFlightFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner file_sc = new Scanner(file);

        String[] first_line = file_sc.nextLine().split(" ");
        String reservation;
        int reserv_id;

        Flight file_Flight;
        String code;
        int[][] executive;
        int[][] touristic;
        TreeMap<Integer, String> reservations;

        ArrayList<String> reservations_denied = new ArrayList<>();

        code = first_line[0].substring(1);
        if (first_line.length == 3) {                       // Avião possui lugares executivos
            executive = getSeats(first_line[1]);
            touristic = getSeats(first_line[2]);
        } else {                                            // Avião não possui lugares executivos
            executive = null;
            touristic = getSeats(first_line[1]);
        }
        file_Flight = new Flight(code, executive, touristic);
        
        reservations = file_Flight.getReservations();
        
        while (file_sc.hasNextLine()) {
            reservation = file_sc.nextLine().strip();
            reserv_id = file_Flight.getNext_reserv_id();
    
            if (mayReserve(file_Flight, reserv_id, reservation)) {
                reservations.put(reserv_id, reservation);
                file_Flight.setNext_reserv_id(reserv_id + 1);
            } else {
                reservations_denied.add(reservation);
            }  
        }

        flights.put(code, file_Flight);
        
        file_sc.close();

        printOutputOptI(file_Flight);

        return reservations_denied;
    }



    // Verificar se consegue fazer a reserva, se conseguir faz e devolve true, senão não faz
    private boolean mayReserve(Flight flight, int reserv_id, String reservation) {

        int[][] executive = flight.getExecutive();  // int[x][y] || null
        int[][] touristic = flight.getTouristic();  // int[x][y]
        
        
        TicketClass ticketClass = reservation.charAt(0) == 'T' ? TicketClass.TOURISTIC : TicketClass.EXECUTIVE;   
        int nTickets = Integer.parseInt(reservation.split(" ")[1]);

        int n_lugares_vazios = 0;                               // Contador do número de lugares vazios numa fila
        int fila_vazia = -1;                                    // Fila vazia encontrada
        int lugares_atribuidos = 0;                             // Lugares atribuídos à reserva até ao momento
        boolean lugares_suficientes = false;                    // Variável que indicará se existem ou não lugares suficientes
    
        
        switch (ticketClass) {
            case EXECUTIVE:
                if (executive == null) {return false;}

                int nFilas_exec = executive.length;                 // Número de filas Executiva
                int nColunas_exec = executive[0].length;            // Número de colunas Executiva  



                // Método: 
                for (int fila = 0; fila < nFilas_exec; fila++) {                    // Para cada fila        
                    for (int coluna = 0; coluna < nColunas_exec; coluna++) {        // vejo em cada posição
                        if (executive[fila][coluna] == 0) {                         // se o valor presente ainda é 0.
                            n_lugares_vazios++;                                     
                        }    
                        else {                                                      // Se não for, significa que pelo menos um lugar está ocupado e que a fila não está vazia, 
                            n_lugares_vazios = 0;                                   // logo reinicio o contador
                            break;                                                  // e passo para a próxima fila (salta fora do ciclo).
                        }    
                    }
                    if (n_lugares_vazios == nColunas_exec) {                        // Se: fila vazia (todos os lugares/colunas têm valor 0),
                        fila_vazia = fila;                                          // guardo o seu número
                        break;                                                      // e salto para fora do ciclo para fazer outras verificações
                    }
                }
                


                if (fila_vazia != -1) {                                             // Se fila_vazia já não tem o valor -1, significa que foi encontrada uma fila vazia.
                                                                                    // Logo, o código neste bloco trata o caso: foi encontrada uma fila vazia.
                    if (nTickets <= nColunas_exec) {                                // No caso de o número de bilhetes reservados ser inferior ao número de colunas,
                        for (int lugarNaFilaVazia = 0; lugarNaFilaVazia < nColunas_exec; lugarNaFilaVazia++) {
                            executive[fila_vazia][lugarNaFilaVazia] = reserv_id;    // siginifica que posso atribuir já os lugares à reserva 
                            lugares_atribuidos++;                                   // até que lugares_atribuidos == nTickets, e depois retornar true.
                            if (lugares_atribuidos == nTickets) {
                                return true;
                            } 
                        } 
                    }

                    // Código que trata o caso: o nColunas>nTickets (faltam lugares vazios para cobrir a reserva).
                    for (int fila = fila_vazia + 1; fila < nFilas_exec; fila++) {   // Para este caso, verifico se, após a fila que foi encontrada vazia,        
                        for (int coluna = 0; coluna < nColunas_exec; coluna++) {    // o número de lugares vazios são suficientes para cobrir o nTickets.
                            if (executive[fila][coluna] == 0) {     
                                n_lugares_vazios++;
                            }
                        }
                        if (n_lugares_vazios >= nTickets) {                         // Caso haja lugares suficientes, mudo o valor da variável e saio do ciclo.
                            lugares_suficientes = true;
                            break;
                        }    
                    }                    
                    
                    if (lugares_suficientes) {                                          // Se houver lugares suficientes, então volto à fila vazia e começo, por ordem,
                        for (int fila = fila_vazia; fila < nFilas_exec; fila++) {       // a atribuir os lugares vazios à reserva.  
                            for (int coluna = 0; coluna < nColunas_exec; coluna++) {
                                if (executive[fila][coluna] == 0) {     
                                    executive[fila][coluna] = reserv_id;  
                                    lugares_atribuidos++;
                                }
                                if (lugares_atribuidos == nTickets) {
                                    return true;                                        // Devolvo true quando forem todos atribuídos.
                                }
                            }
                        } 

                    } else {
                        return false;                                                   // Devolvo false se não houver lugares suficientes
                    }


                } else {    // O seguinte bloco trata: nenhuma fila vazia encontrada.
                            // Para resolver este caso, primeiro procuro sequencialmente se existem lugares vazios suficientes, e só depois é que atribuo.
                    n_lugares_vazios = 0;
                    lugares_atribuidos = 0;
                    lugares_suficientes = false;


                    for (int fila = 0; fila < nFilas_exec; fila++) {                         
                        for (int coluna = 0; coluna < nColunas_exec; coluna++) { 
                            if (executive[fila][coluna] == 0) {                         
                                n_lugares_vazios++;                                     
                            }  
                        }
                        if (n_lugares_vazios >= nTickets) {                       
                            lugares_suficientes = true;                                               
                            break;                                                                        
                        }
                    }   
                    

                    if (lugares_suficientes) {      

                        for (int fila = 0; fila < nFilas_exec; fila++) {      
                            for (int coluna = 0; coluna < nColunas_exec; coluna++) {
                                if (executive[fila][coluna] == 0) {     
                                    executive[fila][coluna] = reserv_id;  
                                    lugares_atribuidos++;
                                }
                                if (lugares_atribuidos == nTickets) {
                                    return true;                                       
                                }
                            }
                        } 

                    } else {
                        return false;                                                   
                    }

                }  
                break;




            case TOURISTIC:         // O código a seguir segue exatamente o mesmo método anterior.

                int nFilas_tour = touristic.length;                 
                int nColunas_tour = touristic[0].length;            



                // Método: 
                for (int fila = 0; fila < nFilas_tour; fila++) {                    
                    for (int coluna = 0; coluna < nColunas_tour; coluna++) {        
                        if (touristic[fila][coluna] == 0) {                         
                            n_lugares_vazios++;                                     
                        }    
                        else {                                                    
                            n_lugares_vazios = 0;                                   
                            break;                                                  
                        }    
                    }
                    if (n_lugares_vazios == nColunas_tour) {                        
                        fila_vazia = fila;                                          
                        break;                                                      
                    }
                }


                
                if (fila_vazia != -1) {                                             
                                                                                    
                    if (nTickets <= nColunas_tour) {                                
                        for (int lugarNaFilaVazia = 0; lugarNaFilaVazia < nColunas_tour; lugarNaFilaVazia++) {
                            touristic[fila_vazia][lugarNaFilaVazia] = reserv_id;    
                            lugares_atribuidos++;                                   
                            if (lugares_atribuidos == nTickets) {
                                return true;
                            } 
                        } 
                    }

                    // Código que trata o caso de o nColunas>nTickets (faltam lugares vazios para cobrir a reserva)
                    for (int fila = fila_vazia + 1; fila < nFilas_tour; fila++) {   
                        for (int coluna = 0; coluna < nColunas_tour; coluna++) {    
                            if (touristic[fila][coluna] == 0) {     
                                n_lugares_vazios++;
                            }
                        }
                        if (n_lugares_vazios >= nTickets) {                         
                            lugares_suficientes = true;
                            break;
                        }    
                    } 
                    
                    if (lugares_suficientes) {                                          
                        for (int fila = fila_vazia; fila < nFilas_tour; fila++) {       
                            for (int coluna = 0; coluna < nColunas_tour; coluna++) {
                                if (touristic[fila][coluna] == 0) {     
                                    touristic[fila][coluna] = reserv_id;  
                                    lugares_atribuidos++;
                                }
                                if (lugares_atribuidos == nTickets) {
                                    return true;                                        
                                }
                            }
                        }

                    } else {
                        return false;                                                   
                    }


                } else {   

                    n_lugares_vazios = 0;
                    lugares_atribuidos = 0;
                    lugares_suficientes = false;


                    for (int fila = 0; fila < nFilas_tour; fila++) {                         
                        for (int coluna = 0; coluna < nColunas_tour; coluna++) { 
                            if (touristic[fila][coluna] == 0) {                         
                                n_lugares_vazios++;                                     
                            }  
                        }
                        if (n_lugares_vazios >= nTickets) {                       
                            lugares_suficientes = true;                                       
                            break;                                                      
                        }
                    }   
                    

                    if (lugares_suficientes) {      

                        for (int fila = 0; fila < nFilas_tour; fila++) {      
                            for (int coluna = 0; coluna < nColunas_tour; coluna++) {
                                if (touristic[fila][coluna] == 0) {     
                                    touristic[fila][coluna] = reserv_id;  
                                    lugares_atribuidos++;
                                }
                                if (lugares_atribuidos == nTickets) {
                                    return true;                                       
                                }
                            }
                        } 

                    } else {
                        return false;                                                   
                    }
                }
                break;
        }

        return false;   // Classe inexistente
    }

    public boolean cancelReservation(String reservationCode) {
        String regex = "\\b\\w+:\\d+\\b";
        if (!reservationCode.matches(regex)) {
            System.out.println("ERRO: Formato inválido.");
            return false;
        }
        String flightCode = reservationCode.split(":")[0];
        int reserv_id = Integer.parseInt(reservationCode.split(":")[1]);

        Flight flight = null;
        
        Iterator<Map.Entry<String, Flight>> iterator = this.flights.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<String, Flight> entry = iterator.next();
            if (entry.getKey().equals(flightCode)) {
                flight = entry.getValue();                  // Obter o voo procurado
                break;
            }
        }

        if (flight == null) {
            System.out.println("ERRO: Voo não encontrado.");
            return false;
        }

        TreeMap<Integer, String> reservations = flight.getReservations();
        TicketClass ticketClass;

        if (reservations.containsKey(reserv_id)) {
            ticketClass = reservations.get(reserv_id).charAt(0) == 'T' ? TicketClass.TOURISTIC : TicketClass.EXECUTIVE;
            reservations.remove(reserv_id);
        } else {
            System.out.println("ERROR: Reserva não encontrada.");
            return false;
        }
        
        switch (ticketClass) {
            case EXECUTIVE:
                int[][] executive = flight.getExecutive();
                for (int fila = 0; fila < executive.length; fila++) {                         
                    for (int coluna = 0; coluna < executive[0].length; coluna++) {      
                        if (executive[fila][coluna] == reserv_id) {
                            executive[fila][coluna] = 0;
                        }
                    }
                }  
                return true;   
            
            case TOURISTIC:
                int[][] touristic = flight.getTouristic();
                for (int fila = 0; fila < touristic.length; fila++) {                         
                    for (int coluna = 0; coluna < touristic[0].length; coluna++) {      
                        if (touristic[fila][coluna] == reserv_id) {
                            touristic[fila][coluna] = 0;
                        }
                    }
                }  
                return true;

            default:
                System.out.println("Classe inexistente.");
                break;    
        }

        return false;
    }

    private void printOutputOptI(Flight flight) {
        StringBuilder outI = new StringBuilder();

        int[][] executive = flight.getExecutive();
        int freeSeatsExec = executive == null ? 0 : executive.length * executive[0].length;     // Num de lugares executivos é 0 se executive==null
        int[][] touristic = flight.getTouristic();
        int freeSeatsTour = touristic.length * touristic[0].length;


        outI.append(String.format("Código de voo %s. ", flight.getCode()));
        outI.append("Lugares disponíveis: ");
        if (executive != null) 
            outI.append(String.format("%d lugares em classe Executiva; ", freeSeatsExec));
        outI.append(String.format("%d lugares em classe Turística.", freeSeatsTour));

        System.out.println(outI.toString());
    }

    private void printOutputOptR(String flight_code, int reserv_id, String ticket_class) {
        StringBuilder outR = new StringBuilder();
        outR.append(flight_code + ":" + reserv_id + " = ");
        int[][] executive = flights.get(flight_code).getExecutive();
        int[][] touristic = flights.get(flight_code).getTouristic();
        int numExecutiveRows = (executive == null) ? 0 : executive.length;
        int numTouristicRows = touristic.length;
        int numTotalRows = numExecutiveRows + numTouristicRows;
        if (ticket_class.equals("E")) {
            for (int fila = 0; fila < numExecutiveRows; fila++) {
                for (int coluna = 0; coluna < executive[0].length; coluna++) {
                    if (executive[fila][coluna] == reserv_id) {
                        outR.append(fila+1);
                        outR.append((char) (coluna + 65));
                        outR.append(" | ");
                    }
                }
            }
        } else {
            for (int fila = numExecutiveRows; fila < numTotalRows; fila++) {
                for (int coluna = 0; coluna < touristic[0].length; coluna++) {
                    if (touristic[fila - numExecutiveRows][coluna] == reserv_id) {
                        outR.append(fila+1);
                        outR.append((char) (coluna + 65));
                        outR.append(" | ");
                    }
                }
            }
        }
        if (outR.length() >= 3) {
            outR.setLength(outR.length() - 3);
        }
        System.out.println(outR.toString());
    }
}
