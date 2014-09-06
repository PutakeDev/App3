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
import com.google.swt.BeeApp3.shared.model.Hive;
import com.google.swt.BeeApp3.shared.model.Location;

public class LocationPresenter implements Presenter
{
	public interface Display extends HasValue<List<String>>
	{
		Widget asWidget();

		HasClickHandlers getAddButton();

		int getClickedRow(ClickEvent event);

		HasClickHandlers getDeleteButton();

		HasClickHandlers getList();

		List<Integer> getSelectedRows();

		void setData(List<String> data);
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
		display.getAddButton().addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				eventBus.fireEvent(new LocationAddEvent());
			}
		});

		display.getDeleteButton().addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				// deleteSelectedContacts();
				// TODO implement
			}
		});

		display.getList().addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				int selectedRow = display.getClickedRow(event);

				if (selectedRow >= 0)
				{
					String id = locations[selectedRow].getId();
					eventBus.fireEvent(new LocationEditEvent(id));
				}
			}
		});
	}

	private void fetchLocationDetails()
	{
		api.getLocationList(new AsyncCallback<Location[]>()
		{
			public void onFailure(Throwable caught)
			{
				Window.alert("Error fetching location details");
			}

			public void onSuccess(Location[] result)
			{
				locations = result;
				List<String> data = new ArrayList<String>();

				for (int i = 0; i < result.length; ++i)
				{
					data.add(locations[i].getDisplayName());
				}

				display.setData(data);
			}
		});
	}

	@Override
	public void go(HasWidgets container)
	{
		bind();
		container.clear();
		container.add(display.asWidget());
		fetchLocationDetails();

	}

}
