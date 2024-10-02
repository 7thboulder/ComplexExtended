import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ComplexGUI extends JFrame{
    private JTextField realNumber1;
    private JTextField imaginaryNumber1;


    private JTextField realNumber2;
    private JTextField imaginaryNumber2;

    private JLabel operatorLabel;
    private ButtonGroup operatorButtons;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton calculateButton;

    private JLabel resultText;

    private String operatorSelected;
    /**
     * Creates new form ComplexGUI
     */
    public ComplexGUI() {
        operatorSelected = "none";
        //super.setResizable(false);
        super.setSize(400,400);
        initComponents();
    }

    private void initComponents() {
        realNumber1 = new JTextField();
        imaginaryNumber1 = new JTextField();
        
        realNumber2 = new JTextField();
        imaginaryNumber2 = new JTextField();

        operatorLabel = new JLabel();

        operatorButtons = new ButtonGroup();
        addButton = new JButton();
        subtractButton = new JButton();
        multiplyButton = new JButton();
        divideButton = new JButton();

        calculateButton = new JButton();

        resultText = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        realNumber1.setColumns(5);
        imaginaryNumber1.setColumns(5);
        
        realNumber2.setColumns(5);
        imaginaryNumber2.setColumns(5);

        addButton.setText("+");
        operatorButtons.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        subtractButton.setText("-");
        operatorButtons.add(subtractButton);
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                subtractButtonActionPerformed(evt);
            }
        });

        multiplyButton.setText("x");
        operatorButtons.add(multiplyButton);
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                multiplyButtonActionPerformed(evt);
            }
        });

        divideButton.setText("/");
        operatorButtons.add(divideButton);
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                divideButtonActionPerformed(evt);
            }
        });

        resultText.setText("  ");

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel iSymbol1 = new JLabel("i");
        JLabel iSymbol2 = new JLabel("i");
        JLabel plusSymbol1 = new JLabel("+");
        JLabel plusSymbol2 = new JLabel("+");
        
        realNumber1.setBounds(10,35,40,25);
        plusSymbol1.setBounds(51, 35, 9, 25);
        imaginaryNumber1.setBounds(60,35,40,25);
        iSymbol1.setBounds(102, 35, 5, 25 );

        operatorLabel.setBounds(135,35,15,15);

        realNumber2.setBounds(160,35,40,25);
        plusSymbol2.setBounds(201, 35, 9, 25);
        imaginaryNumber2.setBounds(210,35,40,25);
        iSymbol2.setBounds(252, 35, 5, 25 );

        addButton.setBounds(10,75,35,25);
        subtractButton.setBounds(50,75,35,25);
        multiplyButton.setBounds(90,75,35,25);
        divideButton.setBounds(130,75,35,25);
        
        resultText.setBounds(10,175,300,25);

        calculateButton.setBounds(50,125,80,25);
        
        mainPanel.add(realNumber1);
        mainPanel.add(plusSymbol1);
        mainPanel.add(imaginaryNumber1);
        mainPanel.add(iSymbol1);
        mainPanel.add(operatorLabel);
        
        mainPanel.add(realNumber2);
        mainPanel.add(plusSymbol2);
        mainPanel.add(imaginaryNumber2);
        mainPanel.add(iSymbol2);

        mainPanel.add(addButton);
        mainPanel.add(subtractButton);
        mainPanel.add(multiplyButton);
        mainPanel.add(divideButton);
        
        mainPanel.add(resultText);

        mainPanel.add(calculateButton);

        getContentPane().add(mainPanel);
    }

    private void addButtonActionPerformed(ActionEvent evt) {
        operatorSelected = "+";
        operatorLabel.setText(operatorSelected);
    }

    private void subtractButtonActionPerformed(ActionEvent evt) {
        operatorSelected = "-";
        operatorLabel.setText(operatorSelected);
    }

    private void multiplyButtonActionPerformed(ActionEvent evt) {
        operatorSelected = "x";
        operatorLabel.setText(operatorSelected);
    }

    private void divideButtonActionPerformed(ActionEvent evt) {
        operatorSelected = "/";
        operatorLabel.setText(operatorSelected);
    }

    private void calculateButtonActionPerformed(ActionEvent evt) {
        Rational realNumber1Value, imaginaryNumber1Value;
        Rational realNumber2Value, imaginaryNumber2Value;
        
        try{
            realNumber1Value   = new Rational(Integer.parseInt(realNumber1.getText()));
        }catch(NumberFormatException e){
            realNumber1Value = new Rational(0);
            realNumber1.setText("0");
        }
        try{
            imaginaryNumber1Value = new Rational(Integer.parseInt(imaginaryNumber1.getText()));
        }catch(NumberFormatException e){
            imaginaryNumber1Value = new Rational(0);
            imaginaryNumber1.setText("0");
        }

        try{
            realNumber2Value   = new Rational(Integer.parseInt(realNumber2.getText()));
        }catch(NumberFormatException e){
            realNumber2Value = new Rational(0);
            realNumber2.setText("0");
        }
        try{
            imaginaryNumber2Value = new Rational(Integer.parseInt(imaginaryNumber2.getText()));
        }catch(NumberFormatException e){
            imaginaryNumber2Value = new Rational(0);
            imaginaryNumber2.setText("0");
        }

        try{
            Complex complex1;
            if (imaginaryNumber1Value.equals(new Rational(0)))
                complex1 = new Complex(realNumber1Value);
            else
                complex1 = new Complex(realNumber1Value, imaginaryNumber1Value);
            Complex complex2;
            if (imaginaryNumber2Value.equals(new Rational(0)))
                complex2 = new Complex(realNumber2Value);
            else
                complex2 = new Complex(realNumber2Value, imaginaryNumber2Value);

            Complex result;
            if (operatorSelected.equals("+"))
                result = complex1.add(complex2);
            else if (operatorSelected.equals("-"))
                result = complex1.subtract(complex2);
            else if (operatorSelected.equals("x"))
                result = complex1.multiply(complex2);
            else if (operatorSelected.equals("/"))
                result = complex1.divide(complex2);
            else
                result = new Complex(new Rational(0));

            resultText.setText(result.toString());

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ComplexGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComplexGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComplexGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComplexGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComplexGUI().setVisible(true);
            }
        });
    }
}
