package valuables;

public class Stock extends Valuable{
	private int numberOfStock;
	private double exchangeRate;
	
	public Stock(String name, int numberOfStock, double exchangeRate){
		super(name);
		this.numberOfStock = numberOfStock;
		this.exchangeRate = exchangeRate;
	}
	@Override
	public double getValuePreTax(){
		return numberOfStock*exchangeRate;
	}
}
