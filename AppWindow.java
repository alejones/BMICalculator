import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppWindow extends JFrame {

	final int DEFAULT_WIDTH = 600;
	final int DEFAULT_HEIGHT = 300;
	final String DEFAULT_TITLE = "BMI Calculator";
	private JLabel bmiLabel;
	private JTextField weightField, heightFtField, heightInField,bmiField;
	
	private class QuitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class ComputeButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int weight;
			int heightIN;
			int heightFT;
			double bmi;
			
			weight = Integer.parseInt(weightField.getText());
			heightIN = Integer.parseInt(heightInField.getText());
			heightFT = Integer.parseInt(heightFtField.getText());
			
			bmi = (703 * weight);
			bmi = bmi / Math.pow(((heightFT * 12) + heightIN),2); 
			
			bmiField.setText(String.valueOf(bmi));
			
			setBmi(bmi);
			
		}

		private void setBmi(double userBmi) {
			Color fieldColor = Color.pink;
			String bmiLabelText = "Underweight";
			
			if(userBmi > 30) {
				fieldColor = Color.red;
				bmiLabelText = "Obese";
			}
			else if(userBmi >= 25) {
				fieldColor = Color.magenta;
				bmiLabelText = "Overweight";
			}
			else if(userBmi >= 18.5) {
				fieldColor = Color.green;
				bmiLabelText = "Normal weight";
			}
			
			bmiField.setBackground(fieldColor);
			bmiLabel.setText("BMI => "+ bmiLabelText + " ");
			
		}
	}
	
	public AppWindow() {
		Container windowPane;
		setTitle(DEFAULT_TITLE);
		
		windowPane = getContentPane();
		windowPane.setLayout(new GridLayout(5,2));
		JLabel weightLabel = new JLabel("Weight (pounds) ", SwingConstants.RIGHT);
		weightField = new JTextField(10);
		weightField.isFocusable();
		JLabel heightFtLabel = new JLabel("Height (feet) ", SwingConstants.RIGHT);
		heightFtField = new JTextField();
		JLabel heightInLabel = new JLabel("Height (inches) ", SwingConstants.RIGHT);
		heightInField = new JTextField(10);
		bmiLabel = new JLabel("BMI ", SwingConstants.RIGHT);
		bmiField = new JTextField(10);
		bmiField.setEditable(false);
		
		windowPane.add(weightLabel);
		windowPane.add(weightField);
		windowPane.add(heightFtLabel);
		windowPane.add(heightFtField);
		windowPane.add(heightInLabel);
		windowPane.add(heightInField);
		windowPane.add(bmiLabel);
		windowPane.add(bmiField);
		
		JButton computeButton = new JButton("Compute BMI");
		ComputeButtonHandler computerButtonHandler = new ComputeButtonHandler();
		computeButton.addActionListener(computerButtonHandler);

		JButton quitButton = new JButton("Quit");
		QuitButtonHandler quitButtonHandler = new QuitButtonHandler();
		quitButton.addActionListener(quitButtonHandler);
				
		windowPane.add(computeButton);
		windowPane.add(quitButton);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
