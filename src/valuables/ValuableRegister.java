package valuables;

public class ValuableRegister {

	private ValuableHandler valuableHandler;
	
	public static void main(String[] args) {
		ValuableRegister thisValuableRegister = new ValuableRegister();
		thisValuableRegister.start(thisValuableRegister);
	}
	private void start(ValuableRegister r){
		r.init();
		r.run();
	}
	private void run(){
		valuableHandler.startGUI();			
	}
	private void init(){
		valuableHandler = new ValuableHandler();
	}
}
