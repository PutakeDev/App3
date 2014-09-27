package com.google.swt.BeeApp3.client.Presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.swt.BeeApp3.client.ApiAsync;
import com.google.swt.BeeApp3.client.view.Location.LocationDetailsView;
import com.google.swt.BeeApp3.client.view.Location.LocationView;
import com.google.swt.BeeApp3.shared.model.Location;

public class LocationDetailsViewPresenter implements Presenter,
LocationDetailsView.Presenter<Location>
{
private final ApiAsync api;
private final HandlerManager eventBus;
private Location[] locations;
private final LocationDetailsView<Location> view;

public LocationDetailsViewPresenter(ApiAsync api, HandlerManager eventBus,
	LocationDetailsView<Location> view)
{
	this.api = api;
	this.eventBus = eventBus;
	this.view = view;
	this.view.setPresenter(this);
}

@Override
public void go(HasWidgets container)
{
	// TODO Auto-generated method stub
}

public void setCurrentLocation(Location l)
{
	this.view.setLocationName(l.getLocationName());
	this.view.setLocationRegion(l.getRegion());
	this.view.setLocationStreet(l.getStreet());
}


}
