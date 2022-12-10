import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM extends JFrame implements ActionListener {
    // create the user interface
    private JButton depositButton = new JButton("Deposit");
    private JButton withdrawButton = new JButton("Withdraw");
    private JButton checkBalanceButton = new JButton("Check Balance");
    private JButton exitButton = new JButton("Exit");
    private JTextField amountTextField = new JTextField();
    private JLabel amountLabel = new JLabel("Enter amount: ");

    private double balance = 0;

    public ATM() {
        setTitle("ATM");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(amountLabel);
        panel.add(amountTextField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(checkBalanceButton);
        panel.add(exitButton);

        add(panel);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            String amountString = amountTextField.getText();
            double amount = Double.parseDouble(amountString);
            balance += amount;
            JOptionPane.showMessageDialog(this, "Your new balance is: " + balance);
        } else if (e.getSource() == withdrawButton) {
            String amountString = amountTextField.getText();
            double amount = Double.parseDouble(amountString);
            if (amount <= balance) {
                balance -= amount;
                JOptionPane.showMessageDialog(this, "Your new balance is: " + balance);
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds");
            }
        } else if (e.getSource() == checkBalanceButton) {
            JOptionPane.showMessageDialog(this, "Your balance is: " + balance);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.setVisible(true);
    }
}
