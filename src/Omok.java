import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Omok {
    public Omok(){
        // Frame
        JFrame frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470,500);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("Game menu");
        menuBar.add(menu);

        // Menu Item
        JMenuItem menuItemPlay = new JMenuItem("Play", KeyEvent.VK_P);
        ImageIcon playIcon = new ImageIcon("PlayIcon.png");
        menuItemPlay.setIcon(playIcon);
        menuItemPlay.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        menuItemPlay.getAccessibleContext().setAccessibleDescription(
                "Play game");
        //menuItemPlay.addActionListener(…);
        menu.add(menuItemPlay);
        frame.setJMenuBar(menuBar);

        JMenuItem about = new JMenuItem("About", KeyEvent.VK_A);



        JToolBar toolBar = new JToolBar("Omok");
        JButton button = new JButton("Play");
        //button.addActionListener(…);
        button.setToolTipText("Play a new game");
        button.setFocusPainted(false);
        toolBar.add(button);
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
                double x = p.getX()*10;
                double y = p.getY()*10;
                x = Math.round(x);
                x = x/10;
                y = Math.round(y);
                y = y/10;
                System.out.println(x);
                System.out.println(y);
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
