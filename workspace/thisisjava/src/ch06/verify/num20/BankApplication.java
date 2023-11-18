package ch06.verify.num20;

import java.util.Scanner;

public class BankApplication {
	
	static String[][] Accounts = new String[100][3];
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
		System.out.println("---------------------------------");
		System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
		System.out.println("---------------------------------");
		System.out.println("선택> ");
		String choice = scanner.nextLine();
		
		if(choice.equals("1")) MakeAccount();
		else if(choice.equals("2")) ListAccount();
		else if(choice.equals("3")) Deposit();
		else if(choice.equals("4")) Withdraw();
		else if(choice.equals("5")) run = false;
		}
		System.out.println("프로그램 종료");
	}
	
	static void MakeAccount() {
		System.out.println("-------");
		System.out.println("계좌생성");
		System.out.println("-------");
		System.out.println("계좌번호: ");
		String Number = scanner.nextLine();
		System.out.println("계좌주: ");
		String Name = scanner.nextLine();
		System.out.println("초기입금액: ");
		String Income = scanner.nextLine();
		
		Account ac = new Account(Number, Name, Income);
		
		for(int i=0;i<Accounts.length;i++) {
			if(Accounts[i][0] == null) {
				Accounts[i][0] = ac.getNum();
				Accounts[i][1] = ac.getName();
				Accounts[i][2] = ac.getBalance();
				break;
			}
		}
		System.out.println("계좌가 생성되었습니다.");
		
	}
	
	static void ListAccount() {
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");
		for(int i=0; i<Accounts.length; i++) {
			if(Accounts[i][0] != null) {
				for(int k=0; k<3; k++) {
					System.out.print(Accounts[i][k] + "\t");
				}
				System.out.println("");
			} else break;
		}
	}

	static void Deposit() {
		System.out.println("-------");
		System.out.println("예금");
		System.out.println("-------");
		System.out.println("계좌번호: ");
		String Enter_Num = scanner.nextLine();
		for(int i=0; i<Accounts.length; i++) {
			if(Accounts[i][0].equals(Enter_Num)) {
				System.out.println("예금액: ");
				String Enter_Dep = scanner.nextLine();
				int Dep = Integer.parseInt(Enter_Dep);
				int Bal = Integer.parseInt(Accounts[i][2]);
				Bal += Dep;
				Accounts[i][2] = String.valueOf(Bal);
				break;
			} else if(Accounts[i][0] == null) {
				System.out.println("계좌번호가 틀렸습니다.");
				break;
			}
		}
		
	}
	
	static void Withdraw() {
		System.out.println("-------");
		System.out.println("출금");
		System.out.println("-------");
		System.out.println("계좌번호: ");
		String Enter_Num = scanner.nextLine();
		for(int i=0; i<Accounts.length; i++) {
			if(Accounts[i][0].equals(Enter_Num)) {
				System.out.println("출금액: ");
				String Enter_Dep = scanner.nextLine();
				int Dep = Integer.parseInt(Enter_Dep);
				int Bal = Integer.parseInt(Accounts[i][2]);
				Bal -= Dep;
				Accounts[i][2] = String.valueOf(Bal);
				System.out.println("결과: 출금이 성공되었습니다.");
				break;
			} else if(Accounts[i][0] == null) {
				System.out.println("계좌번호가 틀렸습니다.");
				break;
			}
		}
	}
	
}
