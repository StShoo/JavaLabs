package com.company;
import javax.swing.*;
import java.awt.*;

public class Task2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lab3 Task2");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        frame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 200, 400, 400);

        String[] language = new String[]{"Java", "Py", "C#", "C++", "JS", "Ruby", "Kot", "PHP", "Go"};
        int[] value = new int[]{ 2500,9000,7000,1000,4000,7000 };
        Color[] colors = new Color[]{ Color.green, Color.yellow };

        MyBarComponent myBarComponent = new MyBarComponent(colors, language, value);
        frame.add(myBarComponent);
    }

    static class MyBarComponent extends JComponent {
        private final Color[] colors;
        private final String[] labels;
        private final int[] value;

        public MyBarComponent(Color[] colors, String[] labels, int[] value) {
            this.colors = colors;
            this.labels = labels;
            this.value = value;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Font font = new Font("Calibri", Font.BOLD, 18);
            Graphics2D g2 = (Graphics2D) g;

            g2.setFont(font);

            g2.drawString("My Graphic", 160, 50);
            int maxvalue = this.value[0];
            for (int i : value) {
                if (i > maxvalue)
                    maxvalue = i;
            }

            int count = maxvalue / 100;
            g.setColor(Color.BLACK);

            g.drawLine(50, 250, 50, 100);
            g.drawLine(50, 250, 350, 250);

            for (int j = 0; j < value.length; j++) {
                g2.setPaint(colors[j % 2]);
                int height = this.value[j] / count;
                int padding = 100 / (value.length / 3);

                System.out.println(height);
                g2.fillRect((100 - 30 - padding) + padding * (j + 1), 250 - height, 100 / value.length, height);

                g2.setColor(Color.BLACK);
                g2.drawString(this.value[j] / 100 + "%", 10, 250 - height);
                g2.setColor(Color.blue);
                g2.drawString(this.labels[j], (100 - 30 - padding) + padding * (j + 1), 275);
            }
        }
    }
}
