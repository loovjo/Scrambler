package com.loovjo.scrambling.scrambler;

import java.util.Random;

public class CubeScrambler4x4 extends CubeScrambler3x3 {
	
	public int getDefaultMaxLength() {
		return 40;
	}
	
	public String getScramble(int maxLength) {
		String scramble = super.getScramble(maxLength);
		
		Random rand = new Random();
		
		String new4x4Scramble = "";
		
		for (String move : scramble.split(" ")) {
			if (rand.nextBoolean()) {
				move = move.replaceAll("[A-Z]", "$0w");
			}
			new4x4Scramble += move + " ";
		}
		
		
		return new4x4Scramble;
	}
}
