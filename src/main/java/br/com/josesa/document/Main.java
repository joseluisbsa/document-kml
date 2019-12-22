package br.com.josesa.document;

import java.util.Arrays;
import java.util.List;

import br.com.josesa.document.kml.creator.DocumentKml;
import br.com.josesa.document.kml.model.Coordinate;
import br.com.josesa.document.kml.model.Document;
import br.com.josesa.document.kml.model.Placemarker;

public class Main {
	
	public static void main(String[] args) {
		
		List<Coordinate> polygon1 = 
				Arrays.asList(
					new Coordinate("-46.69003187150312","-23.75078630605232","0"),
					new Coordinate("-46.69022124017955","-23.75091999874307","0"),
					new Coordinate("-46.69010206764691","-23.75111019842108","0"),
					new Coordinate("-46.68978928860697","-23.75103030037896","0"),
					new Coordinate("-46.69003187150312","-23.75078630605232","0")
				);
		 
		List<Coordinate> polygon2 = 
				Arrays.asList(
					new Coordinate("-46.69151517600778","-23.75163422082329","0"),
					new Coordinate("-46.69133490957912","-23.75178797575133","0"),
					new Coordinate("-46.69109612424104","-23.75170716616105","0"),
					new Coordinate("-46.69124087307212","-23.75149134964026","0"),
					new Coordinate("-46.69151517600778","-23.75163422082329","0")
				);
		
		List<Placemarker> placemarkers = 
				Arrays.asList(
					new Placemarker("001", polygon1),
					new Placemarker("002", polygon2)
				);
		
		Document document = new Document("DOC TESTE", placemarkers);
		
		DocumentKml documentKml = new DocumentKml();
		String kml = documentKml.create(document);
		
		System.out.println(kml);
		
	}

}
