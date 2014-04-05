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
		String input =  "10\n" +
						"A 3\n" +
						"Fee\n" +
						"Fi\n" +
						"Fo\n" +
						"A 1\n" +
						"Fum\n" +
						"R 2\n" +
						"L\n" +
						"Q\n";
		app.process(input);
		verify(buf).sizeBuffer(10);
		verify(buf).append("Fee, Fi, Fo");
		verify(buf).append("Fum");
		verify(buf).remove(2);
		verify(buf).list();
		//does not validate the quit
	}
	
}
