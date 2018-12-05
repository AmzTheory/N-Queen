public class Main {

    public static void main(String[] args) {
        //1 represent queen will occupy
        //0 represent Unoccupied cell
        int n=5;//choose n
        NQueen.printBoard(NQueen.solveProblem(new int[n][n],0,n));
    }
}


