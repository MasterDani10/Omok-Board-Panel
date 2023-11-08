import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Omok {
    Board board = new Board();
    Player player1 = new Player("Player1");
    Player player2 = new Player("Player2");
    ArrayList<Point> player1Stones = new ArrayList<>();
    ArrayList<Point> player2Stones = new ArrayList<>();
    //Boolean win = false;
    BoardPanel d = new BoardPanel(new Board(), player1Stones,player2Stones);
    Boolean p1 = true;
    Boolean restart = false;



    int x = 0;
    int y = 0;
    Point point = new Point(0,0);


    public Omok(){
        Image imagePlay = Toolkit.getDefaultToolkit().getImage("Resources/play.png").
                getScaledInstance(20, 20, 20);
        Image imageAbout = Toolkit.getDefaultToolkit().getImage("Resources/about.png").
                getScaledInstance(20, 20, 20);
        ImageIcon iconPlay = new ImageIcon(imagePlay);
        ImageIcon iconAbout = new ImageIcon(imageAbout);

        // Frame
        JFrame frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470,615);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("Game menu");
        menuBar.add(menu);

        // Menu Item
        JMenuItem menuItemPlay = new JMenuItem("Play", KeyEvent.VK_P);
        menuItemPlay.setIcon(iconPlay);
        menuItemPlay.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        menuItemPlay.getAccessibleContext().setAccessibleDescription(
                "Play game");
        //menuItemPlay.addActionListener(…);
        menu.add(menuItemPlay);


        JMenuItem menuItemAbout = new JMenuItem("About", KeyEvent.VK_A);
        menuItemAbout.setIcon(iconAbout);
        menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
        menuItemAbout.getAccessibleContext().setAccessibleDescription(
                "Omok Game Info");
        //menuItemAbout.addActionListener(…);
        menu.add(menuItemAbout);


        frame.setJMenuBar(menuBar);

        JToolBar toolBar = new JToolBar("Omok");
        JButton playTool = new JButton();
        playTool.setIcon(iconPlay);
        //playTool.addActionListener(…);
        playTool.setToolTipText("Play a new game");
        playTool.setFocusPainted(false);
        toolBar.add(playTool);


        JButton aboutTool = new JButton();
        aboutTool.setIcon(iconAbout);
        //aboutTool.addActionListener(…);
        aboutTool.setToolTipText("Omok Game Info");
        aboutTool.setFocusPainted(false);
        toolBar.add(aboutTool);

        //playTool.
        frame.add(toolBar, BorderLayout.NORTH);

        //panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton p = new JButton("Play");
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int result = JOptionPane.showConfirmDialog(frame,"Do you want to start a new game?",
                        "Omok",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){

                    System.out.println("Correct");
                    frame.setVisible(false);
                    frame.dispose();
                    new Omok();
                }
            }
        });

        panel2.add(p);
        panel2.add(new JLabel("            Opponent:"));
        String[] opponents = {"Human", "Computer"};
        JComboBox comboBox = new JComboBox(opponents);
        panel2.add(comboBox);
        JLabel player = new JLabel("Player 1 Turn");
        panel3.add(player);
        panel.add(panel2, BorderLayout.NORTH);
        panel.add(panel3);
        center.add(panel, BorderLayout.NORTH);



        // Menu Tool Bar




        // Board Panel



        d.setSize(d.getPreferredSize());
        d.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(d.getMousePosition());
                point = d.getMousePosition();

                x = (int)point.getX();
                y = (int)point.getY();

                x = board.getRoundedX(x);
                y = board.getRoundedY(y);

                point = new Point(x,y);

                x = (x-10) / 30;
                y = (y-10) / 30;

                if(!p1){
                    player2Stones.add(point);
                }
                else{
                    player1Stones.add(point);
                }


                System.out.println(x);
                System.out.println(y);
                p1 = !p1;
                if(!p1){
                    board.selectPlayerOne(player1);
                    board.placeStone((int)x,(int)y,player1);
                    if(board.isWonBy(player1)){
                        d = new BoardPanel(board,player1Stones,player2Stones,board.winningRow(player1),1);
                        JOptionPane.showMessageDialog(frame, "Player 1 Won!!!",
                                "Omok", JOptionPane.PLAIN_MESSAGE);
                        //win = true;
                        player.setText("Player 1 Won!!!");


                    }
                    else {
                        player.setText("Player 2 Turn");

                    }
                }
                else{
                    board.selectPlayerOne(player1);
                    board.placeStone((int)x,(int)y,player2);
                    if(board.isWonBy(player2)){
                        d = new BoardPanel(board,player1Stones,player2Stones,board.winningRow(player2),2);
                        JOptionPane.showMessageDialog(frame, "Player 2 Won!!!",
                                "Omok", JOptionPane.PLAIN_MESSAGE);
                        //win = true;
                        player.setText("Player 2 Won!!!");
                    }
                    else{
                        player.setText("Player 1 Turn");

                    }
                }
            }
        });


        center.add(d, BorderLayout.CENTER);
        frame.add(center);
        frame.setVisible(true);
        if (!p1){
            System.out.println(board.isWonBy(player1));
            if(board.isWonBy(player1)){

                board.placeStone((int)x,(int)y,player1);
                d = new BoardPanel(board,player1Stones,player2Stones,board.winningRow(player1),1);
            }
            else{
                board.placeStone((int)x,(int)y,player1);
                d = new BoardPanel(board,player1Stones,player2Stones);
            }

        }
        else {
            if (board.isWonBy(player2)){
                board.placeStone((int)x,(int)y,player2);
                d = new BoardPanel(board,player1Stones,player2Stones,board.winningRow(player2),2);
            }
            else {
                board.placeStone((int)x,(int)y,player2);
                d = new BoardPanel(board,player1Stones,player2Stones);
            }

        }


    }

    public static void main(String[] args){
        Omok omok = new Omok();
    }
}