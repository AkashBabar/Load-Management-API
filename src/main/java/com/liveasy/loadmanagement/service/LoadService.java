package com.liveasy.loadmanagement.service;

import com.liveasy.loadmanagement.exception.LoadNotFoundException;
import com.liveasy.loadmanagement.models.Load;
import com.liveasy.loadmanagement.repository.LoadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

	private static final Logger logger = LoggerFactory.getLogger(LoadService.class);

	@Autowired
	private LoadRepository loadRepository;

	public Load saveLoad(Load load) {
		logger.info("Saving new load: {}", load);
		return loadRepository.save(load);
	}

	public List<Load> getAllLoads(String shipperId) {
		logger.info("Fetching loads for shipperId: {}", shipperId);
		return (shipperId != null) ? loadRepository.findByShipperId(shipperId) : loadRepository.findAll();
	}

	public Optional<Load> getLoadById(UUID loadId) {
		logger.info("Fetching load by ID: {}", loadId);
		return loadRepository.findById(loadId);
	}

	@Transactional
	public Load updateLoad(UUID loadId, Load updatedLoad) {
		logger.info("Updating load with ID: {}", loadId);
		return loadRepository.findById(loadId).map(load -> {
			load.setFacility(updatedLoad.getFacility());
			load.setProductType(updatedLoad.getProductType());
			load.setTruckType(updatedLoad.getTruckType());
			load.setNoOfTrucks(updatedLoad.getNoOfTrucks());
			load.setWeight(updatedLoad.getWeight());
			load.setComment(updatedLoad.getComment());
			load.setDate(updatedLoad.getDate());
			return loadRepository.save(load);
		}).orElseThrow(() -> {
			logger.error("Load not found with ID: {}", loadId);
			return new LoadNotFoundException("Load with ID " + loadId + " not found");
		});
	}

	@Transactional
	public void deleteLoad(UUID loadId) {
		logger.info("Deleting load with ID: {}", loadId);
		if (!loadRepository.existsById(loadId)) {
			logger.error("Load not found with ID: {}", loadId);
			throw new LoadNotFoundException("Load with ID " + loadId + " not found");
		}
		loadRepository.deleteById(loadId);
	}
}
