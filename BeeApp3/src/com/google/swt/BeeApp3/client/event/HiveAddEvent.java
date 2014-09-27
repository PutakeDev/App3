package com.google.swt.BeeApp3.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class HiveAddEvent extends GwtEvent<HiveAddEventHandler>
{
	public static Type<HiveAddEventHandler> TYPE = new Type<HiveAddEventHandler>();

	@Override
	protected void dispatch(HiveAddEventHandler handler)
	{
		handler.onAddHive(this);
	}

	@Override
	public Type<HiveAddEventHandler> getAssociatedType()
	{
		return TYPE;
	}
}
