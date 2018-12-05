import java.awt.*;

public class NQueen {
    //int array[]=
    public static int[][] solveProblem(int[][] cells,int currentRow,int n) {
        if (currentRow == n)
            return cells;
        else {
            for (int col = 0; col < n; col++) {
                cells[currentRow][col] = 1;
                if (legalQueen(col, currentRow, cells)) {

                    int[][] values = solveProblem(cells, currentRow + 1, n);
                    if (values == null)
                        cells[currentRow][col] = 0;
                    else
                        return cells;

                }else{
                    cells[currentRow][col] = 0;
                }
            }
        }
        return null;
    }
    private static boolean legalQueen(int col,int row,int[][] cells){
        return (diagonalLegal(col,row,cells) && verticalLegal(col,row,cells));
    }
    private static boolean diagonalLegal(int col,int row,int[][] cells){
        //TopRight
        Point topLeft= getTL(row,col);
        int i=(int)topLeft.getY();//represent col
        for(int r=(int)topLeft.getX();i<=col&& r<=row;r++){
            if(col!=i && cells[r][i++]==1)
                return false;
        }
        //TopLeft
        Point topRight= getTR(row,col,cells.length);
        i=(int)topRight.getY();
        for(int r=(int)topRight.getX();i>-1 && r<4;r++){
            //System.out.println(i+" "+r);
            if(col!=i && cells[r][i--]==1)
                return false;
        }
        return true;
    }
    private static boolean verticalLegal(int col,int row,int[][] cells){
        for(int r=0;r<cells.length;r++){
            if(r!=row && cells[r][col]==1)
                return false;
        }
        return true;
    }
    private static Point getTL(int r, int c){
        if(r==c)
            return new Point(0,0);
            //above
        else if(c>r)
            return new Point(0,c-r);
        else
            return new Point(r-c,0);
    }
    private static Point getTR(int r, int c, int n){
        while(r>0 && c<(n-1)){
            r--;
            c++;
        }
        return new Point(r,c);
    }
    public static void printBoard(int[][] cells){
        for (int i=0;i<cells.length;i++){
            for (int j=0;j<cells.length;j++){
                System.out.print(cells[i][j]+" ");
            }
            System.out.println();
        }
    }
}
