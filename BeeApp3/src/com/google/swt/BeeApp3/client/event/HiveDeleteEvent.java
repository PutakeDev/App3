package com.google.swt.BeeApp3.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class HiveDeleteEvent extends GwtEvent<HiveDeleteEventHandler>
{
	public static Type<HiveDeleteEventHandler> TYPE = new Type<HiveDeleteEventHandler>();

	@Override
	protected void dispatch(HiveDeleteEventHandler handler)
	{
		handler.onHiveDeleted(this);
	}

	@Override
	public Type<HiveDeleteEventHandler> getAssociatedType()
	{
		return TYPE;
	}

}
