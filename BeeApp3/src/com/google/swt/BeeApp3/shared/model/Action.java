package com.google.swt.BeeApp3.shared.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Action implements IsSerializable
{
	public static final int INSPECT_APIARY = 2;

	public static final int INSPECT_COLONY = 1;
	public static final int NO_ACTION = 4;
	public static final int REPAIR_HIVE = 3;

	public static int getInspectApiary()
	{
		return INSPECT_APIARY;
	}

	public static int getInspectColony()
	{
		return INSPECT_COLONY;
	}

	public static int getNoAction()
	{
		return NO_ACTION;
	}

	public static int getRepairHive()
	{
		return REPAIR_HIVE;
	}

	private int action;

	private UserRoleMatrix allocatedTo;

	private DateTimeFormat dueDate;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	private UserRoleMatrix raisedBy;

	private String text;

	public Action()
	{
		// TODO Auto-generated constructor stub
	}

	public int getAction()
	{
		return action;
	}

	public UserRoleMatrix getAllocatedTo()
	{
		return allocatedTo;
	}

	public DateTimeFormat getDueDate()
	{
		return dueDate;
	}

	public String getId()
	{
		return id;
	}

	public UserRoleMatrix getRaisedBy()
	{
		return raisedBy;
	}

	public String getText()
	{
		return text;
	}

	public void setAction(int action)
	{
		this.action = action;
	}

	public void setAllocatedTo(UserRoleMatrix allocatedTo)
	{
		this.allocatedTo = allocatedTo;
	}

	public void setDueDate(DateTimeFormat dueDate)
	{
		this.dueDate = dueDate;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setRaisedBy(UserRoleMatrix raisedBy)
	{
		this.raisedBy = raisedBy;
	}

	public void setText(String text)
	{
		this.text = text;
	}

}
