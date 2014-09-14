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

public class LocationPresenter implements Presenter, LocationView.Presenter
{
	public interface Display extends HasValue<List<String>>
	{
		Widget asWidget();

		HasClickHandlers getAddButton();

	}

	private final ApiAsync api;
	private final Display display;
	private final HandlerManager eventBus;

	private Location[] locations;

	public LocationPresenter(ApiAsync api, HandlerManager eventBus,
			Display display)
	{

		this.api = api;
		this.eventBus = eventBus;
		this.display = display;
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
		bind();
		container.clear();
		container.add(display.asWidget());
	}

	@Override
	public void onAddButtonClicked(Location l)
	{
		
		api.addNewLocation(l,  new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught)
			{
			}

			public void onSuccess(String result)
			{
				//setStatusLabelText("Location added");
				
			}
		});
		eventBus.fireEvent(new LocationAddEvent());
		
	}

	@Override
	public void onDeleteButtonClicked()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemClicked(Object clickedItem)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemSelected(Object selectedItem)
	{
		// TODO Auto-generated method stub
		
	}

}
