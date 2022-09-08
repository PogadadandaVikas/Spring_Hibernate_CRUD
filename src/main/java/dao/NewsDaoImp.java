package dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import model.News;

@Transactional("myTransactionManager")
@Repository
	
	public class NewsDaoImp implements NewsDao
	{

	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  
	  public boolean saveNews(News news) 
	  {
	    try
	    {
	      this.sessionFactory.getCurrentSession().save(news);
	      return true;
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	  }

	  public List<News> getAllNews() 
	  {
	    return this.sessionFactory.getCurrentSession().createQuery("from News").list();
	  }

	  public boolean deleteNews(int newsId) 
	  {
	    try
	    {
	      News nobj = this.sessionFactory.getCurrentSession().load(News.class, newsId);
	      this.sessionFactory.getCurrentSession().delete(nobj);
	      return true;
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	  }
	}

