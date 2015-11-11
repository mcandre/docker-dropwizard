package us.yellosoft.hellodropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
   An example service application definition
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
  public static void main(String[] args) throws Exception {
    new HelloWorldApplication().run(args);
  }

  @Override
  public String getName() {
    return "hello-dropwizard";
  }

  @Override
  public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
    // ...
  }

  @Override
  public void run(HelloWorldConfiguration configuration, Environment environment) {
    final HelloWorldResource resource = new HelloWorldResource(
      configuration.getGreetingTemplate()
    );
    final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getGreetingTemplate());

    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(resource);
  }
}
