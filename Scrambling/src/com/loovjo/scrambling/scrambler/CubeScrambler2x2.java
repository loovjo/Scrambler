package com.loovjo.scrambling.scrambler;

import java.util.Random;

public class CubeScrambler2x2 implements CubeScrambler {

	@Override
	public int getDefaultMaxLength() {
		return 11;
	}
	
	
	@Override
	public String getScramble(int maxLength) {
		Random rand = new Random();
		return CubeScrambler.genScrambleFromLetters("RUL", " ' '2", maxLength - rand.nextInt(rand.nextInt(maxLength) + 1));
	}

}
