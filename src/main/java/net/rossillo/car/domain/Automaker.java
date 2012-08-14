package net.rossillo.car.domain;

import java.io.Serializable;

public class Automaker implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;

	public Automaker() {
		super();
	}
	
	public Automaker(final String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
