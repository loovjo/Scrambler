package com.loovjo.scrambling;

import java.util.HashMap;
import java.util.Map.Entry;

import com.loovjo.scrambling.scrambler.CubeScrambler;
import com.loovjo.scrambling.scrambler.CubeScrambler1x1;
import com.loovjo.scrambling.scrambler.CubeScrambler2x2;
import com.loovjo.scrambling.scrambler.CubeScrambler3x3;
import com.loovjo.scrambling.scrambler.CubeScrambler4x4;
import com.loovjo.scrambling.scrambler.CubeScrambler5x5;
import com.loovjo.scrambling.scrambler.CubeScramblerPyra;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Object> defaults = new HashMap<String, Object>();

		defaults.put("puzzle", "3x3");

		HashMap<String, Object> props = ArgParser.readValues(args);

		loadDefaults(props, defaults);

		try {

			Class<? extends CubeScrambler> scrambler = null;

			switch ((String) props.get("puzzle")) { // Set maxScrambleLength to
													// gods number on the puzzle
			case "3x3":
				scrambler = CubeScrambler3x3.class;
				break;
			case "2x2":
				scrambler = CubeScrambler2x2.class;
				break;
			case "4x4":
				scrambler = CubeScrambler4x4.class;
				break;
			case "5x5":
				scrambler = CubeScrambler5x5.class;
				break;
			case "6x6":
				// scrambler = CubeScrambler6x6.class;
				break;
			case "7x7":
				// scrambler = CubeScrambler7x7.class;
				break;
			case "1x1":
				scrambler = CubeScrambler1x1.class;
				break;
			case "pyra":
			case "pyraminx":
				scrambler = CubeScramblerPyra.class;
				break;
			}
			CubeScrambler instance = scrambler.newInstance();
			
			System.out.println(instance.getScramble(
					props.containsKey("length") ? (int) props.get("length") : instance.getDefaultMaxLength()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void loadDefaults(HashMap<String, Object> props, HashMap<String, Object> defaults) {
		for (Entry<String, Object> def : defaults.entrySet()) {
			if (!props.containsKey(def.getKey()))
				props.put(def.getKey(), def.getValue());
		}

	}

}
