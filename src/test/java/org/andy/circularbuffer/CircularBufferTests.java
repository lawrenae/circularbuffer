package org.andy.circularbuffer;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class CircularBufferTests {
	private CircularBuffer b = null;
	
	@Before
	public void setUp() throws Exception {
		b = new CircularBuffer();
	}

	@Test
	public void sanity() {
		assertThat(b, is(notNullValue()));
	}
	
	@Test
	public void can_size_buffer() {
		b.sizeBuffer(10);
		String[] results = b.getBuffer();
		assertThat(results.length, is(10));
	}
}
