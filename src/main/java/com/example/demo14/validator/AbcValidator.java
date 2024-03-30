package com.example.demo14.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator(value = "abcValidator")
public class AbcValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String inputValue = (String) value;
        if (!inputValue.contains("abc")) {
            System.out.println("erreur abc ");
            FacesMessage message = new FacesMessage("abc needs to be in your input!!!!!");
            throw new ValidatorException(message);
        }
    }
}
