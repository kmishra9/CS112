package logic;

public class MainLogic {
	String random1, random2, random3;
	int index = 0;
	public MainLogic() {
		random1 = "Kunal";
		random2 = "Alex";
		random3 = "Avi";
	}
	
	public String getRandom() {
		/*Get the next value of the random strings*/
		String[] s = {random1, random2, random3};
		
		return s[index++ % s.length];
	}
	

}
