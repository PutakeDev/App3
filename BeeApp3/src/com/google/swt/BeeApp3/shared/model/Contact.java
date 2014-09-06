package com.google.swt.BeeApp3.shared.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Contact implements IsSerializable
{

	private String email;
	private String FirstName;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;
	private String phone;
	private String Surname;

	public Contact()
	{
		// TODO Auto-generated constructor stub
	}

	public Contact(String firstName, String surname, String email, String phone)
	{
		super();
		FirstName = firstName;
		Surname = surname;
		this.email = email;
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public String getFirstName()
	{
		return FirstName;
	}

	public String getId()
	{
		return id;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getSurname()
	{
		return Surname;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setFirstName(String firstName)
	{
		FirstName = firstName;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public void setSurname(String surname)
	{
		Surname = surname;
	}

}
