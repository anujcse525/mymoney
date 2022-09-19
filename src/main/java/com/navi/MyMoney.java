package com.navi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.navi.exception.InvalidOptionException;

public class MyMoney {

	public static void main(String[] args) {
		AssetsCalculator.initInstance();
		File file = new File("demo.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String input = null;
			while ((input = br.readLine()) != null) {
				MyMoneyHelper.inputHandler(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidOptionException e) {
			e.printStackTrace();
		}

	}

}
