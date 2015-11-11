package us.yellosoft.hellodropwizard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

/**
   An example Dropwizard Resource
 */
@Path("/hello-dropwizard")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
  private final String greetingTemplate;

  /**
     @param greetingTemplate a Java String.format template
   */
  public HelloWorldResource(String greetingTemplate) {
    this.greetingTemplate = greetingTemplate;
  }

  /**
     @param name (defaults to "World")
   */
  @GET
  @Timed
  public Message greet(@QueryParam("name") Optional<String> name) {
    final String value = String.format(greetingTemplate, name.or("World"));
    return new Message(value);
  }
}
