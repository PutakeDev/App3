package com.google.swt.BeeApp3.client.Presenter;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.Arrays;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.swt.BeeApp3.client.ApiAsync;
import com.google.swt.BeeApp3.client.event.LocationAddEvent;
import com.google.swt.BeeApp3.client.view.Location.LocationDetailsView;
import com.google.swt.BeeApp3.client.view.Location.LocationDetailsViewImpl;
import com.google.swt.BeeApp3.client.view.Location.LocationView;
import com.google.swt.BeeApp3.shared.model.Location;

public class LocationPresenter implements Presenter,
		LocationView.Presenter<Location>
{
	private final ApiAsync api;
	private final HandlerManager eventBus;
	private Location[] locations;
	private final LocationView<Location> view;
	
	 
	private final LocationDetailsView<Location> locationDetailsView;
	private LocationDetailsViewPresenter detailViewPresenter;

	public LocationPresenter(ApiAsync api, HandlerManager eventBus,
			LocationView<Location> view)
	{
		this.api = api;
		this.eventBus = eventBus;
		this.view = view;
		this.view.setPresenter(this);
		
		this.locationDetailsView = new LocationDetailsViewImpl<Location>();
		this.detailViewPresenter = new LocationDetailsViewPresenter(this.api,this.eventBus,this.locationDetailsView);
		this.view.setLocationDetailsView(this.locationDetailsView);
	}

	
	@Override
	public void addLocation(Location l)
	{
		this.api.addNewLocation(l,new AsyncCallback<String>()
		{
			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("Error saving location");
			}

			@Override
			public void onSuccess(String result)
			{
				String s = result;
				//Window.alert("Location added -- " + result);
				eventBus.fireEvent(new LocationAddEvent());
				view.setStatusLabelText("New location has been added");
				fetchLocationDetails();
			}
		});
	}

	@Override
	public void deleteLocation(Location l)
	{
		this.api.deleteLocation(l, new AsyncCallback<String>()
		{

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("Error removing location");				
			}

			@Override
			public void onSuccess(String result)
			{
				String s = result;
				//Window.alert("Location added -- " + result);
				eventBus.fireEvent(new LocationAddEvent());
				view.setStatusLabelText("location has been removed");
				fetchLocationDetails();
				
			}
		});
	}
	
	
	public void bind()
	{

	}
	
	private void fetchLocationDetails()
	{
		this.api.getLocationList(new AsyncCallback<Location[]>()
		{
			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("Error fetching contact details");
			}

			@Override
			public void onSuccess(Location[] result)
			{
				locations = result;
				Arrays.sort(locations,Location.LocationNameComparator);
				view.setRowData(locations);
			}
		});
	}

	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.asWidget());
		fetchLocationDetails();
	}

	@Override
	public void onDeleteButtonClicked()
	{
	}

	@Override
	public void onItemClicked(Location clickedItem)
	{
		this.detailViewPresenter.setCurrentLocation(clickedItem);

	}

	@Override
	public void onItemSelected(Location selectedItem)
	{
		// TODO Auto-generated method stub

	}
}
