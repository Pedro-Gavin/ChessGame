public class Knight extends Pawn{
    
    private int[][] moves = {{-2,1},{-1, 2}, {1, 2}, {2, 1},
                            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}}; 

    public Knight(int x, int y, boolean color){
        this.coords.setCordX(x);
        this.coords.setCordY(y);
        this.color = color;
    }

    public boolean chekMoves(int move){
        //Check if the move is valid 
        return isValid(coords.getCordX() + moves[move][0], coords.getCordX() + moves[move][1]);
    }

    public void move(int move){
        //Move the knight
        this.coords.setCordX(coords.getCordX() + moves[move][0]);
        this.coords.setCordY(coords.getCordY() + moves[move][1]);
    }
    
}
