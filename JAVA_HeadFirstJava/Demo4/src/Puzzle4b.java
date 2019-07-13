

class Puzzle4b{
	private int ivar;
	public void setivar(int i) {
		ivar=i;
	}
	public int doStuff(int factor){
		if (ivar>100){
			return ivar*factor;
		}else {
			return ivar*(5-factor);
		}
	}
}

