package valuables.items;

public abstract class Valuable {
	private static final double TAX_PERCENTAGE = 1.25;
	
	private String name;
	
	
	public Valuable(String name){
		this.name = name;
	}
	
	public double getValuePostTax(){
		return getValuePreTax()*TAX_PERCENTAGE;		
	}
	public String getName(){
		return name;
	}
	abstract public double getValuePreTax();
	
}
