package model;

/*
 * Created by hotjin on 2020-04-25
*/
public class DotVO {
	private int id;
	private String word;
	private String dot;
	private int type;
	private String raw_id;
	
	
	public String getRaw_id() {
		return raw_id;
	}
	public void setRaw_id(String raw_id) {
		this.raw_id = raw_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getDot() {
		return dot;
	}
	public void setDot(String dot) {
		this.dot = dot;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
