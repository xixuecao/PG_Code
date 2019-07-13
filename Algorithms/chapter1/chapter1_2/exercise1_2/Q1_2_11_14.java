package exercise1_2;

public class Q1_2_11_14 {
	private final int month;
	private final int day;
	private final int year;
	
	public Q1_2_11_14(int m,int d,int y) {
		// TODO Auto-generated constructor stub
		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (d>0&&d<=31) {
				month=m;
				day=d;
				year=y;
			}else {
				throw new IllegalArgumentException("Illgal Date!");
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (d>0&&d<=30) {
				month=m;
				day=d;
				year=y;
			}else {
				throw new IllegalArgumentException("Illgal Date!");
			}
			break;
		case 2:
			if (y%4==0&&y%100!=0||y%400==0) {
				if (d>0&&d<=29) {
					month=m;
					day=d;
					year=y;
				}else {
					throw new IllegalArgumentException("Illgal Date!");
				}
			}else {
				if (d>0&&d<=28) {
					month=m;
					day=d;
					year=y;
				}else {
					throw new IllegalArgumentException("Illgal Date!");
				}
			}
			break;
		default:
			throw new IllegalArgumentException("Illgal Date!");
		}
	}
	
	public int month() {return month;}
	public int day() {return day;}
	public int year() {return year;}
	
	public String dayOfTheWeek() {
		int month = this.month;
		int year = this.year;
		if (month <= 2) {
			month += 12;
			year--;
		}
		int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
		switch (week) {
		case 0:
			return "Monday";
		case 1:
			return "Tuesday";
		case 2:
			return "Wednesday";
		case 3:
			return "Thursday";
		case 4:
			return "Friday";
		case 5:
			return "Saturday";
		case 6:
			return "Sunday";
		default:
			return null;
		}
	}
	
	public String toString() {
		return month()+"/"+day()+"/"+year();
	}
	public boolean equals(Object x) {
		if (this==x) return true;
		if (x==null) return false;
		if (this.getClass()!=x.getClass()) return false;
		Q1_2_11_14 that=(Q1_2_11_14) x;
		if (this.day!=that.day) return false;
		if (this.month!=that.month) return false;
		if (this.year!=that.year) return false;
		return true;
	}
	
	public static void main(String[] args) {
		/**
		int m=Integer.parseInt(args[0]);
		int d=Integer.parseInt(args[1]);
		int y=Integer.parseInt(args[2]);
		*/
		int m=5;
		int d=23;
		int y=2017;
		try {
			Q1_2_11_14 date=new Q1_2_11_14(m, d, y);
			System.out.println(date);
			System.out.println(date.dayOfTheWeek());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
