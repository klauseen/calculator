package main.java;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class CalculatorUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField display;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorUI frame = new CalculatorUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorUI() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 490);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		display = new JTextField();
		display.setFont(new Font("Tahoma", Font.PLAIN, 14));
		display.setBounds(10, 34, 296, 73);
		contentPane.add(display);
		display.setColumns(10);

		display.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Result();
				}
			}
		});

		ActionListener commonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();

				processButtons(command);
			}
		};

		JButton btnDel = new JButton("DEL");
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnDel.setBounds(20, 159, 49, 29);
		contentPane.add(btnDel);
		btnDel.addActionListener(commonListener);

		JButton btnAC = new JButton("AC");
		btnAC.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAC.setBounds(92, 159, 49, 29);
		contentPane.add(btnAC);
		btnAC.addActionListener(commonListener);

		JButton btnPercentage = new JButton("%");
		btnPercentage.setBounds(166, 159, 49, 29);
		contentPane.add(btnPercentage);
		btnPercentage.addActionListener(commonListener);

		JButton btnDivision = new JButton("/");
		btnDivision.setBounds(240, 159, 49, 29);
		contentPane.add(btnDivision);
		btnDivision.addActionListener(commonListener);

		JButton btnSeven = new JButton("7");
		btnSeven.setBounds(20, 199, 49, 29);
		contentPane.add(btnSeven);
		btnSeven.addActionListener(commonListener);

		JButton btnEight = new JButton("8");
		btnEight.setBounds(92, 199, 49, 29);
		contentPane.add(btnEight);
		btnEight.addActionListener(commonListener);

		JButton btnNine = new JButton("9");
		btnNine.setBounds(166, 199, 49, 29);
		contentPane.add(btnNine);
		btnNine.addActionListener(commonListener);

		JButton btnMultiplication = new JButton("*");
		btnMultiplication.setBounds(240, 199, 49, 29);
		contentPane.add(btnMultiplication);
		btnMultiplication.addActionListener(commonListener);

		JButton btnFour = new JButton("4");
		btnFour.setBounds(20, 243, 49, 29);
		contentPane.add(btnFour);
		btnFour.addActionListener(commonListener);

		JButton btnFive = new JButton("5");
		btnFive.setBounds(92, 243, 49, 29);
		contentPane.add(btnFive);
		btnFive.addActionListener(commonListener);

		JButton btnSix = new JButton("6");
		btnSix.setBounds(166, 243, 49, 29);
		contentPane.add(btnSix);
		btnSix.addActionListener(commonListener);

		JButton btnSubtraction = new JButton("-");
		btnSubtraction.setBounds(240, 243, 49, 29);
		contentPane.add(btnSubtraction);
		btnSubtraction.addActionListener(commonListener);

		JButton btnOne = new JButton("1");
		btnOne.setBounds(20, 287, 49, 29);
		contentPane.add(btnOne);
		btnOne.addActionListener(commonListener);

		JButton btnTwo = new JButton("2");
		btnTwo.setBounds(92, 287, 49, 29);
		contentPane.add(btnTwo);
		btnTwo.addActionListener(commonListener);

		JButton btnThree = new JButton("3");
		btnThree.setBounds(166, 287, 49, 29);
		contentPane.add(btnThree);
		btnThree.addActionListener(commonListener);

		JButton btnAddition = new JButton("+");
		btnAddition.setBounds(240, 287, 49, 29);
		contentPane.add(btnAddition);
		btnAddition.addActionListener(commonListener);

		JButton btnZero = new JButton("0");
		btnZero.setBounds(92, 330, 49, 29);
		contentPane.add(btnZero);
		btnZero.addActionListener(commonListener);

		JButton btnDot = new JButton(".");
		btnDot.setBounds(166, 330, 49, 29);
		contentPane.add(btnDot);
		btnDot.addActionListener(commonListener);

		JButton btnEqual = new JButton("=");
		btnEqual.setBounds(240, 330, 49, 29);
		contentPane.add(btnEqual);
		btnEqual.addActionListener(commonListener);
	}

	private static void processButtons(String text) {
		switch (text) {
		case "AC":
			display.setText("");
			break;
		case "DEL":
			String current = display.getText();
			if (!current.isEmpty()) {
				display.setText(current.substring(0, current.length() - 1));
			}
			break;
		case "%":
			try {
				double value = Double.parseDouble(display.getText());
				double result = value / 100;
				display.setText(String.valueOf(result));
			} catch (Exception e) {
				display.setText("Error");
			}
			break;
		case "=":
			Result();
			break;
		default:
			display.setText(display.getText() + text);
			break;
		}
	}

	private static void Result() {
		String[] parts;
		double number1;
		double number2;
		String input = display.getText();
		double result = 0;

		if (input.isEmpty())
			return;

		try {
			if (input.contains("+")) {
				parts = input.split("\\+");
				if (parts.length >= 2) {
					number1 = Double.parseDouble(parts[0]);
					number2 = Double.parseDouble(parts[1]);
					result = Calculator.addition(number1, number2);
					display.setText(String.valueOf(result));
				}
			} else if (input.contains("*")) {
				parts = input.split("\\*");
				if (parts.length >= 2) {
					number1 = Double.parseDouble(parts[0]);
					number2 = Double.parseDouble(parts[1]);
					result = Calculator.multiplication(number1, number2);
					display.setText(String.valueOf(result));
				}
			} else if (input.contains("/")) {
				parts = input.split("\\/");
				if (parts.length >= 2) {
					number1 = Double.parseDouble(parts[0]);
					number2 = Double.parseDouble(parts[1]);
					result = Calculator.division(number1, number2);
					display.setText(String.valueOf(result));
				}
			} else if (input.contains("-")) {
				int operatorIndex = -1;

				for (int i = 1; i < input.length(); i++) {
					char c = input.charAt(i);

					if (c == '-' && Character.isDigit(input.charAt(i - 1))) {
						operatorIndex = i;
						break;
					}
				}

				if (operatorIndex != -1) {
					String part1 = input.substring(0, operatorIndex);
					String part2 = input.substring(operatorIndex + 1);

					if (!part1.isEmpty() && !part2.isEmpty()) {
						number1 = Double.parseDouble(part1);
						number2 = Double.parseDouble(part2);
						result = Calculator.subtraction(number1, number2);
						display.setText(String.valueOf(result));
					}
				}
			} else {
				return;
			}

		} finally {
			System.out.println("Calculation completed");
		}
	}
}
