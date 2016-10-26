package com.home.spring.core;

import com.home.spring.core.domain.SpellChecker;
import com.home.spring.core.domain.TextEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Arun on 11/23/2015.
 */

/* Declaring a Bean can be done in a config file which will be used to autowire.
 * If we don't need a config file, we can annotate each Domain with @Component/@Repository/@Controller/@Service
 * with enabling Component scanning in the xml file */

@Configuration
public class Config {


    @Bean
    public SpellChecker spellChecker() {
        return new SpellChecker();
    }

    @Bean(name = "TextEditor")
    public TextEditor textEditor() {
        return new TextEditor();
    }

}
