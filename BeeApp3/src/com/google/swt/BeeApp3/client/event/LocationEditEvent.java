package com.google.swt.BeeApp3.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class LocationEditEvent extends GwtEvent<LocationEditEventHandler>
{
	public static Type<LocationEditEventHandler> TYPE = new Type<LocationEditEventHandler>();
	private final String id;

	public LocationEditEvent(String id)
	{
		this.id = id;
	}

	@Override
	protected void dispatch(LocationEditEventHandler handler)
	{
		handler.onLocationEdit(this);
	}

	@Override
	public Type<LocationEditEventHandler> getAssociatedType()
	{
		return TYPE;
	}
}
