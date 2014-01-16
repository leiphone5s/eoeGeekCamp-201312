package com.eoe.se1.day03;

import java.util.Arrays;

public class ArrayList2_<T> implements Collection_<T> {
	T[] values;
	int index;

	public ArrayList2_() {
		values = (T[]) new Object[0];
		index = 0;
	}

	@Override
	public void add(T value) {
		values = Arrays.copyOf(values, values.length + 1);
		values[values.length - 1] = value;
	}

	@Override
	public T next() {
		if (index < values.length) {
			return values[index++];
		}
		return null;
	}

	public int size() {
		return values.length;
	}
}
