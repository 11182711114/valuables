package valuables.items;

public abstract class Valuable{
	private static final double TAX_PERCENTAGE = 1.25;
	
	private String name;
	
	String fullClassName = this.getClass().getName();								//gets the full class path as string
	String className = fullClassName.substring(fullClassName.lastIndexOf('.')+1);	//trims fullClassName to after last '.'(i.e. only the class name)
	
	
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
	
	public String toPrint(){
		String output = className +": "+ getName() +" "+ getValuePostTax() +" ";
		for(String s : getSpecialVariables()){
			output+=s+" ";
		}
		return output;	
	}
	abstract public String[] getSpecialVariables();
		
	public String toString(){
		return className +" "+ getName() +" "+ getValuePreTax() +" "+ getValuePostTax();
	}
}
