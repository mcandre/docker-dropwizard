package us.yellosoft.hellodropwizard;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
   An example service configuration definition
 */
public class HelloWorldConfiguration extends Configuration {
  @NotBlank
  private String greetingTemplate;

  /**
     @return a configured message template
   */
  @JsonProperty
  public String getGreetingTemplate() {
    return greetingTemplate;
  }

  /**
     @param greeting a configurable message template
   */
  @JsonProperty
  public void setGreeting(String greetingTemplate) {
    this.greetingTemplate = greetingTemplate;
  }
}
