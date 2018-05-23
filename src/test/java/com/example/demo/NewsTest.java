package com.example.demo;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

import com.example.demo.entity.Article;
import com.example.demo.entity.News;

public class NewsTest {
	@Test
	public void testAddArticle() {
		News.removeAllArticle();
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		News.addArticle(article);
		assertEquals(News.getArticleCount(), 1, 0);
	}
	
	@Test
	public void testGetArticle() {
		News.removeAllArticle();
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		News.addArticle(article);
		assertEquals(News.getArticle(1).getId(), 1, 0);
	}
	
	@Test
	public void testGetArticles() {
		News.removeAllArticle();
		Article article1 = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		News.addArticle(article1);
		Article article2 = new Article(2, "test2", "test2 short", "test2 text",
				new Date(), null, null);
		News.addArticle(article2);
		assertEquals(News.getArticles().size(), 2, 0);
	}
	
	@Test
	public void testUpdateArticle() {
		News.removeAllArticle();
		Article article1 = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		News.addArticle(article1);
		Article article2 = new Article(1, "test1 update", "test1 update short", "test1 update text",
				new Date(), null, null);
		News.updateArticle(1, article2);
		assertEquals(News.getArticle(1).getHeader(), "test1 update");
	}
	
	@Test
	public void testRemoveArticle() {
		News.removeAllArticle();
		Article article1 = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
		News.addArticle(article1);
		Article article2 = new Article(2, "test2", "test2 short", "test2 text",
				new Date(), null, null);
		News.addArticle(article2);
		News.removeArticle(1);
		assertEquals(News.getArticles().size(), 1, 0);
		assertEquals(News.getArticle(2).getHeader(), "test2");
	}
}
