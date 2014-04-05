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
		b.sizeBuffer(10);
	}

	@Test
	public void sanity() {
		assertThat(b, is(notNullValue()));
	}
	
	@Test
	public void can_size_buffer() {
		String[] results = b.getBuffer();
		assertThat(results.length, is(10));
	}
	
	@Test
	public void can_add_a_single_element_and_list() {
		b.append("bob");
		String[] results = b.list();
		assertThat(results.length, is(1));
	}
	
	@Test
	public void can_add_two_elements_and_list() {
		b.append("bob");
		b.append("fred");
		String[] results = b.list();
		assertThat(results.length, is(2));		
	}

	@Test
	public void can_add_more_elements_than_buffer_size() {
		b.sizeBuffer(3);
		b.append("bob");
		b.append("fred");
		b.append("tom");
		b.append("jerry");
		String[] results = b.list();

		assertThat(results.length, is(3));
		assertThat(results[0], is("jerry"));
		assertThat(results[1], is("fred"));
		assertThat(results[2], is("tom"));
	}
}
