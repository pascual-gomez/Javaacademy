package com.pascualgomz.challengeTopic2.configuration;

import com.pascualgomz.challengeTopic2.domain.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Document document() {
        return new Document();
    }
}
