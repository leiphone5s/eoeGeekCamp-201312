package com.eoe.weekend;

public class Score {
	int java;
	int android;
	int oracle;
	int sql;

	public Score() {

	}

	public Score(int java, int android, int oracle, int sql) {
		super();
		this.java = java;
		this.android = android;
		this.oracle = oracle;
		this.sql = sql;
	}

	public String toString() {
		return "Score [java=" + java + ",android=" + android + ",oracle="
				+ oracle + ",sql=" + sql + "]";
	}
}
