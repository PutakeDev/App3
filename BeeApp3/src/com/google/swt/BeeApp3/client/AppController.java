package com.google.swt.BeeApp3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.swt.BeeApp3.client.Presenter.LocationPresenter;
import com.google.swt.BeeApp3.client.Presenter.Presenter;
import com.google.swt.BeeApp3.client.event.LocationAddEvent;
import com.google.swt.BeeApp3.client.event.LocationAddEventHandler;
import com.google.swt.BeeApp3.client.view.Location.LocationView;
import com.google.swt.BeeApp3.client.view.Location.LocationViewImpl;
import com.google.swt.BeeApp3.shared.model.Location;

public class AppController implements Presenter, ValueChangeHandler<String>
{
	private HasWidgets currentContainer;
	private final HandlerManager eventBus;
	private final ApiAsync hiveApi;
	private LocationPresenter locationPresenter;
//	private LocationViewImpl locationView;
	// private Composite company;
	// private Composite apiary;
	// private Composite hive;
	// private Composite colony;
	// private Composite dashboard;
	// private Composite other;
	// private Composite location;
	private TabLayoutPanel tabPanel;

	public AppController(ApiAsync hiveApi, HandlerManager eventBus)
	{
		this.hiveApi = hiveApi;
		this.eventBus = eventBus;
		this.initLocationViews();
		bind();
		// mainTabLayout();
	}

	private void initLocationViews()
	{
		LocationViewImpl locationView = new LocationViewImpl<Location>();
		this.locationPresenter = new LocationPresenter(hiveApi, eventBus, locationView);
	}
	
	private void bind()
	{
		History.addValueChangeHandler(this);
		eventBus.addHandler(LocationAddEvent.TYPE,
				new LocationAddEventHandler()
				{
					@Override
					public void onAddLocation(LocationAddEvent locationAddEvent)
					{
						doAddNewLocation(locationAddEvent);
					}
				});
	}

	private void doAddNewLocation(LocationAddEvent event)
	{
		History.newItem("add");
	}

	@Override
	public void go(final HasWidgets container)
	{
		this.currentContainer = container;
		if ("".equals(History.getToken()))
		{
			History.newItem("Location");
		}
		else
		{
			History.fireCurrentHistoryState();
		}
	}

	private void mainTabLayout()
	{
		// Create a tab panel
		this.tabPanel = new TabLayoutPanel(2.5, Unit.EM);
		tabPanel.setAnimationDuration(500);
		tabPanel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);
		// this.colony = new HiveView();
		// this.company = new HiveView();
		// this.apiary = new ApiaryView();
		// this.dashboard = new HiveView();
		// this.other = new SampleViewImpl();
		// this.location = new LocationViewImpl<Location>();
		//this.locationView = new LocationViewImpl<Location>();
		// this.hive = new HiveMainView();
		// tabPanel.add(this.dashboard,"Dashboard");
		// tabPanel.add(this.company,"Company");
		//tabPanel.add(this.locationView, "Location");
		// tabPanel.add(this.apiary,"Apiary");
		// tabPanel.add(this.hive,"Hive");
		// tabPanel.add(this.colony,"Colony");
		// tabPanel.add(this.other,"Other");
		// tabPanel.add(c1,"label");
		DockPanel mainDP = new DockPanel();
		FlowPanel fp = new FlowPanel();
		Label title = new Label("Bee App Beta", false);
		fp.add(title);
		fp.setPixelSize(1000, 20);
		mainDP.add(fp, DockPanel.NORTH);
		mainDP.add(tabPanel, DockPanel.CENTER);
		RootLayoutPanel.get().clear();
		RootLayoutPanel.get().add(tabPanel);
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event)
	{
		String token = event.getValue();
		if (token != null)
		{
			if (token.equals("Location"))
			{
				GWT.runAsync(new RunAsyncCallback()
				{
					@Override
					public void onFailure(Throwable caught)
					{
					}

					@Override
					public void onSuccess()
					{
						locationPresenter.go(currentContainer);
					}
				});
			}
			else
				if (token.equals("add") || token.equals("edit"))
				{
					GWT.runAsync(new RunAsyncCallback()
					{
						@Override
						public void onFailure(Throwable caught)
						{
						}

						@Override
						public void onSuccess()
						{
							// lazily initialize our views, and keep them around
							// to be reused
							//
							// if (editContactView == null) {
							// editContactView = new EditContactView();
							// }
							// new EditContactPresenter(rpcService, eventBus,
							// editContactView).
							// go(container);
						}
					});
				}
		}

	}
}
