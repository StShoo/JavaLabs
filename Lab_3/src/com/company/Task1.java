package com.company;
import javax.swing.*;
import java.awt.*;

public class Task1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab3 Task1");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 200, 400, 400);
        frame.add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {

            final Color fontColor = Color.red;
            Font font = new Font("Times New Roman",Font.BOLD, 14);
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(font);
            g2.setPaint(fontColor);
            g2.drawString("Шедевр", 160, 50);


            int x1[]={220, 100, 50, 50, 340};
            int y1[]={50, 100, 150, 240, 240};

            g2.setColor(Color.red);
            g2.fillPolygon(x1, y1, y1.length);

            int x2[]={220, 120, 70, 70, 320};
            int y2[]={80, 120, 150, 220, 220};

            g2.setColor(Color.green);
            g2.fillPolygon(x2, y2, y2.length);

            int x3[]={200, 130, 100, 150, 250};
            int y3[]={100, 125, 170, 200, 200};

            g2.setColor(Color.blue);
            g2.fillPolygon(x3, y3, y3.length);
//
//            Color color1 = Color.blue;
//            Color color2 = Color.yellow;
//            GradientPaint gp = new GradientPaint(startPosition+2*margin+100, startPosition+margin, color1, 100, 100, color2);
//            g2.setPaint(gp);
//            g2.fillRect(startPosition+2*margin+100, startPosition+margin, 100, 100);
//
//            g2.setPaint(Color.black);
//            g2.fillOval(startPosition, 100+startPosition+3*margin, 100, 100);

        }
    }
}
