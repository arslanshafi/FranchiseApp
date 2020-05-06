package com.ooredoo.service;


import com.ooredoo.exception.FranchiseAlreadyExistsException;
import com.ooredoo.persistence.model.Franchise;
import com.ooredoo.persistence.repository.FranchiseRepository;
import com.ooredoo.rest.dto.FranchiseDto;
import com.ooredoo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseService {

	@Autowired
    private FranchiseRepository franchiseRepository;

	public List<FranchiseDto> getAllFranchises() {
		List<Franchise> franchise = franchiseRepository.findAllByenabledTrue();
		List<FranchiseDto> franchiseDto = ObjectMapperUtils.mapAll(franchise, FranchiseDto.class);
		return franchiseDto;
	}

	public FranchiseDto createFranchise(FranchiseDto franchiseDto) {
		Franchise franchise = ObjectMapperUtils.map(franchiseDto, Franchise.class);

		Franchise oldFranchise =  franchiseRepository.findByIdNumber(franchise.getIdNumber());
		if(oldFranchise != null)
			throw new FranchiseAlreadyExistsException("Franchise application already exists with Id Number: " + oldFranchise.getIdNumber());

		franchiseRepository.save(franchise);
		FranchiseDto FranchiseDto = ObjectMapperUtils.map(franchise, FranchiseDto.class);
		return FranchiseDto;
	}
}
