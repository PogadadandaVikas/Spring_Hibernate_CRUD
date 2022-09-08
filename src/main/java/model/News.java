package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int newsId;
  private String newsTitle;
  private String newsText;
  private String newsCategory;
  
  public int getNewsId() {
    return newsId;
  }
  public void setNewsId(int newsId) {
    this.newsId = newsId;
  }
  public String getNewsTitle() {
    return newsTitle;
  }
  public void setNewsTitle(String newsTitle) {
    this.newsTitle = newsTitle;
  }
  public String getNewsText() {
    return newsText;
  }
  public void setNewsText(String newsText) {
    this.newsText = newsText;
  }
  public String getNewsCategory() {
    return newsCategory;
  }
  public void setNewsCategory(String newsCategory) {
    this.newsCategory = newsCategory;
  }
  
  @Override
  public String toString() {
    return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsText=" + newsText + ", newsCategory="
        + newsCategory + "]";
  }
}
