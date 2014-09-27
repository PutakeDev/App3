package com.google.swt.BeeApp3.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class HiveEditCancelEvent extends GwtEvent<HiveEditCancelEventHandler>
{
	public static Type<HiveEditCancelEventHandler> TYPE = new Type<HiveEditCancelEventHandler>();
	private final String id;

	public HiveEditCancelEvent(String id)
	{
		this.id = id;
	}

	@Override
	protected void dispatch(HiveEditCancelEventHandler handler)
	{
		handler.onHiveEditCancel(this);
	}

	@Override
	public Type<HiveEditCancelEventHandler> getAssociatedType()
	{
		return TYPE;
	}
}
