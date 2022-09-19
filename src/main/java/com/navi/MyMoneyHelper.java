package com.navi;

import com.navi.exception.InvalidOptionException;
import com.navi.utility.Options;

/*
 * This class will be calling the AssetsCalculator methods on the basis of the user's input
 */
public class MyMoneyHelper {

	public static void inputHandler(String input) throws InvalidOptionException {

		String[] inputs = input.split("\\s+");
		if (inputs == null || inputs.length == 0) {
			return;
		}

		String command = inputs[0];
		switch (Options.valueOf(command)) {

		case ALLOCATE:
			AssetsCalculator.allocation(inputs);
			break;

		case SIP:
			AssetsCalculator.sip(inputs);
			break;

		case BALANCE:
			AssetsCalculator.balance(inputs);
			break;

		case REBALANCE:
			AssetsCalculator.rebalance();
			break;

		case CHANGE:
			AssetsCalculator.change(inputs);
			break;

		default:
			throw new InvalidOptionException("Wrong option");

		}
	}

}
