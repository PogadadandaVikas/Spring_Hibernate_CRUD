package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDao;
import model.News;

@Controller
@RequestMapping("/")
public class NewsController {
		
	  @Autowired
	  private NewsDao newsdao;
	    
	  @GetMapping("/")
	  public ModelAndView getHomePage()
	  {
	    ModelAndView modelAndview = new ModelAndView("home");
	    
	    modelAndview.addObject("newsList",newsdao.getAllNews());
	    return modelAndview;
	  }
	  
	  @PostMapping("/saveNews")
	  public String saveNews(@ModelAttribute("news") News news, ModelMap modelmap)
	  {
	    boolean status = newsdao.saveNews(news);
	    modelmap.addAttribute("newsList",newsdao.getAllNews());
	    return "home";
	  }
	  
	  @GetMapping("/deletenews")
	  public String deleteNews(@RequestParam("newsId") int newsId)
	  {
	    newsdao.deleteNews(newsId);
	    return "redirect:/";
	  }
}
