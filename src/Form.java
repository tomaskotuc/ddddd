import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class Form extends JFrame {
    private JPanel panel;
    private JTextArea textArea;
    private JButton button;
    private String text;

    public Form() {
        initComponents();
    }

    private void initComponents() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setTitle("Test");
        setLocationRelativeTo(null);
        JMenu menu = new JMenu("Možnosti");
        menu.setMnemonic(KeyEvent.VK_A);


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        JMenu submenu = new JMenu("Submenu");
        JMenuItem subMenuItem = new JMenuItem("Submenu");
        editMenu.add(submenu);
        submenu.add(subMenuItem);





        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));


        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        setJMenuBar(menuBar);





        newMenuItem.addActionListener(e -> pozdrav());
        button.addActionListener(e -> nacti());


    }
    private void pozdrav() {
        JOptionPane.showMessageDialog(this, "Nový soubor úspěšně založen");
    }
    private void nacti() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/text.txt"));
            String input = reader.readLine();
            while (input != null) {
                input.trim().toLowerCase();
                textArea.append(input);
                input = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
