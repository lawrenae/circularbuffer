package org.andy.circularbuffer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CircularBufferAppTests {
	CircularBufferApp app = null;
	CircularBuffer buf = null;
	
	@Before
	public void setUp() throws Exception {
		buf = mock(CircularBuffer.class);
		this.app = new CircularBufferApp(buf);
	}

	@Test
	public void checkSanity() {
		assertNotNull(app);
	}

	@Test
	public void acceptance_test() {
		String[] input = new String[] { 
						"10",
						"A 3",
						"Fee",
						"Fi",
						"Fo",
						"A 1",
						"Fum",
						"R 2",
						"L",
						"Q" };
		app.process(input);
		verify(buf).sizeBuffer(10);
		verify(buf).append("Fee");
		verify(buf).append("Fi");
		verify(buf).append("Fo");
		verify(buf).append("Fum");
		verify(buf).remove(2);
		verify(buf).list();
		//does not validate the quit
	}
	
}
