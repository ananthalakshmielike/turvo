package com.turvo.assesment.shipmenttracking.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.turvo.assesment.shipmenttracking.enums.PreferenceType;
import com.turvo.assesment.shipmenttracking.enums.ShipmentStatus;

@Entity
@Table
public class Customer {
	@Id
	private int id;
	@Column
	private String name;

	@Column
	@ElementCollection(targetClass=PreferenceType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="chanelPreferenceList")
	private Collection<PreferenceType> chanelPreferenceList;
	

	@Column
	@ElementCollection(targetClass=ShipmentStatus.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="subscribeList")
	private Collection<ShipmentStatus> subscribeList;

	@Column
	private String email;


	public Collection<ShipmentStatus> getSubscribeList() {
		return subscribeList;
	}

	public void setSubscribeList(Collection<ShipmentStatus> subscribeList) {
		this.subscribeList = subscribeList;
	}

	@Column
	private long contactNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<PreferenceType> getChanelPreferenceList() {
		return chanelPreferenceList;
	}

	public void setChanelPreferenceList(Collection<PreferenceType> chanelPreferenceList) {
		this.chanelPreferenceList = chanelPreferenceList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contactNumber ^ (contactNumber >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Customer other = (Customer) obj;
		if (contactNumber != other.contactNumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
