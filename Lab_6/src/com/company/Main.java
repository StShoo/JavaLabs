package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static boolean changeColor = false;
    static boolean draw = true;
    static boolean delete =false;
    static JFrame frame;
    static DrawFigure drawFigure = new DrawFigure();
    static int[] sides = new int[3];
    static final JLabel[] labels = new JLabel[3];
    static final JTextField[] inputs = new JTextField[3];
    static final JButton btn = new JButton("Програма розрахуй");

    public static void main(String[] args) {
        Font labelFont = new Font("Calibri ", Font.BOLD, 18);
        Font fieldFont = new Font("Calibri ", Font.PLAIN, 16);
        Font buttonFont = new Font("Anton", Font.PLAIN, 20);

        Color blue = new Color(46, 126, 255);
        Color agree = new Color(43, 145, 51);
        Color desagree = new Color(161, 34, 27);

        Border blueBorder = BorderFactory.createLineBorder(blue);


        frame = new JFrame("Lab6");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 200, 700, 400);

        frame.setLayout(new GridLayout(0, 2));
        frame.add(drawFigure);
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 20));
        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel("Введіть - " + (i+1) + " сторону:");
            label.setFont(fieldFont);
            panel.add(label);
            JTextField textField = new JTextField();
            textField.setFont(fieldFont);
            textField.setBorder(blueBorder);
            inputs[i] = textField;
            panel.add(textField);
        }
        btn.addActionListener(Main::calculate);
        panel.add(btn);
        frame.add(panel);
        createBarMenu();

        frame.setVisible(true);

    }

    private static void createBarMenu() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file_menu = new JMenu("Програма");
        JMenu edit_menu = new JMenu("Правка");
        JMenu triangle_menu = new JMenu("Трикутник");

        JMenuItem check = file_menu.add(new JMenuItem("перевірка"));
        JMenuItem calculate = file_menu.add(new JMenuItem("обчислити"));

        file_menu.addSeparator();

        JMenuItem exit = file_menu.add(new JMenuItem("Вихід"));

        JMenuItem copy = edit_menu.add(new JMenuItem("Копіювати"));
        JMenuItem paste = edit_menu.add(new JMenuItem("Вставити"));

        JMenuItem color = triangle_menu.add(new JMenuItem("Змінити колір"));
        JMenuItem delete = triangle_menu.add(new JMenuItem("Видалити"));

        jMenuBar.add(file_menu);
        jMenuBar.add(edit_menu);
        jMenuBar.add(triangle_menu);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        check.addActionListener(Main::check);
        calculate.addActionListener(Main::calculate);

        delete.addActionListener(Main::delete);
        color.addActionListener(e -> color(Color.red));
        frame.setJMenuBar(jMenuBar);
    }

    private static void color(Color color) {
        drawFigure.set_color(color);
        frame.revalidate();

    }

    static void delete(ActionEvent e) {
        drawFigure.deletes();
        frame.revalidate();
    }

    static void check(ActionEvent e) {
        if (isExistTriangle(2, 2, 3))
            printMessage("Трикутник існує", "check");
        else
            printMessage("Трикутник не існує", "check");

    }

    static void calculate(ActionEvent e) {
        for (int i = 0; i < inputs.length; i++) {
            String text = inputs[i].getText();
            sides[i] = formatString(text);
        }
        areaOfTriangle(sides[0], sides[1], sides[2]);
        frame.revalidate();
    }

    static int formatString(String number) {
        number = number.trim();
        return Integer.parseInt(number);
    }

    static class DrawFigure extends JComponent {
        private int[] sides;


        private Graphics2D g2;

        @Override
        protected void paintComponent(Graphics g) {
            g2 = (Graphics2D) g;
            if(draw) {
                int x[] = {100, 70, 130};
                int y[] = {50, 100, 100};
                g2.setPaint(Color.green);
                g2.fillPolygon(x, y, 3);
                frame.repaint();

            }
            if(changeColor){
                int x[] = {100, 70, 130};
                int y[] = {50, 100, 100};
                g2.setPaint(Color.red);
                g2.fillPolygon(x, y, 3);
                frame.repaint();
            }
            if(delete){
                frame.repaint();
            }

        }

        public void remove_figure() {
            changeColor = true;
            draw =false;
            delete =false;

        }

        public void deletes(){
            changeColor = false;
            draw =false;
            delete =true;
        }

        public void set_color(Color color) {
            remove_figure();
        }
        private boolean checkSide(int[] sides) {
            for (float side : sides) {
                if (side < 0) {
                    return false;
                }
            }
            return true;
        }

    }

    static public void areaOfTriangle(int a, int b, int c) {


        float p = (a + b + c);
        float halfP = p / 2;

        float area = (float) Math.sqrt(halfP * (halfP - a) * (halfP - b) * (halfP - c));

        float radiusIncircle = area / halfP;

        double radiusCircumCircle = 3.14 * Math.pow(((a * b * c) / (4 * area)), 2);

        String message = "";
        message += "радіус вписаного кола" + radiusIncircle;
        message += "радіус описаного кола" + radiusCircumCircle;
        printMessage(message, "calculate");
        System.out.println(radiusIncircle);
        System.out.println(radiusCircumCircle);
    }

    private static void printMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    private static boolean isExistTriangle(int a, int b, int c) {
        return (a + b > c && a + c > b && b + c > a);
    }

}
