package com.google.swt.BeeApp3.client.Presenter;

import java.util.ArrayList;
import java.util.List;

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
import com.google.swt.BeeApp3.shared.model.Hive;

public class HivePresenter implements Presenter
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

	private Hive[] hives;

	public HivePresenter(ApiAsync api, HandlerManager eventBus, Display display)
	{

		this.api = api;
		this.eventBus = eventBus;
		this.display = display;
	}

	public void bind()
	{
		display.getAddButton().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				eventBus.fireEvent(new HiveAddEvent());
			}
		});

		display.getDeleteButton().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				// deleteSelectedContacts();
				// TODO implement
			}
		});

		display.getList().addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				int selectedRow = display.getClickedRow(event);

				if (selectedRow >= 0)
				{
					String id = hives[selectedRow].getId();
					eventBus.fireEvent(new HiveEditEvent(id));
				}
			}
		});
	}

	private void fetchHiveDetails()
	{
		api.getHiveList(new AsyncCallback<Hive[]>()
		{
			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("Error fetching hive details");
				Hive temp = new Hive();
				temp.setName("Dummy hive");
				temp.setNumber("12345");
				List<String> data = new ArrayList<String>();
				data.add(temp.getDisplayName());
				display.setData(data);
			}

			@Override
			public void onSuccess(Hive[] result)
			{
				hives = result;
				List<String> data = new ArrayList<String>();

				for (int i = 0; i < result.length; ++i)
				{
					data.add(hives[i].getDisplayName());
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
		fetchHiveDetails();

	}

}
