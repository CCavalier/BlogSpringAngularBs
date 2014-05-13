package com.shinzul.blog.entity;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.Objects;

@Document
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger id;
	@Indexed(unique=true)
	private String username;
	private String password;
	private String email;
	
	public User() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id, this.username, this.password, this.email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		return Objects.equal(this.id, other.id) 
				&& Objects.equal(this.username, other.username)
				&& Objects.equal(this.password, other.password)
				&& Objects.equal(this.email, other.email);
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.addValue(this.id)
				.addValue(this.username)
				.addValue(this.password)
				.addValue(this.email)
				.toString();
	}
	

}
