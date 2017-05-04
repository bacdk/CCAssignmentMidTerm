package bootsample.model;

import java.io.Serializable;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name= "tintuc")
public class Tintuc implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private String content;
	private String link;
	
	//
	public Tintuc(){}
	//
	public Tintuc(String title, String content, String link) {
		super();
		this.title = title;
		this.content = content;
		this.link = link;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	//
	@Override
	public String toString() {
		return "Tintuc [id=" + id + ", title=" + title + ", content=" + content + ", link="+ link +"]";
	}
	
	
}
