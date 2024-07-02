public class Pawn {

    protected Coords coords;
    protected boolean color;
    private boolean alPaso;

    public Pawn(int x, int y, String color){
        this.coords.setCordX(x);
        this.coords.setCordY(y);
        if (color == "white") {
            this.color = false;
        } else {
            this.color = true;
        }
        this.alPaso = false;
    }

    public Pawn(){
        this.coords.setCordX(0);
        this.coords.setCordY(0);
        this.color = false;
        this.alPaso = false;
    }

    public void move(int numCasillas){
        if(!color){
            move_white(numCasillas);
        } else {
            move_black(numCasillas);
        }
    }

    private void move_white(int numCasillas){
        if(coords.getCordY() == 1){
            if (numCasillas > 1) {
                numCasillas = 2;
                coords.setCordY(coords.getCordY() + numCasillas);
                this.alPaso = true;
            } else {
                coords.setCordY(coords.getCordY() + 1);
            }
        } else if(coords.getCordY() == 6){
            coords.setCordY(coords.getCordY() + 1);
            promote();
        } else {
            coords.setCordY(coords.getCordY()+1);
            this.alPaso = false;
        }
    }

    private void move_black(int numCasillas){   
        if(coords.getCordY() == 6){
            if (numCasillas > 1) {
                numCasillas = 2;
                coords.setCordY(coords.getCordY() - numCasillas);
                this.alPaso = true;
            } else {
                coords.setCordY(coords.getCordY() - 1);
            }
        } else if(coords.getCordY() == 6){
            coords.setCordY(coords.getCordY() - 1);
            promote();
        } else {
            coords.setCordY(coords.getCordY()-1);
            this.alPaso = false;
        }
    }
    /*
     * dir = false, whites takes to the left
     * dir = true, whites takes to the right
     */
    public void take(boolean dir){
        if (!color) {
            take_white(dir);
        } else {
            take_black(dir);
        }
    }

    private void take_white(boolean dir){
        if(!dir){
            coords.setCordX(coords.getCordX()-1);
            coords.setCordY(coords.getCordY()+1);
        } else {
            coords.setCordX(coords.getCordX()+1);
            coords.setCordY(coords.getCordY()+1);
        }
    }

    private void take_black(boolean dir){
        if(!dir){
            coords.setCordX(coords.getCordX()+1);
            coords.setCordY(coords.getCordY()-1);
        } else {
            coords.setCordX(coords.getCordX()-1);
            coords.setCordY(coords.getCordY()-1);
        }
    }

    public boolean isValid(int newPosX, int newPosY){
        return newPosX < 8 && newPosX >= 0 && newPosY < 8 && newPosY >= 0;
    }

    public void promote(){

    }

}