package com.google.swt.BeeApp3.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class HiveEditEvent extends GwtEvent<HiveEditEventHandler>
{
	public static Type<HiveEditEventHandler> TYPE = new Type<HiveEditEventHandler>();
	private final String id;

	public HiveEditEvent(String id)
	{
		this.id = id;
	}

	@Override
	protected void dispatch(HiveEditEventHandler handler)
	{
		handler.onHiveEdit(this);
	}

	@Override
	public Type<HiveEditEventHandler> getAssociatedType()
	{
		return TYPE;
	}
}
