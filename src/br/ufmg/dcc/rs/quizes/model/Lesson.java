package br.ufmg.dcc.rs.quizes.model;



public class Lesson {
	
	private String type;
	private String text;
	
	public Lesson(String type, String text) {
		this.type = type;
		this.text = text;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		((Lesson) this).type = type;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		((Lesson) this).text = text;
	}
}