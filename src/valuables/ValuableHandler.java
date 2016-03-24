package valuables;

import java.util.ArrayList;

public class ValuableHandler {
	private final ValuableRegister valuableRegister;
	
	private ArrayList<Valuable> valuables = new ArrayList<>();
	
	public ValuableHandler(ValuableRegister valuableRegister){
		this.valuableRegister = valuableRegister;		
	}

	public ArrayList<Valuable> getValuables() {
		return valuables;
	}
	public void addValuable(Valuable valuable){
		valuables.add(valuable);
	}
	public void addMultipleValuables(ArrayList<Valuable> valuables){
		this.valuables.addAll(valuables);
	}
}
