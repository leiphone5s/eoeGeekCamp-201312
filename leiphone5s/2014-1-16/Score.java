package com.eoe.se1.day03;

public class Score {
public int java;
public int android;
public int sql;
public int oracle;
public Score(int java, int android, int sql, int oracle) {
	
super();
	this.java = java;
	this.android = android;
	this.sql = sql;
	this.oracle = oracle;
}
public Score() {
	
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Score [java=" + java + ", android=" + android + ", sql=" + sql
				+ ", oralce=" + oracle + "]";
	}
}