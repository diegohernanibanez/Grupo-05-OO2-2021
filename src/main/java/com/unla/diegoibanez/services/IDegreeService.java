package com.unla.diegoibanez.services;
import java.util.List;

import com.unla.diegoibanez.entities.Degree;
import com.unla.diegoibanez.models.DegreeModel;


public interface IDegreeService {

	public List<Degree> getAll();
	
	public DegreeModel insertOrUpdate(DegreeModel degreeModel);
	
	public boolean remove(int id);
}