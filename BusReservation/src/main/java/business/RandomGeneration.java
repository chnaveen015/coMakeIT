package business;

import java.util.Random;

public class RandomGeneration {
	public int getPnr() {
		// TODO Auto-generated method stub
		Random reservationBean = new Random();
		int pnr = reservationBean.nextInt(60000) + 10000;
		return pnr;
	}
}
