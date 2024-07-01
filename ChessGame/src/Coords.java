public class Coords{
    private int x;
    private int y;

    public Coords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coords(){
        this.x = 0;
        this.y = 0;
    }

    public int getCordX(){
        return this.x;
    }

    public int getCordY(){
        return this.y;
    }

    public void setCordX(int x){
        this.x = x;
    }

    public void setCordY(int y){
        this.y = y;
    }
}