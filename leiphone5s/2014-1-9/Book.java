package com.fengleiit.wow;

import com.fengleiit.swf.Person02;

/*id：代表书的编号；
name：代表书名；
author:代表作者，该属性的类型是Person；
isbn:代表书号；
price:代表书价。*/
public class Book {
	public static String strPerson = "李刚:男:33:1.67:快乐的";
	public static String strBook = "1:《疯狂Java》:ISBN18005:85";
	static String id=strBook.substring(0, strBook.indexOf(":"));
	String bookName= strBook.substring(2, strBook.indexOf("》") + 1);
	String isbn = strBook.substring(11, strBook.indexOf("0") + 3);
	static int id1=Integer.parseInt(id);
	static String price = strBook.substring(strBook.lastIndexOf(":") + 1);
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "书的编号:"+id+"\n书名:"+bookName+"\n书号:"+isbn+"\n书价:"+price;
}
/*public Book(String id){
	this();
	this.id=id;
}
public Book(String id,String bookName){
	this(id);
	this.bookName=bookName;
}
public Book(String id,String bookName,String isbn){
	this(id, bookName);
	this.isbn=isbn;
}
public Book(String id,String bookName,String isbn,String price){
	this(id, bookName, isbn);
	this.price=price;
}*/
public boolean equals(Object obj){
	if(obj==null){
		return false;
	}
	Book other=null;
	if(obj instanceof Book){
		other=(Book) obj;
	}else{
		return false;
	}
	if(obj==this){
		return true;
	}
	return this.isbn.equals(other.isbn);
}
public static void main(String[] args) {
   id1=5;
	Book b=new Book();
	System.out.println(b);
	double price1=Double.parseDouble(price);
	System.out.println(price);
	price1=1.8;
	System.out.println(price1);
}
}
