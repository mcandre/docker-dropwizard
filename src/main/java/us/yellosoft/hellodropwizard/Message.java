package us.yellosoft.hellodropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
   An example JSON definition
 */
public class Message {
  @NotBlank
  private String content;

  /**
     @param content a non-blank String
   */
  public Message(String content) {
    this.content = content;
  }

  /**
     @return String content
   */
  @JsonProperty
  public String getContent() {
    return content;
  }
}
