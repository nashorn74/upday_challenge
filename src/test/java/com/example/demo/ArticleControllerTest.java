package com.example.demo;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.ArticleController;
import com.example.demo.entity.Article;
import com.example.demo.entity.News;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ArticleController articleController;
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Test
	public void testAddArticle() throws Exception {
		Date date = new Date();
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				date, null, null);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("header", new String("test1"));
		params.put("shortDescription", new String("test1 short"));
		params.put("text", new String("test1 text"));
		params.put("authors", null);
		params.put("keywords", null);

		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(params);
	    
	    System.out.println(requestJson);
	    
	    given(articleController.addArticle(params)).willReturn(article);
		
		mockMvc.perform(post("/article")
                .contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.header", is(article.getHeader())));
	}
    
    @Test
    public void testGetArticles() throws Exception {
    	List<Article> articles = new Vector<Article>();
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
    	articles.add(article);
    	
    	given(articleController.getArticles()).willReturn(articles);
    	
    	mockMvc.perform(get("/article/list")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(article.getId())));
    }
    
    @Test
    public void testGetArticle() throws Exception {
		Article article = new Article(1, "test1", "test1 short", "test1 text",
				new Date(), null, null);
    	
    	given(articleController.getArticle(1)).willReturn(article);
    	
    	mockMvc.perform(get("/article/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is(article.getText())));
    }
    
    @Test
	public void testUpdateArticle() throws Exception {
		Article article = new Article(1, "test2", "test2 short", "test2 text",
				new Date(), null, null);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("header", new String("test2"));
		params.put("shortDescription", new String("test2 short"));
		params.put("text", new String("test2 text"));
		params.put("authors", null);
		params.put("keywords", null);

		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(params);
	    
	    System.out.println(requestJson);
	    
	    given(articleController.updateArticle(1, params)).willReturn(article);
		
		mockMvc.perform(put("/article/1")
                .contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shortDescription", is(article.getShortDescription())));
	}
    
    @Test
    public void testRemoveArticle() throws Exception {
    	given(articleController.removeArticle(1)).willReturn(true);
    	
    	mockMvc.perform(delete("/article/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }
}
