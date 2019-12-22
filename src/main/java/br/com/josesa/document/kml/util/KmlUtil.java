package br.com.josesa.document.kml.util;

import java.util.Arrays;
import java.util.List;

import br.com.josesa.document.kml.model.Coordinate;
import br.com.josesa.document.kml.model.Placemarker;

public class KmlUtil {
	
	public final static String DOCUMENT_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
			"<kml xmlns=\"http://www.opengis.net/kml/2.2\" \n" + 
			"xmlns:gx=\"http://www.google.com/kml/ext/2.2\" \n" + 
			"xmlns:kml=\"http://www.opengis.net/kml/2.2\" \n" + 
			"xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" + 
			"<Document>";
	
	public final static String DOCUMENT_FOOTER = "</Document>\n" + 
			"</kml>";
	
	private static List<String> color = Arrays.asList(
				"1400FF",
				"14F0FF",
				"F00014",
				"7800F0",
				"000000",
				"143CFF"
			);
	
	private static int countColor = 0;

	public static String name(String name) {
		return String.format("<name>%s</name>", name);
	}

	public static String style() {
		int index = getColor();
		return String.format(
				"		<Style>\n" + 
				"			<IconStyle>\n" + 
				"				<Icon></Icon>\n" + 
				"			</IconStyle>\n" + 
				"			<LabelStyle>\n" + 
				"				<color>64%s</color>\n" + 
				"			</LabelStyle>\n" + 
				"			<LineStyle>\n" + 
				"				<color>64%s</color>\n" + 
				"				<width>10</width>\n" + 
				"			</LineStyle>\n" + 
				"			<PolyStyle>\n" + 
				"				<color>1e%s</color>\n" + 
				"			</PolyStyle>\n" + 
				"		</Style>"
				, color.get(index)
				, color.get(index)
				, color.get(index)
			);
	}

	private static int getColor() {
		
		if(countColor == color.size()) 
			countColor = 0;
		
		countColor++;
		
		return countColor - 1;
	}
	
	private static String point(Coordinate coordinate) {
		return String.format(
				"			<Point>\n" + 
				"				<coordinates>%s,%s,%s</coordinates>\n" + 
				"			</Point>"
				, coordinate.getLongitude()
				, coordinate.getLatitude()
				, coordinate.getAltitude()
			);
	}
	
	private static String polygon(List<Coordinate> coordinates) {
		
		StringBuilder sb = new StringBuilder();
		
		for (Coordinate c : coordinates) {
			sb.append(c.polygonDots());
		}
		
		return sb.toString();
	}

	public static String placemark(Placemarker place) {

		return String.format(
				"<Placemark>\n" + 
				"		%s\n" + 
				"\n" + 
				"		%s\n" +
				"\n" + 
				"		<MultiGeometry>\n" + 
				"\n" + 
				"			%s\n" + 
				"\n" + 
				"			<Polygon>\n" + 
				"				<outerBoundaryIs>\n" + 
				"					<LinearRing>\n" + 
				"						<coordinates>\n" + 
				"							%s \n" + 
				"						</coordinates>\n" + 
				"					</LinearRing>\n" + 
				"				</outerBoundaryIs>\n" + 
				"			</Polygon>\n" + 
				"		</MultiGeometry>\n" + 
				"	</Placemark>"
				, name(place.getName())
				, style()
				, point(place.getPoint())
				, polygon(place.getPolygon())
			);
		
	}

}
