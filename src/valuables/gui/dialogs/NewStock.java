package valuables.gui.dialogs;

import java.awt.Component;
import java.awt.FlowLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valuables.items.Stock;
import valuables.items.Valuable;

public class NewStock extends NewValuable{
	
	private JLabel exchangeRateText = new JLabel("Exchange rate:");
	private JTextField exchangeRateInput = new JTextField(10);
	private JLabel numberOfStocksText = new JLabel("Number of stocks:");
	private JTextField numberOfStocksInput = new JTextField(10);
	
	public NewStock(Component parent){
		super(parent);
		JPanel mainPanel = getMainPanel();
		mainPanel.add(getExchangePanel());
		mainPanel.add(getNumberPanel());
	}
	private JPanel getExchangePanel(){
		JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		valuePanel.add(exchangeRateText);
		valuePanel.add(exchangeRateInput);		
		return valuePanel;
	}
	private JPanel getNumberPanel(){
		JPanel wearPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		wearPanel.add(numberOfStocksText);
		wearPanel.add(numberOfStocksInput);
		return wearPanel;
	}
	public double getExchangeRate(){
		double output = -1;
		try{
			output = Integer.parseInt(exchangeRateInput.getText());
		}
		catch(NumberFormatException e){
			
		}
		return output;		
	}
	public int getWear(){
		int output = -1;
		try{
			output = Integer.parseInt(numberOfStocksInput.getText());
		}
		catch(NumberFormatException e){
			
		}
		return output;
	}
	@Override
	public Valuable getValuable() {
		Stock stock = null;
		String name = getName();
		double exchangeRate = roundDouble(getExchangeRate());
		int amountOfStock = getWear();
		stock = new Stock(name, amountOfStock, exchangeRate);
		
		return stock;
	}
	private double roundDouble(double d){
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		double roundedDouble = Double.parseDouble(df.format(d));
		return roundedDouble;
	}
	@Override
	public boolean checkInput() {
		String errors = "";
		boolean isCorrect = true;
		
		if(!checkName()){
			isCorrect = false;
			errors+="Names cannot be empty! \n";
		}
		if(!checkExchangeRate()){
			isCorrect = false;
			errors+="Exchange rate must be a number!\n";
		}
		if(!checkNumberOfStocks()){
			isCorrect = false;
			errors+="Number of stocks must be an integer!";
		}
		if(!isCorrect){
			showError(errors);
		}
		return isCorrect;
	}
	private boolean checkExchangeRate(){
		boolean isCorrect = false;
		try{
			if(Double.parseDouble(exchangeRateInput.getText().trim())>0)
				isCorrect = true;
			}
		catch(NumberFormatException e){}
		return isCorrect;
	}
	private boolean checkNumberOfStocks(){
		boolean isCorrect = false;
		
		try{
			if(Integer.parseInt(numberOfStocksInput.getText().trim())>0)
				isCorrect = true;
		}
		catch(NumberFormatException e){}
		
		return isCorrect;
	}
}
