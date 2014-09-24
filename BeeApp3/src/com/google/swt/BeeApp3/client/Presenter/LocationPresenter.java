package com.google.swt.BeeApp3.client.Presenter;

import java.util.ArrayList;
import java.util.List;

import org.apache.jsp.ah.datastoreViewerBody_jsp;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.ApiAsync;
import com.google.swt.BeeApp3.client.event.HiveAddEvent;
import com.google.swt.BeeApp3.client.event.HiveEditEvent;
import com.google.swt.BeeApp3.client.event.LocationAddEvent;
import com.google.swt.BeeApp3.client.event.LocationEditEvent;
import com.google.swt.BeeApp3.client.view.Location.LocationView;
import com.google.swt.BeeApp3.shared.model.Hive;
import com.google.swt.BeeApp3.shared.model.Location;

public class LocationPresenter implements Presenter, LocationView.Presenter<Location>
{

	private final ApiAsync api;
	private final HandlerManager eventBus;
	private final LocationView<Location> view;
	
	private Location[] locations;

	public LocationPresenter(ApiAsync api, HandlerManager eventBus, LocationView<Location> view)
	{

		this.api = api;
		this.eventBus = eventBus;
		this.view = view;
		this.view.setPresenter(this);
	}

	public void bind()
	{
	//	display.getAddButton().addClickHandler(new ClickHandler()
	//	{
	//		public void onClick(ClickEvent event)
	//		{
	//			eventBus.fireEvent(new LocationAddEvent());
	//		}
	//	});
	}

	@Override
	public void go(HasWidgets container)
	{
	    container.clear();
	    container.add(view.asWidget());
	    fetchLocationDetails();
	}

	@Override
	public void onAddButtonClicked()
	{
		eventBus.fireEvent(new LocationAddEvent());
		this.view.setStatusLabelText("Add clicked");
	}

	@Override
	public void onDeleteButtonClicked()
	{
				
	}

	private void fetchLocationDetails()
	{
		this.api.getLocationList(
				
				new AsyncCallback<Location[]>() {
     
			
			
			
       
    
      
      public void onFailure(Throwable caught) {
        Window.alert("Error fetching contact details");
     

 }

	@Override
	public void onSuccess(Location[] result)
	{
		   locations = result;
	       view.setRowData(locations);
		
	}
    });
	}
	

	@Override
	public void onItemClicked(Location clickedItem)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemSelected(Location selectedItem)
	{
		// TODO Auto-generated method stub
		
	}

}
