package com.loovjo.scrambling.scrambler;

import java.util.Random;

public class CubeScramblerPyra implements CubeScrambler {

	@Override
	public int getDefaultMaxLength() {
		return 11;
	}

	@Override
	public String getScramble(int maxLength) {
		Random rand = new Random();
		return CubeScrambler.genScrambleFromLetters("RULB", " ''", maxLength - rand.nextInt(rand.nextInt(maxLength) + 1));
	}

}
