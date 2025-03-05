package com.dev.kevin.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, updatable = false)
	private User user;

	@Column(name = "description", length = 255, nullable = false)
	@NotEmpty
	@NotNull
	@Size(min = 1, max = 255)
	private String description;

	public Task() {
	}

	public Task(Long id, User user, String description) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescricao() {
		return description;
	}

	public void setDescricao(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if(! (obj instanceof Task))
			return false;
		Task other = (Task) obj;
		if(this.id == null)
			if(other.id != null)
				return false;
			else if(!this.id.equals(other.id))
				return false;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}

}
