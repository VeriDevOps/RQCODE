package rqcode.stigs.win10_new.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParameterEntryForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Parameter Entry Form");
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("STIG number:");
        JTextField nameTextField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                JOptionPane.showMessageDialog(frame, "Hello, " + name);
            }
        });

        panel.setLayout(new FlowLayout());
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
