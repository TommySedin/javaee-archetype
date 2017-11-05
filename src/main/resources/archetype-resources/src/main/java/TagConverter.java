package ${package};

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ${package}.Tag;
import ${package}.TodoBean;

	/*
		VIKTIGT: För att en @FacesConverter ska funka pålitligt måste equals() och hashCode() overridas i klassen den ska konvertera (se Tag.java).
	*/

@FacesConverter(forClass=Tag.class)
public class TagConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id;
		try {
			id = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return "";
		}
		BakeryBean bb = context.getApplication().evaluateExpressionGet(context, "#{todoBean}", TodoBean.class);
		return bb.getTagEJB().find(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) return "";
		if (!(value instanceof Tag)) return "";
		
		return Integer.toString( ((Tag) value).getTagid() );
	}
	
}