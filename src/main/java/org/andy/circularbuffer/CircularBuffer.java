package org.andy.circularbuffer;

public class CircularBuffer {
	private String[] buf;

	public void sizeBuffer(int size) {
		this.buf = new String[size];
	}

	public void append(String string) {
		// TODO Auto-generated method stub
		
	}

	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}

	public String[] list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * testing helper
	 * @return
	 */
	String[] getBuffer() {
		return buf;
	}
}
