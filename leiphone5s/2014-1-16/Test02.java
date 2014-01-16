package com.eoe.se1.day03;

public class Test02 {
	public static void main(String[] args) {
		NodeString link = new NodeString();
		NodeString root = link;
		link.value = "aa";
		link.next = new NodeString();
		link = link.next;
		link.value = "bb";
		link.next = new NodeString();
		link = link.next;
		link.value = "cc";
		link = root;
		while (link != null) {
			System.out.println(link.value);
			link = link.next;
		}
	}
}
