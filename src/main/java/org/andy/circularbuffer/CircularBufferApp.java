package org.andy.circularbuffer;

import java.util.StringTokenizer;

public class CircularBufferApp {
	private CircularBuffer buf = null;

	public static void main(String[] args) {
		CircularBufferApp app = new CircularBufferApp(new CircularBuffer());
		app.process(args);
	}
	
	
	public CircularBufferApp(CircularBuffer buf) {
		this.buf = buf;
	}

	public String[] process(String[] input) {
		int inputIndex = 0;
		if (input.length > 0) {
			buf.sizeBuffer(Integer.parseInt(input[inputIndex]));
			inputIndex++;
		}
		
		while (inputIndex < input.length) {
			String cmd = input[inputIndex++];
			
			if (cmd.startsWith("A ")) {
				int numToAdd = Integer.parseInt(cmd.substring(2));
				for (int i = 0; i<numToAdd; i++) {
					if(inputIndex + numToAdd < input.length) {
						buf.append(input[inputIndex++]);
					}
				}
			}
			
			if (cmd.startsWith("R")) {
				int numToRemove = Integer.parseInt(cmd.substring(2));
				buf.remove(numToRemove);
			}
			
			if (cmd.startsWith("L")) {
				return buf.list();
			}
		}
		
		return null;
	}
}
