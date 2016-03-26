package valuables.items.comperators;

import java.util.Comparator;

import valuables.items.Valuable;

public class ValueComparator implements Comparator<Valuable>{

	//FIXME
	//This is not accurate if the value is different after the . i.e. 100.1 == 100.5
	@Override
	public int compare(Valuable originalValuable, Valuable otherValuable) {
		return (int) (otherValuable.getValuePostTax()-originalValuable.getValuePostTax());
	}

}
