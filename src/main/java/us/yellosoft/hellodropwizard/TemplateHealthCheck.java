package us.yellosoft.hellodropwizard;

import com.codahale.metrics.health.HealthCheck;

/**
   An example Dropwizard health check
 */
public class TemplateHealthCheck extends HealthCheck {
  private final String greetingTemplate;

  public TemplateHealthCheck(String greetingTemplate) {
    this.greetingTemplate = greetingTemplate;
  }

  @Override
  protected Result check() throws Exception {
    final String value = String.format(greetingTemplate, "test");

    if (!value.contains("test")) {
      return Result.unhealthy("Template does not allow custom names");
    }
    else {
      return Result.healthy();
    }
  }
}
