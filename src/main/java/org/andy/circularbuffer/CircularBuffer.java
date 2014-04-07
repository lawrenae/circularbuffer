package org.andy.circularbuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularBuffer {
	private String[] buf = null;
	private int addIndex = 0;
	private int removeIndex = 0;
	private int bufferSize = 0;

	public void sizeBuffer(int size) {
		this.buf = new String[size];
		this.bufferSize = size;
	}

	public void append(String string) {
		if (addIndex >= bufferSize) {
			addIndex = 0;
		}
		this.buf[addIndex ++] = string;			
	}

	public void remove(int count) {
		int stopAt = removeIndex + count;
		for (int i=removeIndex; i<stopAt; i++) {
			this.buf[i] = null;
			removeIndex++;
		}
	}

	public String[] list() {
		List<String> items = new ArrayList<String>(
				Arrays.asList(Arrays.copyOfRange(this.buf, addIndex, buf.length)));
		items.addAll(
				Arrays.asList(Arrays.copyOfRange(this.buf, removeIndex, addIndex)));
		
		
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
