package valuables;

public class Device extends Valuable{
	private double originalPrice;
	private int wear;
	
	public Device(String name, double originalPrice, int wear){
		super(name);
		this.originalPrice = originalPrice;
		this.wear = wear;
	}

	@Override
	public double getValuePreTax() {		
		return ((double)originalPrice)*(((double)wear)/10);
	}
	

}
