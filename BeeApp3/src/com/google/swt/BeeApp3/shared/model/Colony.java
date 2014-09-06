package com.google.swt.BeeApp3.shared.model;

import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.swt.BeeApp3.server.DateHelper;

public class Colony implements IsSerializable
{

	private List<Event> event;
	private Hive hive;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	private String name;

	private List<Status> status;

	public Colony()
	{
		// TODO Auto-generated constructor stub
	}

	public Status getCurrentStatus()
	{
		return this.status.get(this.status.size());
	}

	public List<Event> getEvent()
	{
		return event;
	}

	public Hive getHive()
	{
		return hive;
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setCurrentStatus(Status s)
	{
		Event e = new Event();
		e.setEvent(Event.getStatusChangeEvent());
		e.setAction(null);
		e.setTime(new DateHelper().getGMTTimeStamp());
		e.setText("Colony status changed");
		this.event.add(e);
		this.status.add(s);
	}

	public void setHive(Hive hive)
	{
		this.hive = hive;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	
}
