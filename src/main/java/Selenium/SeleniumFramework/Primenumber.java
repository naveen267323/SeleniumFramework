package Selenium.SeleniumFramework;

public class Primenumber {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int p = 20;
		System.out.println("Number " + isprime(p));
		
		
	}

	public static boolean isprime(int p) {

		if (p <= 1) {
			return false;
		}

		for (int i = 2; i <= p; i++) {
			if (p % i == 0) {
				return false;
			}
		}
		return true;

	}

}
