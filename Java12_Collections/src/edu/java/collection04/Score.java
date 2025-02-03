package edu.java.collection04;

public class Score {
	private int math;
	private int eng;
	
	public Score() {}

	
	public Score(int math, int eng) {
		this.math = math;
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}


	@Override
	public String toString() {
		return "수학 : " + math + "\n영어 : " + eng;
	}
	
	
	
}
