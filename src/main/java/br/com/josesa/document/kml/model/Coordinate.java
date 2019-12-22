package br.com.josesa.document.kml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Coordinate {

	private String longitude;
	private String latitude;
	private String altitude;
	
	public String polygonDots() {
		return String.format("%s,%s,%s ", longitude, latitude, altitude);
	}
	
}
