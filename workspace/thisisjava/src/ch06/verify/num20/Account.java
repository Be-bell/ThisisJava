package ch06.verify.num20;

public class Account {
	private String account_num;
	private String name;
	private String balance;
	
	public Account(String account_num, String name, String balance) {
		this.account_num = account_num;
		this.name = name;
		this.balance = balance;
	}
	
	public String getNum() {
		return account_num;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBalance() {
		return balance;
	}
}
