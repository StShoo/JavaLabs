package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Shell shell = new Shell();
    }
    static public class Shell extends Component {
        static JFrame frame = new JFrame();
        static JPanel panel = new JPanel(new GridBagLayout());

        static JLabel name, city, address, contactPerson, telephone, Email;
        static JLabel[] labels = new JLabel[]{
                name, city, address, contactPerson, telephone, Email};
        static JCheckBox checkBox;

        ArrayList<JTextField> arrayListTextField = new ArrayList<JTextField>();
        static String[] names = new String[]{ "Інформація про організацію", "Назва *", "Місто *", "Адреса *",
                "Контактна особа", "Контактна особа *", "Телефон *", "E-mail *"
        };
        JButton cancel, send;

        Shell() {

            Font font = new Font("Calibri ", Font.BOLD, 18);

            Font font1 = new Font("Calibri ", Font.BOLD, 14);

            Color blue = Color.blue;

            JFrame frame = getFrame();
            frame.add(panel);
            panel.setLayout(null);

            int x = 20;
            int y = 0;
            for (int i = 0; i < labels.length; i++) {
                if (i == 0 || i == 4) {
                    JLabel label = new JLabel(names[i]);
                    y = y + 10 * i;
                    label.setBounds(x, y, 350, 50);
                    label.setFont(font);
                    label.setForeground(blue);
                    panel.add(label);

                }
                labels[i] = new JLabel(names[i]);
                labels[i].setFont(font1);
                y = y + 50;
                labels[i].setBounds(x, y, 250, 50);
                panel.add(labels[i]);
                JTextField textField = new JTextField(20);
                arrayListTextField.add(textField);
                textField.setBounds(x + 250, y + 15, 250, 25);
                panel.add(textField);
            }

            String path = "java.png";
            URL imgURL = Shell.class.getResource(path);

            ImageIcon icon = new ImageIcon(imgURL);
            System.out.println(icon);
            JLabel testimage = new JLabel();
            testimage.setIcon(icon);
            testimage.setBounds(575, 40, 50, 70);
            panel.add(testimage);

            checkBox = new JCheckBox("Хочу отримувати розсилку ");
            checkBox.setBounds(20, 400, 250, 50);
            checkBox.setFont(font1);
            panel.add(checkBox);

            JButton button = new JButton("Скасувати");
            button.setBounds(390, 410, 125, 35);
            button.setBackground(Color.red);
            button.setForeground(Color.white);
            button.setFont(new Font("Serif", Font.PLAIN, 16));
            button.addActionListener(this::close);
            panel.add(button);


            JButton button1 = new JButton("Надіслати");
            button1.setBounds(540, 410, 125, 35);
            button1.setBackground(Color.GREEN);
            button1.setForeground(Color.white);
            button1.setFont(new Font("Serif", Font.PLAIN, 16));
            button1.addActionListener(this::actionPerformed);
            panel.add(button1);

            frame.setVisible(true);
            panel.revalidate();
        }


        private boolean isEmptyArray() {
            return arrayListTextField.stream()
                    .map(jTextField -> jTextField.getText().trim().isEmpty())
                    .distinct()
                    .filter(objectt -> objectt.equals(true))
                    .findAny()
                    .orElse(Boolean.FALSE);
        }

        public void close(ActionEvent e){
            JOptionPane.showMessageDialog(this, "Нам шкода, \n" + "що ви не надали інформацію", "Message",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        public void actionPerformed(ActionEvent e) {

            if(isEmptyArray()){
                JOptionPane.showMessageDialog(this, "Заповніть усі поля  ", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!checkBox.isSelected()) {
                JOptionPane.showMessageDialog(this, "активуйте чекбокс", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Дякуємо, ми \n" + "обробляємо вашу інформацію", "Message",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

        }

        static JFrame getFrame() {
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("my app");
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            frame.setBounds(dimension.width / 2 - 350, dimension.height / 2 - 250, 700, 500);
            return frame;
        }
    }
}
