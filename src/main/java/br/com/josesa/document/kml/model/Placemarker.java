package br.com.josesa.document.kml.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Placemarker {
	
	private String name;
	private Coordinate point;
	private List<Coordinate> polygon;
	
	public Placemarker(String name, List<Coordinate> polygon) {
		this.name = name;
		this.point = polygon.get(0);
		this.polygon = polygon;
	}
	
}
