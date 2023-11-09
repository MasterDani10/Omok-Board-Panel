import java.awt.*;

public class ComputerStrategy {
    int[] nextMove;
    public int[] nextMove(int[] movePlayer){
        nextMove = movePlayer;
        if(nextMove[0] == 14){
            nextMove[0] = nextMove[0] - 2;
        }
        else {
            nextMove[0] = nextMove[0] + 2;
        }
        return nextMove;
    }
    public int[] nextMove2(int[] movePlayer){
        nextMove = movePlayer;
        if (nextMove[0] == 0){
            nextMove[0] = nextMove[0]+2;
        }
        else {
        }
        return nextMove;
    }
    public int[] nextMove3(int[] movePlayer){
        nextMove = movePlayer;
        if (nextMove[1] == 14){
            nextMove[1] = nextMove[1] -2;
        }
        else {
            nextMove[1] = nextMove[1] + 2;
        }
        return nextMove;
    }
    public int[] nextMove4(int[] movePlayer){
        nextMove = movePlayer;
        if(nextMove[1] == 0){
            nextMove[1] = nextMove[1]+2;
        }
        else {
            nextMove[1] = nextMove[1] - 1;
        }
        return nextMove;
    }

}
