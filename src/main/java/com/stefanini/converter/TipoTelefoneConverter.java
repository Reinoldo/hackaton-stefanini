package com.stefanini.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.stefanini.model.TipoTelefone;

@FacesConverter("tipoTelefoneConverter")
public class TipoTelefoneConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if (id == null || id.trim().isEmpty()) {
			return null;
		}
		
		return component.getAttributes().get(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
        	TipoTelefone tipoTelefone = (TipoTelefone) value;
        	
        	component.getAttributes().put(String.valueOf(tipoTelefone.getId()), tipoTelefone);
  
            Integer idTipoTelefone = tipoTelefone.getId();
            
            if (idTipoTelefone != null) {
                return String.valueOf(idTipoTelefone);
            }
        }
  
        return (String) value;
	}
}
