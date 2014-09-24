package com.google.swt.BeeApp3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
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
import com.google.swt.BeeApp3.client.view.HiveEditView;
import com.google.swt.BeeApp3.client.view.HiveView;
import com.google.swt.BeeApp3.client.event.HiveAddEvent;
import com.google.swt.BeeApp3.client.event.HiveAddEventHandler;
import com.google.swt.BeeApp3.client.event.HiveUpdatedEvent;
import com.google.swt.BeeApp3.client.event.HiveUpdatedEventHandler;
import com.google.swt.BeeApp3.client.event.LocationAddEvent;
import com.google.swt.BeeApp3.client.event.LocationAddEventHandler;
import com.google.swt.BeeApp3.client.view.Apiary.ApiaryView;
import com.google.swt.BeeApp3.client.view.Apiary.SampleViewImpl;
import com.google.swt.BeeApp3.client.view.Hive.HiveMainView;
import com.google.swt.BeeApp3.client.view.Location.LocationTab;
import com.google.swt.BeeApp3.client.view.Location.LocationView;
import com.google.swt.BeeApp3.client.view.Location.LocationViewImpl;
import com.google.swt.BeeApp3.shared.model.Hive;
import com.google.swt.BeeApp3.shared.model.Location;

public class AppController implements Presenter, ValueChangeHandler<String>
{
	private HasWidgets currentContainer;
	private final HandlerManager eventBus;
	private final ApiAsync hiveApi;

//	private Composite company;
//	private Composite apiary;
//	private Composite hive;
//	private Composite colony;
//	private Composite dashboard;
//	private Composite other;
//	private Composite location;
	private TabLayoutPanel tabPanel;
	
	private LocationViewImpl<Location> locationView =null;

	public AppController(ApiAsync hiveApi, HandlerManager eventBus)
	{
		this.hiveApi = hiveApi;
		this.eventBus = eventBus;
		bind();
	//	mainTabLayout();
	}

	private void bind()
	{
		History.addValueChangeHandler(this);

	    eventBus.addHandler(LocationAddEvent.TYPE,
	        new LocationAddEventHandler() {
				public void onAddLocation(LocationAddEvent locationAddEvent)
				{
					doAddNewLocation();	
				}
	          
	        });  
	}

	private void doAddNewLocation() {
		    History.newItem("add");
		  }
	
	private void mainTabLayout()
	{
		// Create a tab panel
		this.tabPanel = new TabLayoutPanel(2.5, Unit.EM);
		tabPanel.setAnimationDuration(500);
		tabPanel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);

	//	this.colony = new HiveView();
	//	this.company = new HiveView();
	//	this.apiary =  new ApiaryView();
	//	this.dashboard = new HiveView();
	//	this.other = new SampleViewImpl();
	//	this.location = new LocationViewImpl<Location>();
		this.locationView = new LocationViewImpl<Location>();
		
	//	this.hive = new HiveMainView();
		
		
	//	tabPanel.add(this.dashboard,"Dashboard");
	//	tabPanel.add(this.company,"Company");
		tabPanel.add(this.locationView,"Location");
	//	tabPanel.add(this.apiary,"Apiary");
	//	tabPanel.add(this.hive,"Hive");
	//	tabPanel.add(this.colony,"Colony");
	//	tabPanel.add(this.other,"Other");
	
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

		 if (token != null) {
		      if (token.equals("list")) {
		        GWT.runAsync(new RunAsyncCallback() {
		          public void onFailure(Throwable caught) {
		          }
		      
		          public void onSuccess() {
		            // lazily initialize our views, and keep them around to be reused
		            //
		            if (locationView == null) {
		            	locationView = new LocationViewImpl<Location>();
		              
		            }
		            new LocationPresenter(hiveApi, eventBus, locationView)
		            .go(currentContainer);
		          }
		        });
		      }
		      else if (token.equals("add") || token.equals("edit")) {
		        GWT.runAsync(new RunAsyncCallback() {
		          public void onFailure(Throwable caught) {
		          }
		      
		          public void onSuccess() {
		            // lazily initialize our views, and keep them around to be reused
		            //
		         //   if (editContactView == null) {
		          //    editContactView = new EditContactView();
		              
		        //    }
		        //    new EditContactPresenter(rpcService, eventBus, editContactView).
		         //   go(container);
		          }
		        });
		      }
		    }

	}

}
