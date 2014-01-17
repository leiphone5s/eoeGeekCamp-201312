package com.eoe.se1.day04;

import java.util.ArrayList;

import com.fengleiit.swf.Person02;
import com.fengleiit.wow.Student;

public class Test03 {
public static void main(String[] args) {
	ArrayList<Integer> src=new ArrayList<Integer>();
	src.add(100);
	src.add(150);
	src.add(180);
	
	ArrayList<Number> dest=new ArrayList<Number>();
	copy(src,dest);
	
	ArrayList<Student> students=new ArrayList<Student>();
	ArrayList<Person02> people=new ArrayList<Person02>();
	students.add(new Student("a", 'n', 1.8, 22, "豪放的", "eoeSchool", "1205班"));
	students.add(new Student("b", 'v', 1.7, 22, "温柔的", "eoeSchool", "1205班"));
	students.add(new Student("c", 'n', 1.75, 22, "豪放的", "eoeSchool", "1205班"));
	System.out.println();
	copy(students,people);
}

public static <T> void copy(
		ArrayList<? extends T> src, ArrayList<T> dest) {
for(int i=0;i<src.size();i++){
	dest.add(src.get(i));
}
for(T t:dest){
	System.out.println(t);
}
}
}
