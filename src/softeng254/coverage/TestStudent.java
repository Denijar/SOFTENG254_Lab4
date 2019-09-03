package softeng254.coverage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestStudent {
	
	@Test
	public void testToString() {
		Student student3Names = new Student("John", "Doe", "Smith");
		assertEquals("John Doe Smith", student3Names.toString());
	}
	
	@Test
	public void testEmptyExceptLast() {
		Student student3Names = new Student("", "", "Smith");
		assertEquals("Smith", student3Names.toString());
	}
	
	@Test
	public void testEqualsWhenEqual() {
		Student student1 = new Student("John", "Doe", "Smith");
		Student student2 = new Student("John", "Doe", "Smith");
		assertEquals(student1, student2);
	}
	
	@Test
	public void testEqualsWhenNull() {
		Student student1 = new Student("John", "Doe", "Smith");
		assertNotEquals(student1, null);
	}
	
	@Test
	public void testEqualsWhenFirstNotEqual() {
		Student student1 = new Student("Mary", "Doe", "Smith");
		Student student2 = new Student("John", "Doe", "Smith");
		assertNotEquals(student1, student2);
	}
	
	@Test
	public void testEqualsWhenMiddleSizeNotEqual() {
		List<String> middleList = new ArrayList<>();
		middleList.add("Sally");
		middleList.add("Suzy");
		Student student1 = new Student("John", middleList, "Smith");
		Student student2 = new Student("John", "Doe", "Smith");
		assertNotEquals(student1, student2);
	}
	
	@Test
	public void testEqualsWhenPreferredNotEqual() {
		Student student1 = new Student("John", "Doe", "Smith");
		student1.setPreferredName(null);
		Student student2 = new Student("John", "Doe", "Smith");
		student2.setPreferredName("Joe");
		assertNotEquals(student1, student2);
	}
	
	@Test
	public void testEqualsWhenPreferredEqualsAndLastNotEqual() {
		Student student1 = new Student("John", "Doe", "James");
		student1.setPreferredName("John Smith");
		Student student2 = new Student("John", "Doe", "Smith");
		student2.setPreferredName("John Smith");
		assertNotEquals(student1, student2);
	}
	
	@Test
	public void testEqualsWhenMiddleNamesNotEqual() {
		List<String> middleList1 = new ArrayList<>();
		middleList1.add("Sally");
		middleList1.add("Suzy");
		Student student1 = new Student("John", middleList1, "Smith");
		List<String> middleList2 = new ArrayList<>();
		middleList2.add("Daisy");
		middleList2.add("Doe");
		Student student2 = new Student("John", middleList2, "Smith");
		assertNotEquals(student1, student2);
	}
	
	@Test
	public void testNullListConstruction() {
		try {
			new Student(null, (List<String>)null, null);
			fail("RuntimeException should have been thrown");
		}
		catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Missing last name");
		}
	}
	
	@Test
	public void testNullStringConstruction() {
		try {
			new Student(null, (String)null, null);
			fail("RuntimeException should have been thrown");
		}
		catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Missing last name");
		}
	}
	
	@Test
	public void testEmptyLastNameConstruction() {
		try {
			new Student(null, (List<String>)null, "");
			fail("RuntimeException should have been thrown");
		}
		catch(RuntimeException e) {
			assertEquals(e.getMessage(), "Missing last name");
		}
	}
	
	@Test
	public void testPreferredName() {
		Student student = new Student("John", "Doe", "Smith");
		student.setPreferredName("Joey");
		assertEquals("Joey", student.preferredName());
	}
	
	@Test
	public void testEmptyPreferredNameEmptyFirstMiddle() {
		Student student = new Student("", "", "Smith");
		student.setPreferredName("");
		assertEquals("Smith", student.preferredName());
	}
	
	@Test
	public void testEmptyPreferredName() {
		Student student = new Student("John", "", "Smith");
		student.setPreferredName("");
		assertEquals("John Smith", student.preferredName());
	}
	
	@Test
	public void testNormalupi() {
		Student student = new Student("John", "", "Smith");
		assertEquals("jsmi", student.upi());
	}
	
	@Test
	public void testEmptyFirstupi() {
		Student student = new Student("", "", "Smith");
		assertEquals("smi", student.upi());
	}
	
	@Test
	public void testShortLastupi() {
		Student student = new Student("John", "", "do");
		assertEquals("jdo", student.upi());
	}
	
	@Test
	public void testNormalLastNameFirst() {
		List<String> middleList = new ArrayList<>();
		middleList.add("Daisy");
		middleList.add("Doe");
		Student student = new Student("John", middleList, "Smith");
		assertEquals("Smith, John Daisy Doe", student.lastNameFirst());
	}
	
	@Test
	public void testEmptyFirst() {
		Student student = new Student("", "", "Smith");
		assertEquals("Smith", student.lastNameFirst());
	}
	
	@Test
	public void testNormalInitialsName() {
		List<String> middleList = new ArrayList<>();
		middleList.add("Daisy");
		middleList.add("Doe");
		Student student = new Student("John", middleList, "Smith");
		assertEquals("J. D. D. Smith", student.initialsName());
	}
	
	@Test
	public void testEmptyFirstInitialsName() {
		Student student = new Student("", "'", "Smith");
		assertEquals("' Smith", student.initialsName());
	}
	
	@Test
	public void testShortFirstInitialsName() {
		Student student = new Student("J", "'", "Smith");
		assertEquals("J ' Smith", student.initialsName());
	}
	
}
