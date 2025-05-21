package com.module2CToption2.model;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class BirthDateGUI extends JFrame implements ActionListener {

	//labels, text field, and button
	private JLabel ageLabel;
	private JLabel inputLabel;
	private JFormattedTextField userAgeField;
	private JButton calcAgeBtn;
	
	//constructor creates and populates frame
	BirthDateGUI(){
		
		GridBagConstraints layoutConst = null;
		
		//set title and create labels
		setTitle("Age Calculator");
		inputLabel = new JLabel("Enter your birth year here: ");
		ageLabel = new JLabel("Age: ");
		
		//create text field
		userAgeField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		userAgeField.setEditable(true);
		userAgeField.setColumns(10);
		
		//create button
		calcAgeBtn = new JButton("Calculate Age");
		calcAgeBtn.addActionListener(this);
		
		//use gridbaglayout
		setLayout(new GridBagLayout());
		
		//populate gridbag with times
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		add(inputLabel, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		add(userAgeField, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		add(calcAgeBtn, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		add(ageLabel, layoutConst);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		final int currYear = 2025;
		int userYear;
		
		//retrieve users birth year
		userYear = ((Number) userAgeField.getValue()).intValue();
		
		//ensure year is valid
		if(userYear < 2026 && userYear > 1899) {
			userYear = currYear - userYear;
			ageLabel.setText("Age: " + Integer.toString(userYear));
		}
		//if year is not valid
		else {
			JOptionPane.showMessageDialog(this, "Enter a valid year! (>=1900, <=2025)");
		}
		
	}
	
	public static void main(String[] args) {
		//create instance of GUI class
		BirthDateGUI userAge =  new BirthDateGUI();
		
		userAge.setDefaultCloseOperation(EXIT_ON_CLOSE);
		userAge.pack();
		userAge.setVisible(true);
	}
}
