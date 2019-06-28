package task;

import javax.swing.*;

public class Main {
    private JFrame window;

    public Main() {
        window = new JFrame("Индивидуальное задание");
        window.setSize(400,520);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Panel());
        window.setVisible(true);
    }

    public static void main(String[] args) {
        // write your code here
        new Main();
    }
}
