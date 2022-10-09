package com.sap.calulator.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vm_prices")
public class VmPrices {
	
	@Id
	private String vmName;

}
