package se.magnus.microservices.core.recommendation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("se.magnus")
@Slf4j
public class RecommendationServiceApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = SpringApplication.run(RecommendationServiceApplication.class, args);
    String postgresqlUri = ctx.getEnvironment().getProperty("spring.datasource.url");
    log.info("Connected to PostgresQL: " + postgresqlUri);
  }
}
