package exe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import exe.VulnerableClass;

public class VulnerableTest {
	
	@Test
	public void testRead() throws IOException {
		final String file = "teste.txt";
		VulnerableClass v = new VulnerableClass();
		
		String input = "R";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    v.vulnerableMethod(file);
	}
	
	@Test
	public void testWrite() throws IOException {
		final String file = "teste4.txt";
		VulnerableClass v = new VulnerableClass();
		
		String input = "W" + System.getProperty("line.separator") + "MUHAHA2222";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    v.vulnerableMethod(file);
	}
	
	@Test(expected=java.io.IOException.class)
	public void testReadInFileNotExisted() throws IOException {
		final String file = "teste6.txt";
		VulnerableClass v = new VulnerableClass();
		String input = "R";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    v.vulnerableMethod(file);
	}
	
	@Test(expected=Exception.class)
	public void testWriteNothingExpectedExeception() throws IOException {
		final String file = "teste3.txt";
		VulnerableClass v = new VulnerableClass();
		
		String input = "W";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    v.vulnerableMethod(file);
	}
	
	@Test
	public void testPassarComandoInvalidoEDepoisComandoValido() throws IOException {
		final String file = "teste4.txt";
		VulnerableClass v = new VulnerableClass();
		
		String input = "inv" + System.getProperty("line.separator") + "R";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    v.vulnerableMethod(file);
	}
	
	@Test
	public void testPassarVariosComandosInvalidos() throws IOException {
		final String file = "teste4.txt";
		VulnerableClass v = new VulnerableClass();
		
		String input = "inv" + System.getProperty("line.separator") + "inv2" + System.getProperty("line.separator") + "inv3";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    v.vulnerableMethod(file);
	}

}