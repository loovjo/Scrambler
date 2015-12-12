package com.loovjo.scrambling.scrambler;

import java.util.Random;

public class CubeScrambler1x1 implements CubeScrambler {

	@Override
	public int getDefaultMaxLength() {
		return 2;
	}

	@Override
	public String getScramble(int maxLength) {
		return CubeScrambler.genScrambleFromLetters("xyz", " ' '2", new Random().nextInt(maxLength) + 1);
	}

}
