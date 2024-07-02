public class Piece {
    private Coords coords;
    private boolean color;

    public Piece(){
        this.coords.setCordX(0);
        this.coords.setCordY(0);
        this.color = false;
    }

    public Piece(int x, int y, boolean color){
        this.coords.setCordX(x);
        this.coords.setCordY(y);
        this.color = color;
    }

    public void setPosition(Coords newCoords){
        this.coords = newCoords;
    }

    public Coords getCoords(){
        return this.coords;
    }

    public boolean getColor(){
        return color;
    }
}
