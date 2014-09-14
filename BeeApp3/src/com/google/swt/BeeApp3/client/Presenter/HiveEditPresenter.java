package com.google.swt.BeeApp3.client.Presenter;

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
import com.google.swt.BeeApp3.client.view.HiveEditView;
import com.google.swt.BeeApp3.client.event.HiveAddEvent;
import com.google.swt.BeeApp3.client.event.HiveEditCancelEvent;
import com.google.swt.BeeApp3.client.event.HiveUpdatedEvent;
import com.google.swt.BeeApp3.shared.model.Hive;

public class HiveEditPresenter implements Presenter
{
	public interface Display
	{
		Widget asWidget();

		HasValue<String> getBarcode();

		HasClickHandlers getCancelButton();

		HasValue<String> getHiveName();

		HasValue<String> getLocation();

		HasValue<String> getRFID();

		HasClickHandlers getSaveButton();
	}

	private final Display display;
	private final HandlerManager eventBus;
	private Hive hive;
	private final ApiAsync hiveApi;

	public HiveEditPresenter(ApiAsync hiveApi, HandlerManager eventBus,
			Display display)
	{
		this.hiveApi = hiveApi;
		this.eventBus = eventBus;
		this.hive = new Hive();
		this.display = display;
		bind();
	}

	public void bind()
	{
		this.display.getSaveButton().addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				doSave();
			}
		});

		this.display.getCancelButton().addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				eventBus.fireEvent(new HiveEditCancelEvent(event.toString()));
			}
		});
	}

	private void doSave()
	{
		this.hive.setName(display.getHiveName().getValue());
		this.hive.setRFID(display.getRFID().getValue());
		this.hive.setBarcode(display.getBarcode().getValue());

		this.hiveApi.addNewHive(hive, new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught)
			{
				Window.alert("Error updating contact");
			}

			public void onSuccess(String result)
			{
				eventBus.fireEvent(new HiveUpdatedEvent(hive));
			}
		});
	}

	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(display.asWidget());

	}

}
