package com.unla.diegoibanez.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.diegoibanez.converters.DegreeConverter;
import com.unla.diegoibanez.entities.Degree;
import com.unla.diegoibanez.models.DegreeModel;
import com.unla.diegoibanez.repositories.IDegreeRepository;
import com.unla.diegoibanez.services.IDegreeService;


@Service("degreeService")
public class DegreeService implements IDegreeService {

	@Autowired
	@Qualifier("degreeRepository")
	private IDegreeRepository degreeRepository;
	
	@Autowired
	@Qualifier("degreeConverter")
	private DegreeConverter degreeConverter;
	
	@Override
	public List<Degree> getAll() {
		return degreeRepository.findAll();
	}

	@Override
	public DegreeModel insertOrUpdate(DegreeModel degreeModel) {
		Degree degree = degreeRepository.save(degreeConverter.modelToEntity(degreeModel));
		return degreeConverter.entityToModel(degree);
	}

	@Override
	public boolean remove(int id) {
		try {
			degreeRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}