import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{
	
	Font commonFont;
	JTextField textField;
	JFrame appFrame;
	JPanel panel;
	JButton[] numberButtons;
	JButton[] functionButtons;
	JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;
	double num1, num2, result;
	char operator;
	
	Calculator(){
		
		commonFont = new Font("TimesRoman", Font.BOLD, 20);
		
		appFrame = new JFrame("Calculator");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setSize(420, 550);
		appFrame.setResizable(false);
		appFrame.setLocationRelativeTo(null);
		appFrame.setLayout(null);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		numberButtons = new JButton[10];
		functionButtons = new JButton[9];
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(commonFont);
		}
		for(int i =0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(commonFont);
			functionButtons[i].setFocusable(false);
		}
		
		textField = new JTextField();
		textField.setFont(commonFont);
		textField.setEditable(false);
		textField.setBounds(20, 40, 360, 50);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("");
		
		panel = new JPanel();
		panel.setBounds(50, 125, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		negButton.setBounds(50, 440, 100, 50);
		delButton.setBounds(150, 440, 100, 50);
		clrButton.setBounds(250, 440, 100, 50);
		
		appFrame.add(panel);
		appFrame.add(negButton);
		appFrame.add(delButton);
		appFrame.add(clrButton);
		appFrame.add(textField);
		appFrame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 1; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));	
			}
		}
		if(e.getSource() == numberButtons[0] && !textField.getText().isEmpty()) {
			textField.setText(textField.getText().concat("0"));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(e.getSource() == decButton) {
			if(!textField.getText().contains(".")) {
				if(textField.getText().isEmpty()) {
					textField.setText(textField.getText().concat("0."));
				}
				else {
					textField.setText(textField.getText().concat("."));
				}
			}
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());
			switch(operator) {
			
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			if(result%1 != 0) {
				textField.setText(String.valueOf(result));
			}
			else {
				textField.setText(String.valueOf((int)result));
			}
			num1 = result;
			
		}
		if(e.getSource() == clrButton) {
			textField.setText("");
		}
		if(e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i = 0; i < string.length()-1; i++) {
				textField.setText(textField.getText()+ string.charAt(i));
			}
		}
		if(e.getSource() == negButton) {
			if(!textField.getText().isEmpty()) {
				double temp = Double.parseDouble(textField.getText());
				if(temp%1 != 0) {
					temp = -temp;
					textField.setText(String.valueOf(temp));
				}
				else {
					temp = -temp;
					textField.setText(String.valueOf((int)temp));
				}
				
			}
		}
	}

}
