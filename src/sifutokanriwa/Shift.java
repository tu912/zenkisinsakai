package sifutokanriwa;

public class Shift {

	int shiftID;
	int stafID;
	String sigotobi;
	String hajimaritime;
	String syuuryoutime;

	public Shift(int shiftID, int staffID, String sigotobi, String hajimaritime, String syuuryoutime) {
		this.shiftID = shiftID;
		this.stafID = staffID;
		this.sigotobi = sigotobi;
		this.hajimaritime = hajimaritime;
		this.syuuryoutime = syuuryoutime;

	}

	public void displaySHift() {
		System.out.println("シフトID;" + shiftID);
		System.out.println("スタッフID;" + stafID);
		System.out.println("勤務日;" + sigotobi);
		System.out.println("勤務時間;" + hajimaritime + "〜" + syuuryoutime);
	}

}
//sifutoittannowari