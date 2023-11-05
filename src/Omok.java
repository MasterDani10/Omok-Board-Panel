import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Omok {
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
        frame.setSize(470,600);

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
        JButton p = new JButton("Play");
        panel.add(p);
        panel.add(new JLabel("            Opponent:"));
        String[] opponents = {"Human", "Computer"};
        JComboBox comboBox = new JComboBox(opponents);
        panel.add(comboBox);
        center.add(panel, BorderLayout.NORTH);


        // Menu Tool Bar




        // Board Panel
        BoardPanel d = new BoardPanel(new Board());
        d.setSize(d.getPreferredSize());
        d.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(d.getMousePosition());
                Point p = d.getMousePosition();
                double x = p.getX();
//                if(x >= 0 && x < 25){
//                    x = 10;
//                }
                for(int i = 10; i <= 300; i += 30){
//                    if(x < 10){
//                        x = 10;
//                    }
//                    else{
//                        if(x > i && x < i+15){
//                            x = i;
//                        }
//                    }
//                    if(x < (i+15) || x > i-15){
//                        x = i;
//                    }

                }
                System.out.println(x);
                double y = p.getY();
//                x = Math.round(x);
//                x = x/10;
//                y = Math.round(y);
//                y = y/10;
//                System.out.println(x);
//                System.out.println(y);
            }
        });

        center.add(d, BorderLayout.CENTER);
        frame.add(center);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Omok omok = new Omok();
    }
}
