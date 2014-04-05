package org.andy.circularbuffer;

import java.util.StringTokenizer;

public class CircularBufferApp {
	private CircularBuffer buf = null;
	
	public CircularBufferApp(CircularBuffer buf) {
		this.buf = buf;
	}

	public String[] process(String input) {
		StringTokenizer t = new StringTokenizer(input, "\n");
		if (t.hasMoreTokens()) {
			buf.sizeBuffer(Integer.parseInt(t.nextToken()));
		}
		
		while (t.hasMoreTokens()) {
			String cmd = t.nextToken();
			if (cmd.startsWith("A ")) {
				int numToAdd = Integer.parseInt(cmd.substring(2));
				for (int i = 0; i<numToAdd; i++) {
					if(t.hasMoreTokens()) {buf.append(t.nextToken());}
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
