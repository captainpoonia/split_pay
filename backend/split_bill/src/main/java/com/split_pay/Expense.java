package com.split_pay;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eId;
	private Integer g_id;
	private Integer userId;
	private String eTitle;

	public Expense() {
		// TODO Auto-generated constructor stub
	}

	public Expense(Integer eId, Integer g_id, Integer userId, String eTitle) {
		super();
		this.eId = eId;
		this.g_id = g_id;
		this.userId = userId;
		this.eTitle = eTitle;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public Integer getg_id() {
		return g_id;
	}

	public void setg_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String geteTitle() {
		return eTitle;
	}

	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	@Override
	public String toString() {
		return "Expense [eId=" + eId + ", g_id=" + g_id + ", userId=" + userId + ", eTitle=" + eTitle
				+ "]";
	}

}
