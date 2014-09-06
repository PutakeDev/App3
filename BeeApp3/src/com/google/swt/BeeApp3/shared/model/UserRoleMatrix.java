package com.google.swt.BeeApp3.shared.model;

import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserRoleMatrix implements IsSerializable
{

	private List<Contact> contact;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;
	private List<Role> role;

	public UserRoleMatrix()
	{

	}

	public UserRoleMatrix(Role role, Contact contact)
	{
		this.add(role, contact);
	}

	public void add(Role role, Contact contact)
	{
		this.role.add(role);
		this.contact.add(contact);
	}

}
