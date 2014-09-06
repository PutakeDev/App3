package com.google.swt.BeeApp3.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.DockPanel.DockLayoutConstant;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.Presenter.HiveEditPresenter;
import com.google.swt.BeeApp3.client.Presenter.HivePresenter;
import com.google.swt.BeeApp3.client.Presenter.LocationPresenter;
import com.google.swt.BeeApp3.client.Presenter.Presenter;
import com.google.swt.BeeApp3.client.event.HiveAddEvent;
import com.google.swt.BeeApp3.client.event.HiveAddEventHandler;
import com.google.swt.BeeApp3.client.event.HiveUpdatedEvent;
import com.google.swt.BeeApp3.client.event.HiveUpdatedEventHandler;
import com.google.swt.BeeApp3.client.view.HiveEditView;
import com.google.swt.BeeApp3.client.view.HiveView;
import com.google.swt.BeeApp3.client.view.LocationTab;
import com.google.swt.BeeApp3.client.view.LocationView;
import com.google.swt.BeeApp3.shared.model.Hive;

public class AppController implements Presenter, ValueChangeHandler<String>
{
	private HasWidgets currentContainer;
	private final HandlerManager eventBus;
	private final ApiAsync hiveApi;

	private Composite company;
	private Composite apiary;
	private Composite hive;
	private Composite colony;
	private Composite dashboard;
	private Composite other;
	private TabLayoutPanel tabPanel;

	public AppController(ApiAsync hiveApi, HandlerManager eventBus)
	{
		this.hiveApi = hiveApi;
		this.eventBus = eventBus;
		bind();
		mainTabLayout();
	}

	private void bind()
	{
		History.addValueChangeHandler(this);
		eventBus.addHandler(HiveAddEvent.TYPE, new HiveAddEventHandler()
		{
			@Override
			public void onAddHive(HiveAddEvent hiveAddEvent)
			{
				doAddNewHive();
			}

		});
		eventBus.addHandler(HiveUpdatedEvent.TYPE,
				new HiveUpdatedEventHandler()
				{

					@Override
					public void onHiveUpdated(HiveUpdatedEvent event)
					{
						History.newItem("updated");
					}

				});
	}

	private void mainTabLayout()
	{
		// Create a tab panel
		this.tabPanel = new TabLayoutPanel(2.5, Unit.EM);
		tabPanel.setAnimationDuration(500);
		tabPanel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);

		this.colony = new HiveView();
		this.company = new HiveView();
		this.apiary =  new HiveView();
		this.dashboard = new HiveView();
		this.other = new HiveView();
		
		this.hive = new HiveView();
		
		
		tabPanel.add(this.dashboard,"Dashboard");
		tabPanel.add(this.company,"Company");
		tabPanel.add(this.company,"Company");
		tabPanel.add(this.apiary,"Apiary");
		tabPanel.add(this.hive,"Hive");
		tabPanel.add(this.colony,"Colony");
		tabPanel.add(this.other,"Other");
	
		//tabPanel.add(c1,"label");
	
		DockPanel mainDP = new DockPanel();
		
		
		FlowPanel fp = new FlowPanel();
		Label title = new Label("Bee App Beta", false);
		fp.add(title);
		fp.setPixelSize(1000, 20);
		
	
		mainDP.add(fp,DockPanel.NORTH);
		mainDP.add(tabPanel,DockPanel.CENTER);
		
		RootLayoutPanel.get().clear();
		RootLayoutPanel.get().add(tabPanel);

	}

	private void doAddNewHive()
	{
		History.newItem("add");
	}

	public void go(final HasWidgets container)
	{
		this.currentContainer = container;

		if ("".equals(History.getToken()))
		{
			History.newItem("list");
		}
		else
		{
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event)
	{
		String token = event.getValue();

		if (token != null)
		{
			Presenter presenter = null;
			if (token.equals("add"))
			{
				presenter = new HiveEditPresenter(hiveApi, eventBus,
						new HiveEditView());
			}
			if (token.equals("updated"))
			{
				presenter = new HivePresenter(hiveApi, eventBus, new HiveView());
			}
			if (token.equals("list"))
			{
				presenter = new HivePresenter(hiveApi, eventBus, new HiveView());
			}
			if (token.equals("location1"))
			{
				presenter = new LocationPresenter(hiveApi, eventBus,
						new LocationView());
			}
			if (token.equals("location2"))
			{
				presenter = new HivePresenter(hiveApi, eventBus, new HiveView());
			}
			if (presenter != null)
			{
				presenter.go(currentContainer);
			}
		}

	}

}
