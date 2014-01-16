package com.eoe.se1.day03;

public class Node_<T> implements Collection_<Node_<T>> {
	public T value;
	private Node_<T> next;

	@Override
	public void add(Node_<T> value) {
		this.next = value;
	}

	@Override
	public Node_<T> next() {
		return this.next;
	}

}
