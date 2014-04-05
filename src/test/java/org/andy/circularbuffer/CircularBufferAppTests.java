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
}
