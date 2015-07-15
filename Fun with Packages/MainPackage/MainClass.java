package MainPackage;

import MyBag.*;

public class MainClass {
	
	public static void main(String[] args){
		int x = Input.getGoodInt(0, 5);
		int y = Input.getGoodInt(5, 10);

		System.out.println(NewMath.derpAdd(x,y));
	}
}
	