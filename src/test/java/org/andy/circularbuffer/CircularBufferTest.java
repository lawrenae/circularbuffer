package org.andy.circularbuffer;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class CircularBufferTest {
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
	public void can_remove_an_element() {
		b.append("bob");
		b.append("fred");
		b.append("tom");
		b.append("jerry");
		
		b.remove(1);
		String[] results = b.list();

		assertThat(results.length, is(3));
		assertThat(results[0], is("fred"));
		assertThat(results[1], is("tom"));
		assertThat(results[2], is("jerry"));
	}
	
	@Test
	public void can_remove_two_elements_separately() {
		b.append("bob");
		b.append("fred");
		b.append("tom");
		b.append("jerry");
		
		b.remove(1);
		String[] results = b.list();

		assertThat(results.length, is(3));
		assertThat(results[0], is("fred"));
		assertThat(results[1], is("tom"));
		assertThat(results[2], is("jerry"));
		
		b.remove(1);
		results = b.list();

		assertThat(results.length, is(2));
		assertThat(results[0], is("tom"));
		assertThat(results[1], is("jerry"));
	}
	
	
	//Whenever L command appears in the input, 
	//print the elements of buffer in order of their inserting time. 
	//Element that was added first should appear first.
	@Test
	public void can_print_oldest_first() {
		b.sizeBuffer(3);
		b.append("bob");
		b.append("fred");
		b.append("tom");
		b.append("jerry");
		
		String[] results = b.list();
		
		assertThat(results[0], is("fred"));
		assertThat(results[1], is("tom"));
		assertThat(results[2], is("jerry"));
	}
}
