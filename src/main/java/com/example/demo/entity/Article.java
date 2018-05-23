package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Article {
	private int id;
	private String header;
	private String shortDescription;
	private String text;
	private Date publishDate;
	private List<String> authors = new Vector<String>();
	private List<String> keywords = new Vector<String>();
	
	protected Article() {}
	
	public Article(int id, String header, String shortDescription, String text,
			Date publishDate, List<String> authors, List<String> keywords) {
		this.id = id;
		this.header = header;
		this.shortDescription = shortDescription;
		this.text = text;
		this.publishDate = publishDate;
		if (authors != null) {
			this.authors = authors; 
		} 
		if (keywords != null) {
			this.keywords = keywords; 
		}
	}
	
	public int getId() { return this.id; }
	public String getHeader() { return this.header; }
	public String getShortDescription() { return this.shortDescription; }
	public String getText() { return this.text; }
	public Date getPublishDate() { return this.publishDate; }
	public List<String> getAuthors() { return this.authors; }
	public List<String> getKeywords() { return this.keywords; }
		
	public void setId(int id) { this.id = id; }
	public void setHeader(String header) { this.header = header; }
	public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
	public void setText(String text) { this.text = text; }
	public void setPublishDate(Date publishDate) { this.publishDate = publishDate; }
	public void setAuthors(List<String> authors) { 
		if (authors != null) {
			this.authors = authors; 
		} else {
			this.authors = new Vector<String>();
		}
	}
	public void setKeywords(List<String> keywords) { 
		if (keywords != null) {
			this.keywords = keywords; 
		} else {
			this.keywords = new Vector<String>();
		}
	}
}
