package com.google.swt.BeeApp3.shared.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Apiary implements IsSerializable
{

	private String comment;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;
	private Location location;
	private String name;
	private String owner;
	private UserRoleMatrix usrRole;

	public Apiary()
	{

	}

	public String getComment()
	{
		return comment;
	}

	public String getId()
	{
		return id;
	}

	public Location getLocation()
	{
		return location;
	}

	public String getName()
	{
		return name;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

}
