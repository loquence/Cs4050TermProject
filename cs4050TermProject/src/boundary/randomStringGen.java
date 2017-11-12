package randomString;

import java.util.Random;

public class randomStringGen {

	public static void main(String[] args) {
		
		System.out.println(getString());
		// TODO Auto-generated method stub

	}

	protected static String getString() {
        String SCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringGen = new StringBuilder();
        Random rnd = new Random();
        while (stringGen.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SCHARS.length());
            stringGen.append(SCHARS.charAt(index));
        }
        String sStr = stringGen.toString();
        return sStr;

    }	
	
	
}
