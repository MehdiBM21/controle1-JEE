package com.example.demo14.converter;

import com.example.demo14.model.Employe;
import com.example.demo14.service.EmployeService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

//@FacesConverter(forClass = Employe.class)
public class EmployeConverter implements Converter {
    EmployeService employeService = new EmployeService();

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        if (object == null || object.equals("")) {
            return "";
        }
        if (object instanceof Employe) {
            return String.valueOf(((Employe) object).getId());
        } else {
            throw new ConverterException(new FacesMessage(object + " is not a valid Employe"));
        }

    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return employeService.findById(Long.valueOf(submittedValue));
            // Here you would typically fetch the Employe object from your database based on the ID
            // For the sake of example, let's create a new Employe with the given ID
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid value submitted for Employe ID", e);
        }
    }
}
