package com.eoe.se1.day03;

public class Test03 {
public static void main(String[] args) {
	NodeChar link=new NodeChar();
	NodeChar root=link;
	link.value='a';
	link.next=new NodeChar();
	link=link.next;
	link.value='b';
	link.next=new NodeChar();
	link=link.next;
	link.value='c';
	link=root;
	while(link!=null){
		System.out.println(link.value);
		link=link.next;
	}
}
}
