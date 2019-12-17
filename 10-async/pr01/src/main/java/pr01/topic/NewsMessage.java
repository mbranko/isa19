package pr01.topic;

import java.io.Serializable;

public class NewsMessage implements Serializable {

  private String title;
  private String text;
  
  public NewsMessage() {
  }
  
  public NewsMessage(String title, String text) {
    this.title = title;
    this.text = text;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  
  public String toString() {
    return "(NewsMessage)[title="+title+",text="+text+"]";
  }
  
  private static final long serialVersionUID = -5605318603951231504L;
}
