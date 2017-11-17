import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Подсчет");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Введите число:");
    private JRadioButton radio1 = new JRadioButton("Перевод в 2");
    private JRadioButton radio2 = new JRadioButton("Перевод из 2");
    private JRadioButton radio3 = new JRadioButton("Перевод в фибо");
    private JRadioButton radio4 = new JRadioButton("Перевод из фибо");


    public SimpleGUI() {
        super("Калькулятор");
        this.setBounds(400,400,550,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,3,2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        group.add(radio4);
        container.add(radio1);

        radio1.setSelected(true);
        container.add(radio2);
        container.add(radio3);
        container.add(radio4);

        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repository repo=new repository();
            String message = "";
            message += "Подсчет произведен\n";
            message += "Введеное число " + input.getText() + "\n";
            message += (radio1.isSelected()?repo.СonversionTo2(input.getText()):"Radio #2")
                    + " is selected\n";
            if(radio1.isSelected())
                message +=repo.СonversionTo2(input.getText());
            else
             if(radio2.isSelected())
                message += repo.ConversationFrom2(input.getText());
            else
             if(radio3.isSelected())
                message += repo.ConversationToFibo(input.getText());
            else message += repo.ConversationFromFibo(input.getText());

            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}