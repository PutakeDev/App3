package com.google.swt.BeeApp3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BeeApp3 implements EntryPoint
{

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad()
	{
		ApiAsync hiveApi = GWT.create(Api.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(hiveApi, eventBus);

		appViewer.go(RootPanel.get());

		//CreatTempObjects temp = new CreatTempObjects(hiveApi);
		//temp.locations();

		// appViewer.go(RootPanel.get());

		// CreatTempObjects temp = new CreatTempObjects(hiveApi);
		// temp.locations();

	}
}
