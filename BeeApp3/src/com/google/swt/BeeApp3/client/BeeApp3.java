package com.google.swt.BeeApp3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BeeApp3 implements EntryPoint
{

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		ApiAsync hiveApi = GWT.create(Api.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(hiveApi, eventBus);
<<<<<<< HEAD
		appViewer.go(RootPanel.get());

		CreatTempObjects temp = new CreatTempObjects(hiveApi);
		temp.locations();
=======
		//appViewer.go(RootPanel.get());

		// CreatTempObjects temp = new CreatTempObjects(hiveApi);
		// temp.locations();
>>>>>>> refs/remotes/origin/master
	}
}
