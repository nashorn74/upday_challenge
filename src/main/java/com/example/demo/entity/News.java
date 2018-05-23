package com.example.demo.entity;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class News {
	private static List<Article> articles = new Vector<Article>();
	
	public static int getArticleCount() { return articles.size(); }
	public static Article getArticle(int id) {
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = (Article)iterator.next();
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}
	public static Article getArticleByIndex(int index) { 
		if (index < articles.size()) {
			return articles.get(index); 
		} else {
			return null;
		}
	}
	public static List<Article> getArticles() { return articles; }
	public static void addArticle(Article article) { articles.add(article); }
	public static Article updateArticle(int id, Article newArticle) {
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = (Article)iterator.next();
			if (article.getId() == id) {
				if (newArticle.getHeader() != null) {
					article.setHeader(newArticle.getHeader());
				}
				if (newArticle.getShortDescription() != null) {
					article.setShortDescription(newArticle.getShortDescription());
				}
				if (newArticle.getText() != null) {
					article.setText(newArticle.getText());
				}
				if (newArticle.getAuthors() != null) {
					article.setAuthors(newArticle.getAuthors());
				}
				if (newArticle.getKeywords() != null) {
					article.setKeywords(newArticle.getKeywords());
				}
				return article;
			}
		}
		return null;
	}
	public static void updateArticleByIndex(int index, Article article) { 
		articles.set(index, article); 
	}
	public static boolean removeArticle(int id) {
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = (Article)iterator.next();
			if (article.getId() == id) {
				return articles.remove(article);
			}
		}
		return false;
	}
	public static void removeArticleByIndex(int index) { articles.remove(index); }
	public static void removeAllArticle() { articles.clear(); }
	
	public static List<Article> findArticlesByAuthor(String author) {
		List<Article> resultArticles = new Vector<Article>();
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = (Article)iterator.next();
			List<String> authors = article.getAuthors();
			Iterator<String> authorIterator = authors.iterator();
			while(authorIterator.hasNext()) {
				if (authorIterator.next().equals(author)) {
					resultArticles.add(article);
					break;
				}
			}
		}
		return resultArticles;
	}
	
	public static List<Article> findArticlesByPeriod(Date startDate, Date endDate) {
		List<Article> resultArticles = new Vector<Article>();
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = (Article)iterator.next();
			if (startDate.getTime() <= article.getPublishDate().getTime() &&
				endDate.getTime() >= article.getPublishDate().getTime()) {
				resultArticles.add(article);
			}
		}
		return resultArticles;
	}
	
	public static List<Article> findArticlesByKeyword(String keyword) {
		List<Article> resultArticles = new Vector<Article>();
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = (Article)iterator.next();
			List<String> keywords = article.getKeywords();
			Iterator<String> keywordIterator = keywords.iterator();
			while(keywordIterator.hasNext()) {
				if (keywordIterator.next().equals(keyword)) {
					resultArticles.add(article);
					break;
				}
			}
		}
		return resultArticles;
	}
}
