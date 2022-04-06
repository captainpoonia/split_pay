package com.split_pay;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "groupMember")
public class GroupMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer gm_id;
	private Integer user_id;
	private Integer g_id;

	public GroupMember() {

	}

	public GroupMember(Integer user_id, Integer g_id) {
		this.gm_id=0;
	    this.user_id = user_id;
		this.g_id = g_id;
	}
	public GroupMember(Integer gm_id, Integer user_id, Integer g_id) {
		super();
		this.gm_id = gm_id;
		this.user_id = user_id;
		this.g_id = g_id;
	}

	public Integer getGm_id() {
		return gm_id;
	}

	public void setGm_id(Integer gm_id) {
		this.gm_id = gm_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	@Override
	public String toString() {
		return "GroupMember [gm_id=" + gm_id + ", user_id=" + user_id + ", g_id=" + g_id + "]";
	}
    
}
