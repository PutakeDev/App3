package com.google.swt.BeeApp3.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class LocationAddEvent extends GwtEvent<LocationAddEventHandler>
{
	public static Type<LocationAddEventHandler> TYPE = new Type<LocationAddEventHandler>();

	@Override
	protected void dispatch(LocationAddEventHandler handler)
	{
		handler.onAddLocation(this);
	}

	@Override
	public Type<LocationAddEventHandler> getAssociatedType()
	{
		return TYPE;
	}
}
