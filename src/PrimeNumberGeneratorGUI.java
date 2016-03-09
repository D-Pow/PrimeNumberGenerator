/*PrimeNumberGeneratorGUI.java
 * This is a GUI for the prime number generator
 * @author D-Pow, 9-24-15
 */

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.SwingUtilities.*;

public class PrimeNumberGeneratorGUI extends javax.swing.JFrame {
    public PrimeNumberGeneratorGUI() {
        initComponents();
    }
    
    public List generatePrimeNumbers() {
        //This is the part that actually generates the prime numbers
        List primeNumbers = new ArrayList();
        
        primeNumbers.clear(); //Resets prime number list
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);
        //Initialize primeNumbers with some primes.
        int x = 9; //Starting point is 9
            
        int numberOfPrimes;
        try {
            numberOfPrimes = Integer.parseInt(numberOfPrimesBox.getText());
        }
        catch (NumberFormatException e) {
            return null;
        }
        
        int i = 0;
        while (primeNumbers.size() < numberOfPrimes) {
            for (Object num : primeNumbers) {
                i = (int) num;
                
                if (x % i == 0) {
                    break;
                }
            }
            if (x % i != 0) {
                primeNumbers.add(x);
            }
            x = x + 2; //We will ignore all even numbers.
        }//ends the creation of the primeNumbers list
        
        return primeNumbers;
    } //end the math part of the code

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allPrimeNumbers = new javax.swing.JTextArea();
        numberOfPrimesBox = new javax.swing.JTextField();
        generateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prime Number Generator"));

        allPrimeNumbers.setColumns(20);
        allPrimeNumbers.setLineWrap(true);
        allPrimeNumbers.setRows(5);
        allPrimeNumbers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                allPrimeNumbersKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(allPrimeNumbers);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        numberOfPrimesBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numberOfPrimesBox.setText("Enter number of prime numbers");
        numberOfPrimesBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numberOfPrimesBoxFocusGained(evt);
            }
        });
        numberOfPrimesBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numberOfPrimesBoxKeyPressed(evt);
            }
        });

        generateButton.setText("Generate!");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberOfPrimesBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(generateButton)
                        .addGap(66, 66, 66)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numberOfPrimesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generateButton)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        //What happens when the "Generate!" button is pressed
        List primes = generatePrimeNumbers();
        if (primes == null) {
            allPrimeNumbers.setText("You need to input an integer");
        }
        else{
            allPrimeNumbers.setText(primes.toString());
        }
        allPrimeNumbers.setWrapStyleWord(true);
        //if generatePrimeNumbers is null, then the user input something wrong and they need to be corrected
        //if they input an integer, set the text in the (large) text field to the generated list (as a string).
        //The final line sets the wrap style of the output text field to wrap based on words, not characters.
    }                                              

    private void numberOfPrimesBoxFocusGained(java.awt.event.FocusEvent evt) {                                              
        numberOfPrimesBox.setText(""); //This sets the text in the input box to blank
                                        //when the user clicks in it.
    }                                             

    private void numberOfPrimesBoxKeyPressed(java.awt.event.KeyEvent evt) {                                             
        javax.swing.SwingUtilities.getRootPane(generateButton).setDefaultButton(generateButton);
    }                                            

    private void allPrimeNumbersKeyPressed(java.awt.event.KeyEvent evt) {                                           
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            allPrimeNumbers.transferFocus();
            //tranferFocus() is a method that shifts focus from one field to another.
        }
    }                                          

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrimeNumberGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrimeNumberGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrimeNumberGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrimeNumberGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrimeNumberGeneratorGUI pngGUI = new PrimeNumberGeneratorGUI();
                pngGUI.setTitle("Prime Number Generator");
                pngGUI.setAlwaysOnTop(false);
                pngGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
                pngGUI.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea allPrimeNumbers;
    private javax.swing.JButton generateButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numberOfPrimesBox;
    // End of variables declaration                   
}
