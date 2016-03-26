package valuables;

import valuables.gui.*;
import valuables.items.*;

public class ValuableRegister {

	public static void main(String[] args) {
		ValuableRegister thisValuableRegister = new ValuableRegister();
		thisValuableRegister.run();
	}
	
	private void run(){
		ValuableHandler var = new ValuableHandler();
		var.addValuable(new Stock("LUPE", 5000, 135));
		var.addValuable(new Stock("PULE", 500, 56.3));
		var.addValuable(new Stock("SUPE", 250, 123.32));
		var.addValuable(new Jewelry("halsband", 20, true));
		var.addValuable(new Jewelry("ring", 5, false));
		var.addValuable(new Jewelry("bla", 15, true));
		var.addValuable(new Device("TV", 5000, 8));
		var.addValuable(new Device("Dator", 20000, 7));
		var.addValuable(new Device("iPhone", 5000, 3));

		for(Valuable v : var.getValuables()){
			System.out.println(v.getName() +" "+ v.getValuePreTax() +" "+ v.getValuePostTax());
		}
		
		Frame frame = new Frame();
			
	}
}
