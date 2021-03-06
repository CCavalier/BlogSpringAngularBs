package com.shinzul.blog.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@Document
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger id;
	private String title;
	@DBRef
	@Indexed
	private User author;
	@DBRef
	@Indexed
	private Category category;
	private String content;
	@Indexed
	private List<String> tags;
	
	public News() {
		super();
		this.tags = Lists.newArrayList();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id, this.title, this.author, this.category, this.content, this.tags);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final News other = (News) obj;
		return Objects.equal(this.id, other.id)
				&& Objects.equal(this.title, other.title)
				&& Objects.equal(this.author, other.author)
				&& Objects.equal(this.category, other.category)
				&& Objects.equal(this.content, other.content)
				&& Objects.equal(this.tags, other.tags);
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.addValue(this.id)
				.addValue(this.title)
				.addValue(this.author)
				.addValue(this.category)
				.addValue(this.tags)
				.addValue(this.content)
				.toString();
	}

}
