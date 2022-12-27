package simplecalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, multi;
    JButton clear, cancel, equal, plus, minus, times, divide, dot, bracket1, bracket2;
    static String number = "", number1 = "", bracketin = "";//store the number entered from keyboard  
    static JTextArea area;
    static boolean tvcompute;//if there is no operator return that number without any operation
    static String store = "";//it store all equation for further calculation

    //this method used for displaying GUI
    SimpleCalculator() {

        super("Calculator");

        area = new JTextArea(4, 20);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
        area.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        area.setFont(new Font("Monospaced", 1, 20));
        area.setBorder(new LineBorder(Color.BLACK, 1));

        JScrollPane pane = new JScrollPane(area);

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");

        minus = new JButton("-");
        plus = new JButton("+");
        times = new JButton("*");
        divide = new JButton("/");
        dot = new JButton(".");
        multi = new JButton("^");
        cancel = new JButton("DEL");
        clear = new JButton("C");
        equal = new JButton("=");
        bracket1 = new JButton("(");
        bracket2 = new JButton(")");

        JPanel bracket = new JPanel(new GridLayout(1, 2));
        bracket.add(bracket1);
        bracket.add(bracket2);

        equal.setFont(new Font("Monospaced", 1, 30));
        dot.setFont(new Font("Monospaced", 1, 30));
        clear.setFont(new Font("plain", 1, 30));
        cancel.setFont(new Font("plain", 1, 15));
        cancel.setBackground(Color.LIGHT_GRAY);
        clear.setBackground(Color.LIGHT_GRAY);

        JPanel p1 = new JPanel(new GridLayout(5, 4));
        p1.setBorder(new LineBorder(Color.BLACK, 2));

        equal.setBackground(Color.DARK_GRAY);
        equal.setForeground(Color.WHITE);
        equal.setFont(new Font("Monospaced", 1, 30));

        dot.setBackground(Color.DARK_GRAY);
        dot.setForeground(Color.WHITE);
        dot.setFont(new Font("Monospaced", 1, 30));

        cancel.setFont(new Font("plain", 1, 15));
        cancel.setBackground(Color.LIGHT_GRAY);

        clear.setFont(new Font("plain", 1, 30));
        clear.setBackground(Color.LIGHT_GRAY);

        minus.setBackground(Color.DARK_GRAY);
        minus.setForeground(Color.WHITE);
        minus.setFont(new Font("plain", 1, 20));
        plus.setBackground(Color.DARK_GRAY);
        plus.setForeground(Color.WHITE);
        plus.setFont(new Font("plain", 1, 20));
        times.setBackground(Color.DARK_GRAY);
        times.setForeground(Color.WHITE);
        times.setFont(new Font("plain", 1, 20));
        multi.setBackground(Color.DARK_GRAY);
        multi.setForeground(Color.WHITE);
        multi.setFont(new Font("plain", 1, 20));
        divide.setBackground(Color.DARK_GRAY);
        divide.setForeground(Color.WHITE);
        divide.setFont(new Font("plain", 1, 20));

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("plain", 1, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("plain", 1, 15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("plain", 1, 15));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("plain", 1, 15));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("plain", 1, 15));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("plain", 1, 15));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setFont(new Font("plain", 1, 15));
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setFont(new Font("plain", 1, 15));
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setFont(new Font("plain", 1, 15));
        b0.setBackground(Color.BLACK);
        b0.setForeground(Color.WHITE);
        b0.setFont(new Font("plain", 1, 15));

        bracket1.setBackground(Color.DARK_GRAY);
        bracket1.setForeground(Color.WHITE);
        bracket1.setFont(new Font("plain", 1, 20));
        bracket2.setBackground(Color.DARK_GRAY);
        bracket2.setForeground(Color.WHITE);
        bracket2.setFont(new Font("plain", 1, 20));

        p1.add(clear);
        p1.add(bracket);
        p1.add(divide);
        p1.add(cancel);

        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p1.add(minus);

        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(plus);

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(times);

        p1.add(multi);
        p1.add(b0);
        p1.add(dot);
        p1.add(equal);

        add(pane, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);

        ButtonHandler handler = new ButtonHandler();

        b0.addActionListener(handler);
        b1.addActionListener(handler);
        b2.addActionListener(handler);
        b3.addActionListener(handler);
        b4.addActionListener(handler);
        b5.addActionListener(handler);
        b6.addActionListener(handler);
        b7.addActionListener(handler);
        b8.addActionListener(handler);
        b9.addActionListener(handler);

        plus.addActionListener(handler);
        minus.addActionListener(handler);
        times.addActionListener(handler);
        divide.addActionListener(handler);
        multi.addActionListener(handler);
        dot.addActionListener(handler);
        clear.addActionListener(handler);
        cancel.addActionListener(handler);
        equal.addActionListener(handler);
        bracket1.addActionListener(handler);
        bracket2.addActionListener(handler);
    }

    public class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == b0) {
                store = store + b0.getText();
                area.setText(store);
            } else if (e.getSource() == b1) {
                store = store + b1.getText();
                area.setText(store);
            } else if (e.getSource() == b2) {
                store = store + b2.getText();
                area.setText(store);
            } else if (e.getSource() == b3) {
                store = store + b3.getText();
                area.setText(store);
            } else if (e.getSource() == b4) {
                store = store + b4.getText();
                area.setText(store);
            } else if (e.getSource() == b5) {
                store = store + b5.getText();
                area.setText(store);
            } else if (e.getSource() == b6) {
                store = store + b6.getText();
                area.setText(store);
            } else if (e.getSource() == b7) {
                store = store + b7.getText();
                area.setText(store);
            } else if (e.getSource() == b8) {
                store = store + b8.getText();
                area.setText(store);
            } else if (e.getSource() == b9) {
                store = store + b9.getText();
                area.setText(store);
            } else if (e.getSource() == bracket1) {
                store = store + bracket1.getText();
                area.setText(store);
            } else if (e.getSource() == bracket2) {
                store = store + bracket2.getText();
                area.setText(store);
            } else if (e.getSource() == divide) {
                store = store + divide.getText();
                area.setText(store);
            } else if (e.getSource() == minus) {
                store = store + minus.getText();
                area.setText(store);
            } else if (e.getSource() == plus) {
                store = store + plus.getText();
                area.setText(store);
            } else if (e.getSource() == times) {
                store = store + times.getText();
                area.setText(store);
            } else if (e.getSource() == dot) {
                store = store + dot.getText();
                area.setText(store);
            } else if (e.getSource() == multi) {
                store = store + multi.getText();
                area.setText(store);
            } else if (e.getSource() == clear) {
                store = store + clear.getText();
                store = "";
                area.setText(store);
            } else if (e.getSource() == equal) {

                number = area.getText();

                char charnumber1[] = number.toCharArray();
                String numberstar = "";

                //if there is no any operator between bracket like ()() the program automatically add star between two brackets
                for (int i = 0; i < number.length(); i++) {
                    if (charnumber1[i] == '(' && i != 0) {
                        if (charnumber1[i - 1] != '+' && charnumber1[i - 1] != '-' && charnumber1[i - 1] != '*' && charnumber1[i - 1] != '/' && charnumber1[i - 1] != '^') {
                            numberstar += "*";
                        }
                    }
                    numberstar += charnumber1[i];

                    if (charnumber1[i] == ')' && i != 0 && i != (number.length() - 1)) {
                        if (charnumber1[i + 1] != '+' && charnumber1[i + 1] != '-' && charnumber1[i + 1] != '*' && charnumber1[i + 1] != '/' && charnumber1[i + 1] != '^') {
                            numberstar += "*";
                        }
                    }
                }

                number = numberstar;

                if (charnumber1[0] != '(') {
                    // to embed parenthesis 
                    String s = "(";
                    s += number;
                    number = s;
                    number += ')';
                }

                getEquation();
                area.setText(number1);

                //used for clear after equal sign are clicked and store the result
                store = number1;
            } else if (e.getSource() == cancel) {
                /*
                 change the string to arrays of character and get the length of the array,
                 then decrement length of the array by one and store the value to ch3
                 */
                char ch2[] = store.toCharArray();

                //check if the string is empty
                if (ch2.length - 1 < 1) {
                    store = "";
                    area.setText(store);
                } else {
                    char[] ch3 = new char[(store.toCharArray().length - 1)];
                    System.arraycopy(ch2, 0, ch3, 0, store.toCharArray().length - 1);
                    store = String.valueOf(ch3);// change arrays of character back to string
                    area.setText(store);
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleCalculator frame = new SimpleCalculator();

        frame.setSize(350, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void getEquation() {

        char charnum[] = number.toCharArray();
        boolean tv = false;
        tvcompute = true;

        for (int i = 0; i < number.length(); i++) {

            String num1 = "", num2 = "", num3 = "";//used fore temporarly storage num1 for bracket num2 for before bracket num3 after bracket

            if (charnum[i] == ')') {
                for (int j = i - 1; j >= 0; j--) {
                    if (charnum[j] != '(') {
                        num1 += String.valueOf(charnum[j]);
                    } else {
                        StringBuilder builder = new StringBuilder();

                        builder.append(num1);
                        builder.reverse();
                        num1 = builder.toString();

                        for (int k = 0; k < j; k++) {
                            num2 += String.valueOf(charnum[k]);
                        }

                        for (int k = (i + 1); k < charnum.length; k++) {
                            num3 += String.valueOf(charnum[k]);
                        }

                        number1 = "";
                        num2 += bracket(num1);
                        num2 += num3;
                        number = num2;

                        getEquation();

                        tv = true;
                        break;
                    }
                }
            }
            if (tv) {//check if there any operator remain without calculation
                bracket(number);
                break;
            }
        }
    }

    static String divide(String left, String right) {
        double value = (Double.parseDouble(left)) / (Double.parseDouble(right));
        return String.valueOf(value);
    }

    static String addition(String left, String right) {
        double value = (Double.parseDouble(left)) + (Double.parseDouble(right));
        return String.valueOf(value);
    }

    static String substruction(String left, String right) {
        double value = (Double.parseDouble(left)) - (Double.parseDouble(right));
        return String.valueOf(value);
    }

    static String multiplication(String left, String right) {
        double value = (Double.parseDouble(left)) * (Double.parseDouble(right));
        return String.valueOf(value);
    }

    static void compute(char ch[], int jj) {

        String num1 = "", num3 = "";

        String concright = "";
        String concleft = "";
        int right = 0, left = 0;

        //getting number after operator
        for (int ic = jj + 1; ic < ch.length; ic++) {
            if ((ch[ic - 1] == '^' || ch[ic - 1] == '*' || ch[ic - 1] == '+' || ch[ic - 1] == '-' || ch[ic - 1] == '/') && (ch[ic] == '+' || ch[ic] == '-')) {
                concright += String.valueOf(ch[ic]);
                right++;
            } else if (ch[ic] == '.' || ch[ic] == '1' || ch[ic] == '2' || ch[ic] == '3' || ch[ic] == '4' || ch[ic] == '4' || ch[ic] == '5' || ch[ic] == '6' || ch[ic] == '7' || ch[ic] == '8' || ch[ic] == '9' || ch[ic] == '0') {
                concright += String.valueOf(ch[ic]);
                right++;
            } else {
                break;
            }
        }

        for (int ic = jj - 1; ic >= 0; ic--) {
            if ((ic == 0) && (ch[ic] == '+' || ch[ic] == '-')) {
                concleft += String.valueOf(ch[ic]);
                left++;
            } else if (ch[ic] == '.' || ch[ic] == '1' || ch[ic] == '2' || ch[ic] == '3' || ch[ic] == '4' || ch[ic] == '4' || ch[ic] == '5' || ch[ic] == '6' || ch[ic] == '7' || ch[ic] == '8' || ch[ic] == '9' || ch[ic] == '0') {
                concleft += String.valueOf(ch[ic]);
                left++;
            } else {
                break;
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append(concleft);
        builder.reverse();
        concleft = builder.toString();

        for (int t = 0; t < (jj - left); t++) {
            num1 += String.valueOf(ch[t]);
        }
        /* +1 is added because it start from the next one right and left priviously occupied 
                (jj -left means from the first index before left the +1 mean after (jj-left)and left and right*/
        for (int t = (left + right + (jj - left) + 1); t < ch.length; t++) {
            num3 += String.valueOf(ch[t]);
        }

        number1 = num1;

        try {
            switch (ch[jj]) {
                case '+':
                    number1 += addition(concleft, concright);
                    break;
                case '/':
                    number1 += divide(concleft, concright);
                    break;
                case '*':
                    number1 += multiplication(concleft, concright);
                    break;
                case '-':
                    number1 += substruction(concleft, concright);
                    break;
                case '^':
                    number1 += Math.pow(Double.parseDouble(concleft), Double.parseDouble(concright));
                    break;
            }

        } catch (NumberFormatException | ArithmeticException e) {

        }

        number1 += num3;
    }

    static String bracket(String s) {

        //jj start with 1 b/c a number start with *and/ rather than +- lead an error
        bracketin = s;
        /*bracketin is a temporary variable for bracket, its value changed each time the if statement is excuted
         it helps not calling bracket method recursively */

        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '^') {
                compute(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }

        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '/') {
                compute(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }
        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '*') {
                compute(ch, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }

        for (int jj = 1; jj < bracketin.length(); jj++) {
            char ch[] = bracketin.toCharArray();
            if (ch[jj] == '-') {
                if (ch[jj - 1] == '*' || ch[jj - 1] == '/') {
                    break;
                } else if (ch[jj - 1] == '+') {//if the + sign   appear before - sign ignore + sign b/c no change in computing

                    char ch1[] = new char[bracketin.length() - 1];
                    for (int i = 0; i < ch1.length; i++) {
                        if (i >= (jj - 1)) {
                            ch1[i] = ch[i + 1];
                        } else {
                            ch1[i] = ch[i];
                        }
                    }

                    compute(ch1, jj - 1);
                    bracketin = number1;
                    tvcompute = false;
                    jj = 0;
                } else {
                    compute(ch, jj);
                    bracketin = number1;
                    tvcompute = false;
                    jj = 0;
                }
            }
        }

        for (int jj = 1; jj < bracketin.length(); jj++) {
            char cha[] = bracketin.toCharArray();
            if (cha[jj] == '+') {
                if (cha[jj - 1] == '*' || cha[jj - 1] == '/' || cha[jj - 1] == '-') {
                    break;
                }
                compute(cha, jj);
                bracketin = number1;
                tvcompute = false;
                jj = 0;
            }
        }

        // if there is no any computation from the above return the entered number
        if (tvcompute) {
            number1 = s;
        }

        return number1;
    }

}
