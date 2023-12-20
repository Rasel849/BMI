/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BMIServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

public class BMIClient extends JFrame {
    private BMIService bmiService;

    public BMIClient() {
        super("BMI Calculator");

        try {
            bmiService = (BMIService) Naming.lookup("rmi://localhost:1099/BMIService");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the BMI server.");
            System.exit(1);
        }

        initializeUI();
    }

    private void initializeUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel weightLabel = new JLabel("Weight (kg):");
        JTextField weightField = new JTextField();

        JLabel heightLabel = new JLabel("Height (m):");
        JTextField heightField = new JTextField();

        JButton calculateButton = new JButton("Calculate BMI");
        JLabel resultLabel = new JLabel("BMI Result:");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    double bmiResult = bmiService.calculateBMI(weight, height);

                    resultLabel.setText("BMI Result: " + bmiResult);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BMIClient.this, "Invalid input. Please enter valid numbers.");
                }
            }
        });

        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(calculateButton);
        panel.add(resultLabel);

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        BMIClient client = new BMIClient();
        client.setVisible(true);
    }
}
