package exercise1_2;
import edu.princeton.cs.algs4.*;

public class Q1_2_16_17 {
	public static void main(String[] args) {
		System.out.println("Rational a:");
		System.out.print("numerator:");
		int numerator=StdIn.readInt();
		System.out.print("denominator:");
		int denominator=StdIn.readInt();
		Rational a=new Rational(numerator, denominator);
		
		System.out.println("Rational b:");
		System.out.print("numerator:");
		numerator=StdIn.readInt();
		System.out.print("denominator:");
		denominator=StdIn.readInt();
		Rational b=new Rational(numerator, denominator);
		//此代码存在 溢出无法判断问题
		System.out.println("a plus b:"+a.plus(b));
		System.out.println("a minus b:"+a.minus(b));
		System.out.println("a times b:"+a.times(b));
		System.out.println("a divides b:"+a.divides(b));
		System.out.println("a equals b:"+a.equals(b));
	}	
}

class Rational{
	private int n;
	private int d;
	private static int MAX=2147483647;
	private static int MIN=-2147483647;
	public Rational(int numerator,int denominator){
		if (denominator == 0) {
			throw new ArithmeticException("Divide by zero");
		}
		if (denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}
		n=numerator;
		d=denominator;
	}
	//加法
	public Rational plus(Rational b) {
		assert isPlusOverflow(n*b.d,d*b.n):"Plus Overflow!";
		assert isTimesOverflow(d,b.d):"Times Overflow!";
		return new Rational(n*b.d+d*b.n,d*b.d);
	}
	//减法
    public Rational minus(Rational b) {
    	return new Rational(n*b.d-d*b.n,d*b.d);
	}
    //乘法
    public Rational times(Rational b) {
    	assert isTimesOverflow(n,b.n):"Times Overflow!";
		assert isTimesOverflow(d,b.d):"Times Overflow!";
    	return new Rational(n*b.n,d*b.d);
	}
    //除法
    public Rational divides(Rational b) {
    	return new Rational(n*b.d,d*b.n);
	}
    //判断相等
    public boolean equals(Rational that) {
    	if (this.n!=that.n)
			return false;
    	if (this.d!=that.d)
    		return false;
    	return true;
	}
    public String toString() {
    	if (Math.abs(n) % Math.abs(d)==0)
			return String.valueOf(n/d);
    	int r=gcd(n,d);
    	return n/r+"/"+d/r;
	}
    public boolean isPlusOverflow(int a,int b) {
		return a>0? a+b<MAX:a+b>MAX;
	}
    public boolean isTimesOverflow(int a,int b) {
		if (a<0) a=-a;
		if (b<0) b=-b;
		if (a==0||b==0) return false;
		return a*b<MAX;
	}
	public static int gcd(int p,int q) {
		if (q==0) return p;
		int r=p%q;
		return gcd(q, r);
	}
}