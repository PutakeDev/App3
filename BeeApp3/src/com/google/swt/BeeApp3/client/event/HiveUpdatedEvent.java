package com.google.swt.BeeApp3.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.swt.BeeApp3.shared.model.Hive;

public class HiveUpdatedEvent extends GwtEvent<HiveUpdatedEventHandler>
{
	public static Type<HiveUpdatedEventHandler> TYPE = new Type<HiveUpdatedEventHandler>();

	public HiveUpdatedEvent(Hive result)
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void dispatch(HiveUpdatedEventHandler handler)
	{
		handler.onHiveUpdated(this);
	}

	@Override
	public Type<HiveUpdatedEventHandler> getAssociatedType()
	{
		return TYPE;
	}

}
