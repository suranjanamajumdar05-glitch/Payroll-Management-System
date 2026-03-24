// UI- Swing Interface
package payroll;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PayrollGUI {
    public static void main(String[] args) {
        PayrollService service = new PayrollService();
        JFrame frame = new JFrame("Payroll Management System");
        frame.setSize(600,500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ---------- TITLE ----------
        JLabel title = new JLabel("Payroll Management System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        frame.add(title, BorderLayout.NORTH);

        // ---------- INPUT PANEL ----------
        JPanel inputPanel = new JPanel(new GridLayout(6,2,10,10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        JLabel typeLabel = new JLabel("Employee Type:");
        typeLabel.setFont(labelFont);
        String[] types = {"Full Time","Part Time"};
        JComboBox<String> typeBox = new JComboBox<>(types);
        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setFont(labelFont);
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Employee Name:");
        nameLabel.setFont(labelFont);
        JTextField nameField = new JTextField();
        JLabel salaryLabel = new JLabel("Monthly Salary:");
        salaryLabel.setFont(labelFont);
        JTextField salaryField = new JTextField();
        JLabel rateLabel = new JLabel("Hourly Rate:");
        rateLabel.setFont(labelFont);
        JTextField rateField = new JTextField();
        JLabel hoursLabel = new JLabel("Hours Worked:");
        hoursLabel.setFont(labelFont);
        JTextField hoursField = new JTextField();
        inputPanel.add(typeLabel);
        inputPanel.add(typeBox);
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryField);
        inputPanel.add(rateLabel);
        inputPanel.add(rateField);
        inputPanel.add(hoursLabel);
        inputPanel.add(hoursField);
        frame.add(inputPanel, BorderLayout.CENTER);

        // ---------- BUTTON PANEL ----------
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Employee");
        JButton showButton = new JButton("Show Employees");
        addButton.setBackground(Color.GREEN);
        showButton.setBackground(Color.CYAN);
        buttonPanel.add(addButton);
        buttonPanel.add(showButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // ---------- OUTPUT AREA ----------
        JTextArea outputArea = new JTextArea(10,40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.EAST);

        // ---------- INITIAL VISIBILITY ----------
        rateLabel.setVisible(false);
        rateField.setVisible(false);
        hoursLabel.setVisible(false);
        hoursField.setVisible(false);

        // ---------- EMPLOYEE TYPE SELECTION ----------
        typeBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String type = (String) typeBox.getSelectedItem();
                if(type.equals("Full Time")){
                    salaryLabel.setVisible(true);
                    salaryField.setVisible(true);
                    rateLabel.setVisible(false);
                    rateField.setVisible(false);
                    hoursLabel.setVisible(false);
                    hoursField.setVisible(false);
                } else {
                    salaryLabel.setVisible(false);
                    salaryField.setVisible(false);
                    rateLabel.setVisible(true);
                    rateField.setVisible(true);
                    hoursLabel.setVisible(true);
                    hoursField.setVisible(true);
                }
                frame.revalidate();
                frame.repaint();
            }
        });

        // ---------- ADD EMPLOYEE ----------
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    String type = (String) typeBox.getSelectedItem();
                    if(type.equals("Full Time")) {
                        double salary = Double.parseDouble(salaryField.getText());
                        FullTimeEmployee emp =new FullTimeEmployee(id,name,salary);
                        service.addEmployee(emp);
                    } else {
                        double rate = Double.parseDouble(rateField.getText());
                        int hours = Integer.parseInt(hoursField.getText());
                        PartTimeEmployee emp =new PartTimeEmployee(id,name,rate,hours);
                        service.addEmployee(emp);
                    }
                    JOptionPane.showMessageDialog(frame,"Employee Added Successfully");

                    // CLEAR FIELDS
                    idField.setText("");
                    nameField.setText("");
                    salaryField.setText("");
                    rateField.setText("");
                    hoursField.setText("");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame,"Invalid Input!");
                }
            }
        });

        // ---------- SHOW EMPLOYEES ----------
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                for(Employee emp : service.getEmployees()){
                    outputArea.append("ID: "+emp.getId()+" Name: "+emp.getName()+" Salary: "+emp.calculateSalary()+"\n");
                }
                outputArea.append("\nTotal Payroll: "+service.getTotalPayroll());
            }
        });
        frame.setVisible(true);
    }
}