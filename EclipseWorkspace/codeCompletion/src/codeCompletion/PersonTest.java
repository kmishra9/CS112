package codeCompletion;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() throws Exception {
		Person p = new Person();
		Date d = new Date();
		p.setDob(d);
		p.evaluateAge();
		
	}

}
