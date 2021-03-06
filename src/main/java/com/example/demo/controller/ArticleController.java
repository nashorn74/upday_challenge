package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.entity.News;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Article getArticle(@PathVariable(value = "id") int id) {
        return News.getArticle(id);
    }
	
	@RequestMapping(method = RequestMethod.GET, value="list")
    public List<Article> getArticles() {
		return News.getArticles();
    }
	
	@RequestMapping(method = RequestMethod.GET, value="author/{author}")
    public List<Article> getArticlesByAuthor(@PathVariable(value = "author") String author) {
		return News.findArticlesByAuthor(author);        
    }
	
	@RequestMapping(method = RequestMethod.GET, value="period")
    public List<Article> getArticlesByPeriod(@RequestParam(value = "startDate") String startDateString,
    		@RequestParam(value = "endDate") String endDateString) {
		if (startDateString != null && endDateString != null) {
			try {
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate = transFormat.parse(startDateString);
				Date endDate = transFormat.parse(endDateString);
				return News.findArticlesByPeriod(startDate,endDate);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return News.getArticles();
		} else {
			return News.getArticles();
		}
    }
	
	@RequestMapping(method = RequestMethod.GET, value="keyword/{keyword}")
    public List<Article> getArticlesByKeyword(@PathVariable(value = "keyword") String keyword) {
        return News.findArticlesByKeyword(keyword);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public Article addArticle(@RequestBody Map<String, Object> payload) {
		System.out.println(payload);
		List<String> authors = (List<String>)payload.get("authors");
		List<String> keywords = (List<String>)payload.get("keywords");
		Article article = new Article(News.getArticleCount()+1,
				(String)payload.get("header"), (String)payload.get("shortDescription"), 
				(String)payload.get("text"), new Date(), authors, keywords);
		News.addArticle(article);
		return article;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Article updateArticle(@PathVariable(value = "id") int id,
			@RequestBody Map<String, Object> payload) {
		System.out.println(payload);
		List<String> authors = (List<String>)payload.get("authors");
		List<String> keywords = (List<String>)payload.get("keywords");
		Article article = new Article(id,
				(String)payload.get("header"), (String)payload.get("shortDescription"), 
				(String)payload.get("text"), new Date(), authors, keywords);
		return News.updateArticle(id, article);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public boolean removeArticle(@PathVariable(value = "id") int id) {
		return News.removeArticle(id);
    }
}
