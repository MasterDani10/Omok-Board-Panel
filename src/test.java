import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class test {
    public test(){
        //BoardPanel board = new BoardPanel(new Board());
        BoardPanel d = new BoardPanel(new Board());
        d.setSize(d.getPreferredSize());

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470,500);
        d.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(d.getMousePosition());
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        menu.getAccessibleContext().setAccessibleDescription("Game menu");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("Play", KeyEvent.VK_P);
        //menuItem.setIcon(…));
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Play a new game");
        //menuItem.addActionListener(…);
        menu.add(menuItem);
        frame.setJMenuBar(menuBar);


        JToolBar toolBar = new JToolBar("Omok");
        JButton button = new JButton("Play");
        //button.addActionListener(…);
        button.setToolTipText("Play a new game");
        button.setFocusPainted(false);
        toolBar.add(button);
        frame.add(toolBar, BorderLayout.NORTH);
        JPanel center = new JPanel();
        JPanel panel = new JPanel();
        panel.add(new JButton("Play"));
        String[] opponents = {"Human", "Computer"};
        JComboBox comboBox = new JComboBox(opponents);
        panel.add(comboBox);

        center.add(panel);
        center.add(d);
        frame.add(center);
//        frame.getContentPane().add(panel);
//        frame.getContentPane().add(d);
        frame.setVisible(true);
    }
    public static void main (String[] args){
        test t = new test();
    }
    private ImageIcon createImageIcon(String filename) {
        URL imageUrl = test.class.getResource(filename);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        }
        return null;
    }
    protected Image scaleImage(Image image, double scale){
        return image.getScaledInstance(
                (int)(image.getWidth(null)*scale),
                (int)(image.getHeight(null)*scale), 0);

    }

}
