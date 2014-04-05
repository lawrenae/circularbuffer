package org.andy.circularbuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularBuffer {
	private String[] buf = null;
	private int bufferIndex = 0;
	private int bufferSize = 0;

	public void sizeBuffer(int size) {
		this.buf = new String[size];
		this.bufferSize = size;
	}

	public void append(String string) {
		if (bufferIndex == bufferSize) {
			bufferIndex = 0;
		}
		this.buf[bufferIndex ++] = string;			
	}

	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}

	public String[] list() {
		List<String> items = new ArrayList<String>(Arrays.asList(this.buf));
		items.removeAll(Arrays.asList("", null));
		
		return items.toArray(new String[1]);
	}
	
	/**
	 * testing helper
	 * @return
	 */
	String[] getBuffer() {
		return buf;
	}
}
