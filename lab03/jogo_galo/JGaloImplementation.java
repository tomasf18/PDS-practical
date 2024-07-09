package lab03.jogo_galo;

public class JGaloImplementation implements JGaloInterface {
    private boolean isPlayerX = false;
    private char[][] board = new char[3][3];
    private int numJogadas = 0;

    public char getActualPlayer() {
        isPlayerX = !isPlayerX;
        return isPlayerX ? 'X' : 'O';
    }

    public boolean setJogada(int lin, int col) {
        if (board[lin - 1][col - 1] == 0) {
            board[lin - 1][col - 1] = isPlayerX ? 'X' : 'O';
            numJogadas++;
            return true;
        }

        return false;
    }

    public boolean isFinished() {
        if (checkResult() != ' ' || numJogadas == 9) {
            return true;
        }
        return false;
    }

    public char checkResult() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
            return board[0][2];
        }
        return ' ';
    }
    
}
