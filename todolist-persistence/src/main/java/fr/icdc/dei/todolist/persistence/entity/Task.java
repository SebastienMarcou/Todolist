package fr.icdc.dei.todolist.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_task")
	private long id;
	
	@Column(nullable = false)
	private String label;
	
	@Column
	private Date beginningDate;
	
	@Column
	private Date endingDate;

	@Column
	private Date expectedEndingDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_category")
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user")
	private User user;

	public String getLabel() {
		return this.label;
	}

	public Date getExpectedEndingDate() {
		return expectedEndingDate;
	}

	public void setExpectedEndingDate(Date expectedEndingDate) {
		this.expectedEndingDate = expectedEndingDate;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getBeginninDate() {
		return this.beginningDate;
	}

	public void setBeginningDate(Date beginningDate) {
		this.beginningDate = beginningDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
		
	}

	public Date getEndingDate() {
		return  this.endingDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getBeginningDate() {
		return beginningDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
