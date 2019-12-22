package br.com.josesa.document.kml.creator;

import java.util.List;

import br.com.josesa.document.kml.model.Document;
import br.com.josesa.document.kml.model.Placemarker;
import br.com.josesa.document.kml.util.KmlUtil;

public class DocumentKml {
	
	public String create(Document document) {
		
		List<Placemarker> placemarkes = document.getPlacemarkes();
		StringBuilder kml = new StringBuilder();
		
		kml.append(KmlUtil.DOCUMENT_HEADER);
		kml.append(KmlUtil.name(document.getName()));
		
		for (Placemarker place : placemarkes) {
			kml.append(KmlUtil.placemark(place));
		}
		
		kml.append(KmlUtil.DOCUMENT_FOOTER);
		
		return kml.toString();
	}

}
