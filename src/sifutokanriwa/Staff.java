package sifutokanriwa;

public class Staff {

	int stafID;
	String name;
	String roru;

	public Staff(int stafID, String name, String email, String password, String roru) {
		this.stafID = stafID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roru = roru;
	}

	public void displayInfo() {
		System.out.println("スタッフID;" + stafID);
		System.out.println("名前;" + name);
		System.out.println("役割;" + roru);
		System.out.println("メールアドレス;" + email);
	}

	String password;
	String email;

}
//sutaffu一様終わり
