package sifutokanriwa;

public class Shift {

	int shiftID;
	int stafID;
	String sigotobi;
	String hajimaritime;
	String syuuryoutime;

	public Shift(int shiftID, int staffID, String sigotobi, String hajimaritime, String syuuryoutime, int storeID,
			String jyoutai) {
		this.shiftID = shiftID;
		this.stafID = staffID;
		this.sigotobi = sigotobi;
		this.hajimaritime = hajimaritime;
		this.syuuryoutime = syuuryoutime;
		this.storeID = storeID;
		this.jyoutai = jyoutai;

	}

	//表示
	public void displayShift() {
		System.out.println("シフトID;" + shiftID);
		System.out.println("スタッフID;" + stafID);
		System.out.println("勤務日;" + sigotobi);
		System.out.println("勤務時間;" + hajimaritime + "〜" + syuuryoutime);
		System.out.println("店舗ID;" + storeID);
		System.out.println("シフト情報;" + jyoutai);
	}

	int storeID;
	String jyoutai;
	String status;

}
//sifutoittannowari