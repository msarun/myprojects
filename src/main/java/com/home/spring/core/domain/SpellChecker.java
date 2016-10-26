package com.home.spring.core.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by Arun on 11/23/2015.
 */

@Component
public class SpellChecker {

    public SpellChecker() {
        System.out.println("Inside SpellChecker constructor");
    }

    public void checkSpelling() {
        System.out.println("Running Spell Check");
    }

}
