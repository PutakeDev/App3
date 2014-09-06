package com.google.swt.BeeApp3.shared.model;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Status implements IsSerializable
{

	public static final int ACTIVE = 1;
	public static final int DRAFT = 3;
	public static final int HISTORY = 4;
	public static final int INACTIVE = 2;
	public static final int TEMP = 5;
	public static final int UNDER_INSPECTION = 6;

	private DateTimeFormat time;

	public Status()
	{
		// TODO Auto-generated constructor stub
	}

}
