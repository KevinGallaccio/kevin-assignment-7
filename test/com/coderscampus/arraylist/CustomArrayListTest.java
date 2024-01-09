package com.coderscampus.arraylist;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void should_add_100001_items_to_the_list() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i <= 100001; i++) {
			sut.add(i);
		}
		for (int i = 0; i < 100000; i++) {
			assertEquals(i + 1, sut.get(i));
		}
		assertEquals(100001, sut.getSize());
	}

	@Test
	void should_throw_out_of_bound_exeption_when_adding_to_a_wrong_index() {
		CustomList<Integer> sut = new CustomArrayList<>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.add(30, 1);
		});
	}

	@Test
	void should_add_1_item_at_the_specified_index() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i <= 100001; i++) {
			sut.add(i);
		}

		sut.add(50, 1);

		assertEquals(sut.get(50), 1);
		assertEquals(100002, sut.getSize());
	}

	@Test
	void should_remove_1_item_at_the_specified_index_and_return_the_removed_item() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i <= 100001; i++) {
			sut.add(i);
		}
		assertEquals(sut.remove(50), 51);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.remove(100005);
		});
	}

	@Test
	void should_trim_the_backing_array_when_removing_multiple_items() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i <= 100001; i++) {
			sut.add(i);
		}

		for (int i = 0; i <= 75000; i++) {
			sut.remove(0);
		}

		assertEquals(25000, sut.getSize());
		assertEquals(null, sut.get(35000));

	}

}
