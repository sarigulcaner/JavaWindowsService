package com.csinc.caner.entities;

import org.json.simple.*;
public abstract class EntityBase {
	public int ID;
	
	public abstract JSONObject toJson();

	
}
