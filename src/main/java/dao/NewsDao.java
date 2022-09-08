package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import model.News;

@Component
public interface NewsDao {
	public boolean saveNews(News news);
	  
	  public List<News> getAllNews();
	  
	  public boolean deleteNews(int newsId);

}
