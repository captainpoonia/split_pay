package com.split_pay;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer g_id;
	private String g_name;
	private Integer created_by;

	public Group() {
		// TODO Auto-generated constructor stub
	}

	public Group(Integer g_id, String g_name, Integer created_by) {
		super();
		this.g_id = g_id;
		this.g_name = g_name;
		this.created_by = created_by;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	
}
