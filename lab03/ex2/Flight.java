package lab03.ex2;

import java.util.TreeMap;

public class Flight {
    private String code;
    private int[][] executive;
    private int[][] touristic;
    private TreeMap<Integer, String> reservations;
    private int next_reserv_id;

    public Flight(String code, int[][] executive, int[][] touristic) {
        this.code = code;
        this.executive = executive;
        this.touristic = touristic;
        this.reservations = new TreeMap<>();
        this.next_reserv_id = 1;
    }

    public String getCode() {
        return code;
    }

    public int[][] getExecutive() {
        return executive;
    }

    public int[][] getTouristic() {
        return touristic;
    }

    public TreeMap<Integer, String> getReservations() {
        return reservations;
    }

    public int getNext_reserv_id() {
        return next_reserv_id;
    }

    public void setNext_reserv_id(int next_reserv_id) {
        this.next_reserv_id = next_reserv_id;
    }

    // Este toString devolve o mapa das reservas (opção M do menu)
    public String toString() {
        StringBuilder flightString = new StringBuilder();

        int numRowsExecutive = 0;
        if (executive != null) {
            numRowsExecutive = executive.length;
        }
        int numRowsTouristic = touristic.length;
        int numRows = numRowsExecutive + numRowsTouristic;

        int numMaxSeats = 0;
        if (numRowsExecutive > numRowsTouristic) {
            numMaxSeats = executive[0].length;
        } else {
            numMaxSeats = touristic[0].length;
        }
        flightString.append(" ");
        for (int i = 1; i <= numRows; i++) {
            flightString.append(String.format("%4d", i));
        }
        flightString.append("\n");

        for (int seat = 0; seat < numMaxSeats; seat++) {
            flightString.append((char) (seat + 65));

            for (int row = 0; row < numRows; row++) {
                if (row < numRowsExecutive) {
                    if (seat < executive[0].length) {
                        flightString.append(String.format("%4d", executive[row][seat]));
                    } else {
                        flightString.append(String.format("%4s", ""));
                    }
                } else {
                    if (seat < touristic[0].length) {
                        flightString.append(String.format("%4d", touristic[row - numRowsExecutive][seat]));
                    } else {
                        flightString.append(String.format("%4s", ""));
                    }
                }
            }
            flightString.append("\n");
        }
        return flightString.toString();
    }
}
