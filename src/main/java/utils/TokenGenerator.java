package utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TokenGenerator {

	public static String generate() {
		SecureRandom random = new SecureRandom();
		String token = new BigInteger(130, random).toString(32);
		return token;
	}
}
