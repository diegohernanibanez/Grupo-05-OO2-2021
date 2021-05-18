package com.unla.diegoibanez.converters;

import org.springframework.stereotype.Component;

import com.unla.diegoibanez.entities.Degree;
import com.unla.diegoibanez.models.DegreeModel;

@Component("degreeConverter")
public class DegreeConverter {

	public DegreeModel entityToModel(Degree degree) {
		return new DegreeModel(degree.getId(), degree.getName(), degree.getInstitution(), degree.getYear());
	}

	public Degree modelToEntity(DegreeModel degreeModel) {
		return new Degree(degreeModel.getId(), degreeModel.getName(), degreeModel.getInstitution(), degreeModel.getYear());
	}
}