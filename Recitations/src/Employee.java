
public class Employee {
	
	private String name;
	private double balance;
	private double rate;
	
	public void employee(String name, double balance, double rate){
		this.name = name;
		this.rate = rate;
		this.balance = balance;
	}
	
	public void employee(String name, double rate){
		this.name = name;
		this.rate = rate;
		this.balance = 0;
	}
	
	public void work(int hours){
		balance = balance + hours*rate;
	}
	
	public void spend(double money){
		balance = balance - money;
	}
	
	public void printInfo(){
		System.out.println("Employee name is" + name + ", rate is " + rate + ",balance is " + balance);
	}

}
