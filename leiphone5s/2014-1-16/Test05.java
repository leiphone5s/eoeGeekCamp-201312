package com.eoe.se1.day03;

public class Test05 {
	public static void main(String[] args) {
		Node2<String,Integer> link=new Node2<String,Integer>();
		Node2<String,Integer> first=link;
		link.value1="张飞";
		link.value2=12;
		link.next=new Node2<String,Integer>();
		link=link.next;
		link.value1="王菲";
		link.value2=22;
		link.next=new Node2<String, Integer>();
		link=link.next;
		link.value1="咖啡";
		link.value2=56;
		link=first;
		while(link!=null){
			System.out.println("姓名:"+link.value1+"\t年龄:"+link.value2);
			link=link.next;
		}
	}
}
