package org.andy.circularbuffer;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CircularBufferAppTest {
	CircularBufferApp app = null;
	CircularBuffer buf = null;
	
	@Before
	public void setUp() throws Exception {
		buf = mock(CircularBuffer.class);
		this.app = new CircularBufferApp(buf);
	}

	@Test
	public void checkSanity() {
		assertThat(app, is(notNullValue()));
	}

	@Test
	public void acceptance_test() {
		app.process("10");
		app.process("A 3");
		app.process("Fee");
		app.process("Fi");
		app.process("Fo");
		app.process("A 1");
		app.process("Fum");
		app.process("R 2");
		app.process("L");
		app.process("Q");
		
		verify(buf).sizeBuffer(10);
		verify(buf).append("Fee");
		verify(buf).append("Fi");
		verify(buf).append("Fo");
		verify(buf).append("Fum");
		verify(buf).remove(2);
		verify(buf).list();
		//does not validate the quit
	}
	
	@Test
	public void print_handles_nulls() {
		String results = CircularBufferApp.print(null);
		assertThat(results, is(""));
	}
	
	@Test
	public void print_handles_array() {
		String results = CircularBufferApp.print(new String[] {"hi", "there"});
		assertThat(results, is("hi\nthere\n"));
	}
}
