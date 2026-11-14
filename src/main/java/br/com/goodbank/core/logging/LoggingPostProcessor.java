package br.com.goodbank.core.logging;

import org.springframework.boot.EnvironmentPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class LoggingPostProcessor implements EnvironmentPostProcessor {
    private static final String CONFIG_GOODBANK =
            "classpath:logging/logback.xml";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment,
                                       SpringApplication application) {

        environment.getPropertySources().addLast(
                new MapPropertySource("goodbankLoggingDefaults", Map.of(
                        "logging.config", CONFIG_GOODBANK,

                        // Remove os campos que você não quer
                        "logging.structured.json.exclude", "@version,thread_name,level_value,tags",

                        // Renomeia
                        "logging.structured.json.rename.[@timestamp]", "timestamp",
                        "logging.structured.json.rename.[logger_name]", "logger"

                )));
    }
}
