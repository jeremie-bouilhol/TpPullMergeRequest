package datastruct;

import static org.junit.Assert.*;

import org.junit.Test;

public class TEST {

	@Test
	public void test_crea() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertEquals(0,list.size());
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void test_crea_non_vide() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		assertFalse(list.isEmpty());
		assertEquals(5, list.size());
	}
	
	@Test
	public void test_pop() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list2_5 = MyUnsortedList.of(2,3,4,5);
		UnsortedList<Integer> list2_4 = MyUnsortedList.of(2,3,4);
		Integer temp = list.pop();
		assertEquals(list2_5,list);
		assertEquals(1,temp.intValue());
		temp = list.popLast();
		assertEquals(list2_4,list);
		assertEquals(5,temp.intValue());
	}
	
	@Test
	public void test_prepend() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list0_5 = MyUnsortedList.of(0,1,2,3,4,5);
		list.prepend(0);
		assertEquals(list0_5,list);
	}
	
	@Test
	public void test_append() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list1_6 = MyUnsortedList.of(1,2,3,4,5,6);
		list.append(6);
		assertEquals(list1_6,list);
	}
	
	@Test
	public void test_insert() {
		UnsortedList<Integer> list = MyUnsortedList.of(0,1,2,3,4,5);
		UnsortedList<Integer> list0_5 = MyUnsortedList.of(0,1,2,-2,3,4,5);
		list.insert(-2,3);
		assertEquals(list0_5,list);
		
		UnsortedList<Integer> list_1_5 = MyUnsortedList.of(-1,0,1,2,-2,3,4,5);
		list.insert(-1,0);
		assertEquals(list_1_5,list);
		
		UnsortedList<Integer> list_1_6 = MyUnsortedList.of(-1,0,1,2,-2,3,4,5,6);
		list.insert(6,list.size());
		assertEquals(list_1_6,list);
	}
	
	@Test
	public void test_remove() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list_3 = MyUnsortedList.of(1,2,4,5);
		Integer temp = list.remove(2);
		assertEquals(list_3,list);
		assertEquals(3,temp.intValue());
		temp = list.remove(0);
		assertEquals(1,temp.intValue());
		UnsortedList<Integer> list_13 = MyUnsortedList.of(2,4,5);
		assertEquals(list_13,list);
	}
	
	@Test
	public void test_toString() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		assertEquals("MyUnsortedList { size = 5, [1, 2, 3, 4, 5] }", list.toString());
	}
	
	@Test
	public void test_Equals() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4,5);
		UnsortedList<Integer> list3 = MyUnsortedList.of(1,2,3,4,5,6);
		UnsortedList<Integer> list4 = MyUnsortedList.of(1,2,10,4,5);
		UnsortedList<Integer> list5 = MyUnsortedList.of(1,null,10,4,5);
		assertTrue(list.equals(list2));
		assertFalse(list.equals(list3));
		assertFalse(list.equals(5));
		assertFalse(list.equals(list4));
		assertFalse(list.equals(list5));
	}
	
	
	@Test(expected = EmptyListException.class)
	public void test_pop_vide() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.pop();
	}
	
	@Test(expected = EmptyListException.class)
	public void test_poplast_vide() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.popLast();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_remove_vide() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.remove(1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_remove_over_border() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_insert_out1() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(1, -1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_insert_out2() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(1, 8);
	}
}

