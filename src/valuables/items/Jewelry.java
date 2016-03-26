package valuables.items;

public class Jewelry extends Valuable{
	private int numberOfStones;
	private boolean gold;
	
	public Jewelry(String name, int numberOfStones, boolean gold){
		super(name);
		this.numberOfStones = numberOfStones;
		this.gold = gold;
	}

	@Override
	public double getValuePreTax() {
		int value = 700;
		if(gold){
			value = 2000;
		}
		return value + (numberOfStones*500);
	}
	
}
