package com.loovjo.scrambling.scrambler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CubeScrambler3x3 implements CubeScrambler {

	@Override
	public int getDefaultMaxLength() {
		return 20;
	}

	@Override
	public String getScramble(int maxLength) {
		Random rand = new Random();
		
		String mods = " ' '2";
		
		String scramble = "";
		
		String lastMove = "R";
		
		ArrayList<String> pairs = new ArrayList<String>(Arrays.asList(new String[] {
				"RL", "LR",
				"UD", "DU",
				"FB", "BF"
				}));
		
		for (int i = 0; i < maxLength; i++) {
			String currentMove = lastMove;
			while (pairs.contains(currentMove + lastMove) || currentMove.equals(lastMove)) {
				currentMove = pairs.get(rand.nextInt(pairs.size())).substring(0, 1);
			}
			scramble += (currentMove + mods.charAt(rand.nextInt(mods.length()))).trim() + " ";
			lastMove = currentMove;
		}
		
		return scramble;
	}

}
