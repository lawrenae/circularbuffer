package org.andy.circularbuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class CircularBuffer {
	private String[] buf = null;
	private int addIndex = 0;
	private int removeIndex = 0;
	private int bufferSize = 0;

	/*
	 * Does not handle /re/sizing a buffer after entries exist
	 */
	public void sizeBuffer(int size) {
		this.buf = new String[size];
		this.bufferSize = size;
	}

	public void append(String string) {
		if (addIndex >= bufferSize) {
			addIndex = 0;
		}
		this.buf[addIndex++] = string;			
	}

	public void remove(int count) {
		int stopAt = removeIndex + count;
		for (int i=removeIndex; i<stopAt; i++) {
			this.buf[i] = null;
			removeIndex++;
		}
	}

	public String[] list() {
		String[] temp = ArrayUtils.addAll(
				Arrays.copyOfRange(this.buf, addIndex, buf.length), 
				Arrays.copyOfRange(this.buf, removeIndex, addIndex));
				
		List<String> results = new ArrayList<String>(Arrays.asList(temp));
		results.removeAll(Arrays.asList("", null));
		
		return results.toArray(new String[1]);
	}
	
	/**
	 * testing helper
	 * @return
	 */
	String[] getBuffer() {
		return buf;
	}
}
