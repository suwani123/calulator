package com.sap.calulator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sap.calulator.entities.VmData;

@Repository
public interface VmDataRepository extends JpaRepository<VmData, String>{

	List<VmData> findAllByVcpuAndMemoryOrderBySapsDesc(long vcpu, long memory);
	
	List<VmData> findAllByMemoryOrderBySapsDesc(long memory);
	
	
	List<VmData> findAllByMemoryAndIsHANACerifiedAndVmNameStartingWithOrderBySapsDesc(long memory, boolean ishanacerified, String vmName);
	
	
}
