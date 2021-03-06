package com.shiqihang.entity;

import java.io.Serializable;
/**
 * 
 * @author admin
 *	实体类
 */
public class Control implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 186200121222697337L;
	private Integer id;
	private String type;
	public Control() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Control(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Control other = (Control) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Control [id=" + id + ", type=" + type + "]";
	}
	
}
