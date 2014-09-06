package com.google.swt.BeeApp3.shared.model;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.api.server.spi.types.DateAndTime;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Event implements IsSerializable
{
	public static final int CREATE_EVENT = 3;
	public static final int DELTE_EVENT = 2;
	public static final int STATUS_CHANGE_EVENT = 4;
	public static final int UPDATE_EVENT = 1;

	public static int getCreateEvent()
	{
		return CREATE_EVENT;
	}

	public static int getDelteEvent()
	{
		return DELTE_EVENT;
	}

	public static int getStatusChangeEvent()
	{
		return STATUS_CHANGE_EVENT;
	}

	public static int getUpdateEvent()
	{
		return UPDATE_EVENT;
	}

	private Action action;

	private int event;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	private UserRoleMatrix userRoleMatrix;

	private String text;

	private Date time;

	public Event()
	{
		// TODO Auto-generated constructor stub
	}

	public Action getAction()
	{
		return action;
	}


	public int getEvent()
	{
		return event;
	}

	public String getId()
	{
		return id;
	}



	public String getText()
	{
		return text;
	}

	public Date getTime()
	{
		return time;
	}

	public void setAction(Action action)
	{
		this.action = action;
	}



	public void setEvent(int event)
	{
		this.event = event;
	}

	public void setId(String id)
	{
		this.id = id;
	}



	public UserRoleMatrix getUserRoleMatrix()
	{
		return userRoleMatrix;
	}

	public void setUserRoleMatrix(UserRoleMatrix userRoleMatrix)
	{
		this.userRoleMatrix = userRoleMatrix;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

}
