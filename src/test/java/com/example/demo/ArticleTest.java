package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.demo.entity.Article;

public class ArticleTest {
	@Test
	public void testCreateInstance() {
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		assertEquals(article.getId(), 1, 0);
		assertEquals(article.getHeader(), "test1");
	}
	
	@Test
	public void testGetId() {
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		article.setId(99);
		assertEquals(article.getId(), 99, 0);
	}
	
	@Test
	public void testGetHeader() {
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		article.setHeader("test2");
		assertEquals(article.getHeader(), "test2");
	}
	
	@Test
	public void testGetShortDescription() {
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		article.setShortDescription("test3 short");
		assertEquals(article.getShortDescription(), "test3 short");
	}
	
	@Test
	public void testGetText() {
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		article.setText("test4 text");
		assertEquals(article.getText(), "test4 text");
	}
	
	@Test
	public void testGetPublishDate() {
		Date date = new Date();
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				date, null, null);
		assertEquals(article.getPublishDate(), date);
	}
	
	@Test
	public void testGetAuthors() {
		List<String> authors = new Vector<String>();
		authors.add("kim");
		authors.add("park");
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), authors, null);
		assertEquals(article.getAuthors().size(), 2, 0);
	}
	
	@Test
	public void testGetKeywords() {
		List<String> keywords = new Vector<String>();
		keywords.add("test");
		keywords.add("keyword");
		keywords.add("unit");
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, keywords);
		assertEquals(article.getKeywords().size(), 3, 0);
	}
}
