package com.split_pay;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "expenseDetails")
public class ExpenseDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer e_id;
	private String paid_by;
	private String paid_for;
	private Integer amount;

	public ExpenseDetail() {
		// TODO Auto-generated constructor stub
	}

	public ExpenseDetail(Integer e_id, String paid_by, String paid_for, Integer amount) {
		super();
		this.e_id = e_id;
		this.paid_by = paid_by;
		this.paid_for = paid_for;
		this.amount = amount;
	}

	public Integer getE_id() {
		return e_id;
	}

	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}

	public String getPaid_by() {
		return paid_by;
	}

	public void setPaid_by(String paid_by) {
		this.paid_by = paid_by;
	}

	public String getPaid_for() {
		return paid_for;
	}

	public void setPaid_for(String paid_for) {
		this.paid_for = paid_for;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
