package sifutokanriwa;

public class Store {
	int tennpoID;
	String tennponame;
	String jyuusho;

	public Store(int tennpoID, String tennponame, String jyuusho) {
		this.tennpoID = tennpoID;
		this.tennponame = tennponame;
		this.jyuusho = jyuusho;

	}

	public void displayStore() {
		System.out.println("店舗ID;" + tennpoID);
		System.out.println("店舗名;" + tennponame);
		System.out.println("住所;" + jyuusho);
	}
}
//hitomazuowari