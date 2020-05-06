package com.ooredoo.rest.controller;

import com.ooredoo.rest.dto.FranchiseDto;
import com.ooredoo.rest.dto.ResponseDto;
import com.ooredoo.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FranchiseController {
	@Autowired
	private FranchiseService franchiseService;

	@GetMapping(value = "/franchises", produces = {"application/json", "text/json"})
	public List<FranchiseDto> getAllFranchises() {
			return franchiseService.getAllFranchises();
	}

	@PostMapping(value = "/franchise", consumes = {"application/json", "text/json"} , produces = {"application/json", "text/json"})
	public ResponseDto createFranchise(@Valid @RequestBody FranchiseDto franchiseDTo) {
		return new ResponseDto("success", "Franchise added successfully", franchiseService.createFranchise(franchiseDTo));
	}
}
