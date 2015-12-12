package com.loovjo.scrambling.scrambler;

import java.util.Random;

public interface CubeScrambler {
	
	public int getDefaultMaxLength();
	
	public String getScramble(int maxLength);
	
	public static String genScrambleFromLetters(String moves, String suffixes, int length) {

		Random rand = new Random();
		
		String scramble = "";
		String last = "";
		
		for (int i = 0; i < length; i++) {
			String current = last;
			while (current.equals(last)) {
				current = moves.charAt(rand.nextInt(moves.length())) + "";
			}
			last = current;
			scramble += current + (suffixes.charAt(rand.nextInt(suffixes.length())) + "").trim() + " ";
		}
		
		return scramble;
	}
	
}
