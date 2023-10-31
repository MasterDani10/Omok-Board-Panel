import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private Board board;
    int size;
    //int border = 20;
    int width = 450+10;
    int height = 450+10;

    public BoardPanel(Board board){
        this.board = board;

    }
    @Override
    protected void paintComponent(Graphics g){
        size = board.size();
        g.setColor(Color.ORANGE);
        g.fillRect(10, 10, width-10, height-10);
        g.setColor(Color.BLACK);

        for(int i = 10; i <= width; i+= width/size){
            g.drawLine(i,10,i,width);
        }

        for(int i = 10; i <= height; i+= height/size){
            g.drawLine(10,i,height,i);
        }
    }


    @Override
    public Dimension getPreferredSize(){
        return new Dimension(width,size);
    }



}
