package com.liveasy.loadmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.liveasy.loadmanagement.models.Load;
import com.liveasy.loadmanagement.service.LoadService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

	@Autowired
	private LoadService loadService;

	@PostMapping
	public Load createLoad(@RequestBody Load load) {
		return loadService.saveLoad(load);
	}

	@GetMapping
	public List<Load> getLoads(@RequestParam(required = false) String shipperId) {
		return loadService.getAllLoads(shipperId);
	}

	@GetMapping("/{loadId}")
	public Optional<Load> getLoadById(@PathVariable UUID loadId) {
		return loadService.getLoadById(loadId);
	}

	@PutMapping("/{loadId}")
	public Load updateLoad(@PathVariable UUID loadId, @RequestBody Load updatedLoad) {
		return loadService.updateLoad(loadId, updatedLoad);
	}

	@DeleteMapping("/{loadId}")
	public String deleteLoad(@PathVariable UUID loadId) {
		loadService.deleteLoad(loadId);
		return "Load deleted successfully";
	}
}
