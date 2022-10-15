package com.sap.calulator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.calulator.entities.HanaDBStorage;

@Repository
public interface HanaDBStorageRepository extends JpaRepository<HanaDBStorage, String> {
	
	HanaDBStorage findByVmNameAndMemory(String vmName, long memory);

}
