import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Computer{
    Board board = new Board();
    Player player1 = new Player("Player1");
    Player player2 = new Player("Player2");
    ArrayList<Point> player1Stones = new ArrayList<>();
    ArrayList<Point> player2Stones = new ArrayList<>();
    //Boolean win = false;
    BoardPanel d = new BoardPanel(new Board(), player1Stones,player2Stones);
    Boolean p1 = true;
    Boolean repeatCom = true;
    Boolean repeat = true;

    String[] opponents = {"Computer", "Human"};
    JComboBox comboBox = new JComboBox(opponents);


    int x = 0;
    int y = 0;
    int xCom = 0;
    int yCom = 0;
    Point point = new Point(0,0);
    Point pointCom = new Point(0,0);


    public Computer(){
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
        menuItemPlay.addActionListener(e -> {
            playButtonClicked(frame,(String)comboBox.getSelectedItem());
        });
        menu.add(menuItemPlay);


        JMenuItem menuItemAbout = new JMenuItem("About", KeyEvent.VK_A);
        menuItemAbout.setIcon(iconAbout);
        menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
        menuItemAbout.getAccessibleContext().setAccessibleDescription(
                "Omok Game Info");
        menuItemAbout.addActionListener(e -> {
            aboutButtonClicked(frame);
        });
        menu.add(menuItemAbout);


        frame.setJMenuBar(menuBar);

        JToolBar toolBar = new JToolBar("Omok");
        JButton playTool = new JButton();
        playTool.setIcon(iconPlay);
        playTool.addActionListener(e -> {
            playButtonClicked(frame,(String)comboBox.getSelectedItem());
        });
        playTool.setToolTipText("Play a new game");
        playTool.setFocusPainted(false);
        toolBar.add(playTool);

        JButton aboutTool = new JButton();
        aboutTool.setIcon(iconAbout);
        aboutTool.addActionListener(e -> {
            aboutButtonClicked(frame);
        });
        aboutTool.setToolTipText("Omok Game Info");
        aboutTool.setFocusPainted(false);
        toolBar.add(aboutTool);

        //playTool.
        frame.add(toolBar, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton p = new JButton("Play");
        p.addActionListener(e -> {
            playButtonClicked(frame,(String)comboBox.getSelectedItem());
        });

        panel2.add(p);
        panel2.add(new JLabel("            Opponent:"));

        panel2.add(comboBox);
        JLabel player = new JLabel("Player 1 Turn");
        panel3.add(player);
        panel.add(panel2, BorderLayout.NORTH);
        panel.add(panel3);
        center.add(panel, BorderLayout.NORTH);

        d.setSize(d.getPreferredSize());
        d.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                repeat = true;
                System.out.println(d.getMousePosition());
                point = d.getMousePosition();
                while(repeat){
                    x = (int)point.getX();
                    y = (int)point.getY();

                    x = board.getRoundedX(x);
                    y = board.getRoundedY(y);

                    point = new Point(x,y);

                    x = (x-10) / 30;
                    y = (y-10) / 30;

                    if(board.isOccupied(x,y)){
                        player.setText("Player 1 Turn (Please Select an Empty Space!!!)");
                        JOptionPane.showMessageDialog(frame,
                                "Player 1, Please Select an Empty Space!!!!",
                                "Omok", JOptionPane.PLAIN_MESSAGE);
                        point = d.getMousePosition();
                    }
                    else {
                        repeat = false;
                    }
                }

                repeatCom = true;
                while(repeatCom){
                    Random random = new Random();
                    xCom = random.nextInt(15);
                    yCom = random.nextInt(15);
                    if(!board.isOccupied(x,y)){
                        repeatCom = false;
                    }
                }
                xCom = (xCom*30)+10;
                yCom = (yCom*30)+10;
                pointCom = new Point(xCom,yCom);
                player2Stones.add(pointCom);


                player1Stones.add(point);



                System.out.println(x);
                System.out.println(y);

                board.selectPlayerOne(player1);
                board.placeStone((int)x,(int)y,player1);
                if(board.isWonBy(player1)){
                    d = new BoardPanel(board,player1Stones,player2Stones,board.winningRow(player1),1);
                    JOptionPane.showMessageDialog(frame, "Player 1 Won!!!",
                            "Omok", JOptionPane.PLAIN_MESSAGE);
                    player.setText("Player 1 Won!!!");
                }
                else {
                    player.setText("Computer Turn");
                }

                board.selectPlayerOne(player1);
                board.placeStone((int)xCom,(int)yCom,player2);
                if(board.isWonBy(player2)){
                    d = new BoardPanel(board,player1Stones,player2Stones,board.winningRow(player2),2);
                    JOptionPane.showMessageDialog(frame, "Computer Won!!!",
                            "Omok", JOptionPane.PLAIN_MESSAGE);

                    player.setText("Computer Won, Better Luck Next Time");
                }
                else{
                    player.setText("Player 1 Turn");
                }

                if (board.isFull()){
                    d = new BoardPanel(board,player1Stones,player2Stones,board.winningRow(player1),1);
                    JOptionPane.showMessageDialog(frame, "The Game is a Draw",
                            "Omok", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });


        center.add(d, BorderLayout.CENTER);
        frame.add(center);
        frame.setVisible(true);

    }

    private void clean(){
        board = null;
        player1 = null;
        player2 = null;
        player1Stones = null;
        player2Stones = null;
        d = null;
        p1 = null;
        point = null;
    }

    private void playButtonClicked(JFrame frame, String mode){
        int result = JOptionPane.showConfirmDialog(frame,"Do you want to start a new "
                        + mode + " game?",
                "Omok",JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            frame.setVisible(false);
            frame.dispose();
            clean();
            if(mode.equals("Human")){
                new Omok();
            }
            else{
                new Computer();
            }
        }
    }

    private void aboutButtonClicked(JFrame frame){
        JPanel about = new JPanel(new GridLayout(0,1,5,5));
        about.add(new JLabel("Authors:"));
        about.add(new JLabel("Luis Daniel Estrada Aguirre"));
        about.add(new JLabel("Benjamin Laffita"));
        about.add(new JLabel(""));
        about.add(new JLabel("Version: 1.0"));
        JOptionPane.showMessageDialog(frame,about,"About",JOptionPane.INFORMATION_MESSAGE);
    }
}