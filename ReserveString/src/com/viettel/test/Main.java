package com.viettel.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	private static String input = "";
	private static String outPutQ1 = "";
	private static String outPutQ2 = "";
	private static String outPutQ3 = "";

	public static void getIniVar() {
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "properties.ini"));
			input = p.getProperty("Input");
			outPutQ1 = p.getProperty("Output1");
			outPutQ2 = p.getProperty("Output2");
			outPutQ3 = p.getProperty("Output3");
		} catch (Exception e) {
			System.out.println("Error in reading ini file" + e);
		}
	}

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			// pass the path to the file as a parameter
			getIniVar();
			File file = new File(input);
			sc = new Scanner(file);
			// Question 1
			while (sc.hasNextLine()) {
				String input = sc.nextLine().toUpperCase().replaceAll("\\s+", "");
				questionOne(input);
				questionTwo(input);
				questionThree(input);
			}
			System.out.println("Done -------------------- ");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException : " + e.getMessage());
		} finally {
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception ex) {
				System.out.println("Scanner closed error : " + ex.getMessage());
			}
		}

	}

	public static void questionOne(String input) {
		// Check Reverse String
		if (reverse(input)) {
			writeToFile(input + ";TRUE", outPutQ1);
		} else {
			writeToFile(input + ";FALSE", outPutQ1);
		}
	}

	public static void questionTwo(String input) {
		// Get Sub Reverse String
		String str = checkSubReverse(input);
		if (str != null) {
			writeToFile(input + ";" + str + ";" + str.length(), outPutQ2);
		} else {
			writeToFile(input + ";NULL;0", outPutQ2);
		}
	}

	public static void questionThree(String input) {
		// Delete Sub Reverse String
		if (reverse(input)) {
			writeToFile(input + ";OK", outPutQ3);
		} else {
			String str = deleteSubReverse(input);
			if (str != null) {
				writeToFile(input + ";" + str + ";" + str.length(), outPutQ3);
			} else {
				writeToFile(input + ";NOK", outPutQ3);
			}
		}
	}

	private static boolean reverse(String input) {
		char[] in = input.toCharArray();
		for (int i = 0; i < in.length / 2; i++) {
			if (in[i] != in[in.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unused")
	private static String checkSubReverse(String input) {
		char[] in = input.toCharArray();
		//
		List<String> listSubString = new ArrayList<String>();
		for (int i = 0; i < in.length - 1; i++) {
			for (int j = i; j <= in.length - 2; j++) {
				// Check reverse String with double length .
				String sub = input.substring(i, j + 2);
				if (reverse(sub) && sub.length() > 1 && !(sub.length() == input.length())) {
					listSubString.add(sub);
				}
			}
		}
		if (listSubString != null && listSubString.size() > 0) {
			// Order Descending List by length.
			Collections.sort(listSubString, Comparator.comparing(String::length).reversed());
			// After sort list return the first record
			return listSubString.get(0);
		}
		return null;
	}

	@SuppressWarnings("unused")
	private static String deleteSubReverse(String input) {
		char[] in = input.toCharArray();
		List<String> listSubString = new ArrayList<String>();
		String str = null;
		for (int i = 0; i < in.length - 1; i++) {
			for (int j = i + 1; j <= in.length - 1; j++) {
				// Check reverse String with double length .
				String sub = input.substring(i, j);
				String deleteSubStr = input.replace(sub, "");
				if (deleteSubStr.length() > 1 && !(sub.length() == input.length())) {
					str = checkSubReverse(deleteSubStr);
					if (str != null) {
						listSubString.add(str);
					}
				}
			}
		}
		if (listSubString != null && listSubString.size() > 0) {
			// Order Descending List by length.
			Collections.sort(listSubString, Comparator.comparing(String::length).reversed());
			// After sort list return the first record
			return listSubString.get(0);
		}
		return null;
	}

	private static void writeToFile(String output, String outputFile) {
		FileWriter fr = null;
		BufferedWriter br = null;

		try {
			File file = new File(outputFile);
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			br.write(output + "\n");
		} catch (IOException ex) {
			System.out.println("Error : " + ex.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (Exception ex) {
				System.out.println("Error closed writer : " + ex.getMessage());
			}
		}
	}

}
