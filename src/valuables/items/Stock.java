package valuables.items;

public class Stock extends Valuable{
	private int numberOfStock;
	private double exchangeRate;
	
	public Stock(String name, int numberOfStock, double exchangeRate){
		super(name);
		this.numberOfStock = numberOfStock;
		this.exchangeRate = exchangeRate;
	}
	public void setExchangeRate(int newExchangeRate){
		this.exchangeRate = newExchangeRate;		
	}
	@Override
	public double getValuePreTax(){
		return numberOfStock*exchangeRate;
	}
	@Override
	public String[] getSpecialVariables() {
		String outNumberOfStock = "antal:"+numberOfStock;
		String outExchangeRate = "exchange rate:"+exchangeRate;
		String[] output = {outNumberOfStock,outExchangeRate};
		return output;
	}
}
