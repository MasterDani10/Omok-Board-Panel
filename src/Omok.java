import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Omok {
    Board board = new Board();
    Player player1 = new Player("Player1");
    Player player2 = new Player("Player2");
    ArrayList<Point> player1Stones = new ArrayList<>();
    ArrayList<Point> player2Stones = new ArrayList<>();
    BoardPanel d = new BoardPanel(new Board(), player1Stones,player2Stones);
    Boolean p1 = true;
    private boolean gameStarted = false;

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
        aboutTool.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "Welcome to Omok!");
            }
        });
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
        panel2.add(new JLabel("            Opponent:"));
        String[] opponents = {"Human", "Computer"};
        JComboBox comboBox = new JComboBox(opponents);
        panel2.add(comboBox);
        //panel2.add(new JLabel("ii        jhlkk                            "));
        JLabel player = new JLabel();
        panel3.add(player);
        panel.add(panel2, BorderLayout.NORTH);
        panel.add(panel3);
        center.add(panel, BorderLayout.NORTH);
        JButton p = new JButton("Play");
        p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameStarted) {
                    gameStarted = true;
                    player.setText("Player 1 turn");
                }
            }
        });
        panel2.add(p);
        d.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!gameStarted){
                    JOptionPane.showMessageDialog(frame, "Please click the Play button");

                }
            }
        });

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

                if(x < 25){
                    x = 10;
                }
                else if (x < 55) {
                    x = 40;
                }
                else if (x < 85) {
                    x = 70;
                }
                else if (x < 115) {
                    x = 100;
                }
                else if (x < 145) {
                    x = 130;
                }
                else if (x < 175) {
                    x = 160;
                }
                else if (x < 205) {
                    x = 190;
                }
                else if (x < 235) {
                    x = 220;
                }
                else if (x < 265) {
                    x = 250;
                }
                else if (x < 295) {
                    x = 280;
                }
                else if (x < 325) {
                    x = 310;
                }
                else if (x < 355) {
                    x = 340;
                }
                else if (x < 385) {
                    x = 370;
                }
                else if (x < 415) {
                    x = 400;
                }
                else if (x < 445) {
                    x = 430;
                }
                else if (x < 475) {
                    x = 460;
                }

                if(y < 25){
                    y = 10;
                }
                else if (y < 55) {
                    y = 40;
                }
                else if (y < 85) {
                    y = 70;
                }
                else if (y < 115) {
                    y = 100;
                }
                else if (y < 145) {
                    y = 130;
                }
                else if (y < 175) {
                    y = 160;
                }
                else if (y < 205) {
                    y = 190;
                }
                else if (y < 235) {
                    y = 220;
                }
                else if (y < 265) {
                    y = 250;
                }
                else if (y < 295) {
                    y = 280;
                }
                else if (y < 325) {
                    y = 310;
                }
                else if (y < 355) {
                    y = 340;
                }
                else if (y < 385) {
                    y = 370;
                }
                else if (y < 415) {
                    y = 400;
                }
                else if (y < 445) {
                    y = 430;
                }
                else if (y < 475) {
                    y = 460;
                }
                point = new Point(x,y);

                x = (x-10) / 30;
                y = (y-10) / 30;

                if(p1){
                    player1Stones.add(point);
                }
                else{
                    player2Stones.add(point);
                }


                System.out.println(x);
                System.out.println(y);
                p1 = !p1;
                if(p1){
                    player.setText("Player 1 Turn");
                }
                else{
                    player.setText("Player 2 Turn");
                }
            }
        });


        center.add(d, BorderLayout.CENTER);
        frame.add(center);
        frame.setVisible(true);
        if (!p1){
            board.placeStone((int)x,(int)y,player1);
            d = new BoardPanel(board,player1Stones,player2Stones);
        }
        else {
            board.placeStone((int)x,(int)y,player2);
            d = new BoardPanel(board,player1Stones,player2Stones);
        }


    }

    public static void main(String[] args){
        Omok omok = new Omok();
    }
}
