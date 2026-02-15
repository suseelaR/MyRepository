/*
 Java applet to perform arithmetic operations between two numbers using swing.
*/
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArithmeticApplet extends JApplet implements ActionListener {

    JTextField t1, t2, result;
    JButton add, sub, mul, div;

    public void init() {

        setLayout(new FlowLayout());

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        result = new JTextField(10);
        result.setEditable(false);

        add = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        div = new JButton("Divide");

        add(new JLabel("Number 1:"));
        add(t1);

        add(new JLabel("Number 2:"));
        add(t2);

        add(add);
        add(sub);
        add(mul);
        add(div);

        add(new JLabel("Result:"));
        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        double num1 = Double.parseDouble(t1.getText());
        double num2 = Double.parseDouble(t2.getText());
        double res = 0;

        if (e.getSource() == add)
            res = num1 + num2;

        else if (e.getSource() == sub)
            res = num1 - num2;

        else if (e.getSource() == mul)
            res = num1 * num2;

        else if (e.getSource() == div)
            res = num1 / num2;

        result.setText(String.valueOf(res));
    }
}
