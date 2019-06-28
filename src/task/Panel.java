package task;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {
    private JTable table;
    private JButton toSin;
    private JButton toCos;
    private JButton toTg;
    private JScrollPane scrollPane;
    private String[] headers = {"Угол в градусах", "Угод в радианах", "Результат"};
    private List<Values> sinus;
    private List<Values> cosine;
    private List<Values> tans;
    private String[][] dataToString;
    private int step = 5;
    private int limit = 90;

    public Panel() {
        setLayout(null);

        sinus = new ArrayList<>();
        cosine = new ArrayList<>();
        tans = new ArrayList<>();

        dataToString = new String[this.limit / this.step][this.headers.length];
        init();
        scrollPane = new JScrollPane();

        toSin = new JButton("Синус");
        toSin.setBounds(10, 410, 100, 20);
        toSin.addActionListener(e -> {
            for (int i = 0; i < dataToString.length; i++) {
                String[] valuesAsStringMassive = sinus.get(i).getAsStringMassive();
                System.arraycopy(valuesAsStringMassive, 0, dataToString[i], 0, headers.length);
            }
            table = new JTable(dataToString, headers);
            scrollPane.setViewportView(table);
            scrollPane.setBounds(10, 50, 320, 320);
            this.add(scrollPane);
            repaint();
        });
        add(toSin);

        toCos = new JButton("Косинус");
        toCos.setBounds(110, 410, 100, 20);
        toCos.addActionListener(e -> {
            for (int i = 0; i < dataToString.length; i++) {
                String[] valuesAsStringMassive = cosine.get(i).getAsStringMassive();
                System.arraycopy(valuesAsStringMassive, 0, dataToString[i], 0, headers.length);
            }
            table = new JTable(dataToString, headers);
            scrollPane.setViewportView(table);
            scrollPane.setBounds(10, 50, 320, 320);
            this.add(scrollPane);
            repaint();
        });
        add(toCos);

        toTg = new JButton("Тангес");
        toTg.setBounds(210, 410, 100, 20);
        toTg.addActionListener(e -> {
            for (int i = 0; i < dataToString.length; i++) {
                String[] valuesAsStringMassive = tans.get(i).getAsStringMassive();
                System.arraycopy(valuesAsStringMassive, 0, dataToString[i], 0, headers.length);
            }
            table = new JTable(dataToString, headers);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(10, 50, 320, 320);
            this.add(scrollPane);
            repaint();
        });
        add(toTg);
    }

    private void init() {
        int step = 0;
        while (step <= limit) {
            sinus.add(new Values(Math.toDegrees(step), Math.toRadians(step), Math.sin(step)));
            cosine.add(new Values(Math.toDegrees(step), Math.toRadians(step), Math.cos(step)));
            tans.add(new Values(Math.toDegrees(step), Math.toRadians(step), Math.tan(step)));
            step += this.step;
        }
    }
}
