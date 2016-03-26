package valuables.items;

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
		return originalPrice*(( (double) wear )/10);
	}
	

}
