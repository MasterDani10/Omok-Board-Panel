import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class BoardPanel extends JPanel {
    private Board board;
    int size;
    //int border = 20;
    int width = 450+10;
    int height = 450+10;
    ArrayList<Point> player1Stones;
    ArrayList<Point> player2Stones;

    public BoardPanel(Board board, ArrayList<Point> p1, ArrayList<Point> p2){
        this.board = board;
        this.player1Stones = p1;
        this.player2Stones = p2;

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

        if(!player1Stones.isEmpty()){
            for (int i = 0; i < player1Stones.size(); i++){
                g.setColor(Color.WHITE);
                g.fillOval((int)player1Stones.get(i).getX()-10, (int)player1Stones.get(i).getY()-10, 20,20);
            }
        }
        if(!player2Stones.isEmpty()){
            for (int i = 0; i < player2Stones.size(); i++){
                g.setColor(Color.BLACK);
                g.fillOval((int)player2Stones.get(i).getX()-10, (int)player2Stones.get(i).getY()-10, 20,20);
            }
        }
        repaint();
    }




    @Override
    public Dimension getPreferredSize(){
        return new Dimension(width,size);
    }



}
