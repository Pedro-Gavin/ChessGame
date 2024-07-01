public class Pawn {

    private Coords coords;
    private boolean color;
    private boolean canMove;
    private boolean canTake;
    private boolean alPaso;

    public Pawn(int x, int y, String color){
        this.coords.setCordX(x);
        this.coords.setCordY(y);
        if (color == "white") {
            this.color = false;
        } else {
            this.color = true;
        }
        this.canMove = true;
        this.canTake = false;
        this.alPaso = false;
    }

    public Pawn(){
        this.coords.setCordX(0);
        this.coords.setCordY(0);
        this.color = false;
        this.canMove = false;
        this.canTake = false;
        this.alPaso = false;
    }

    public void setCanMove(boolean canMove){
        this.canMove = canMove;
    }

    public void move(int numCasillas){
        if(!canMove){
            return;
        }
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
        if (!canTake) {
            return;
        }
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

    public void promote(){

    }

}