package com.home.spring.core.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arun on 11/23/2015.
 */

@Service
@Singleton
public class TextEditor {

    @Inject
    //User @Autowired or @Resource or @Inject --> Same Result
    private SpellChecker spellChecker;

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
