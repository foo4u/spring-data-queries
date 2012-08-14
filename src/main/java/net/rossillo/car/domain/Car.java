package net.rossillo.car.domain;

import java.io.Serializable;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;
	
	@Indexed(unique=true)
	private String model;
	
	@DBRef
	private Automaker automaker;
	
	public Car() { }
	
	public Car(final Automaker make, final String model) {
		this.automaker = make;
		this.model = model;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Automaker getAutomaker() {
		return automaker;
	}

	public void setAutomaker(Automaker automaker) {
		this.automaker = automaker;
	}
	
}
