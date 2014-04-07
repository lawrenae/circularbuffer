package org.andy.circularbuffer;

import java.util.Scanner;

public class CircularBufferApp {
	private CircularBuffer buf = null;
	private boolean firstInput = true;
	private boolean appending = false;
	private int numToAppend = 0;
	private int numAppended = 0;

	public static void main(String[] args) {
		CircularBufferApp app = new CircularBufferApp(new CircularBuffer());
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
		    String input = scanner.nextLine();
		    while (! "Q".equalsIgnoreCase(input)) {
		    	System.out.print(print(app.process(input)));
		    	input = scanner.nextLine();
		    }
		} finally {
			scanner.close();
		}
	}
	
	
	static String print(String[] process) {
		StringBuilder result = new StringBuilder("");
		if (process != null) {
			for(String s: process) {
				result.append(s + "\n");
			}
		}
		
		return result.toString();
	}


	public CircularBufferApp(CircularBuffer buf) {
		this.buf = buf;
	}

	public String[] process(String input) {
		if(firstInput) {
			buf.sizeBuffer(Integer.parseInt(input));
			firstInput = false;
			return null;
		}
				
		if (input.startsWith("A ")) {
			appending = true;
			numToAppend = Integer.parseInt(input.substring(2));
			return null;
		}
		
		if (appending) {
			buf.append(input);
			numAppended++;
			if (numAppended == numToAppend) {
				appending = false;
				numAppended = 0;
			}
			
			return null;
		}
		
		if (input.startsWith("R ")) {
			int numToRemove = Integer.parseInt(input.substring(2));
			buf.remove(numToRemove);
			
			return null;
		}
		
		if (input.startsWith("L")) {
			return buf.list();
		}
		
		return null;
	}
}
