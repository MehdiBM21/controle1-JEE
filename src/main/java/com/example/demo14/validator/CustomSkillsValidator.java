package com.example.demo14.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CustomSkillsValidator implements Validator<String> {

    private static final String PATTERN = "[a-zA-Z]+(-[a-zA-Z]+)*"; // Regex pattern to match "word-word-word" format

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (value == null || !value.matches(PATTERN)) {
            FacesMessage message = new FacesMessage("Expected format: skill-skill-skill");
            throw new ValidatorException(message);
        }
    }
}

