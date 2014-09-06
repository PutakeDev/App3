package com.google.swt.BeeApp3.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.Presenter.*;

;

public class HiveEditView extends Composite implements
		HiveEditPresenter.Display
{
	private final TextBox barcode;
	private final Button cancelButton;
	private final FlexTable detailsTable;
	private final TextBox hiveName;
	private final TextBox location;
	private final TextBox rfid;
	private final Button saveButton;

	public HiveEditView()
	{
		DecoratorPanel contentDetailsDecorator = new DecoratorPanel();
		contentDetailsDecorator.setWidth("18em");
		initWidget(contentDetailsDecorator);

		VerticalPanel contentDetailsPanel = new VerticalPanel();
		contentDetailsPanel.setWidth("100%");

		// Create the contacts list
		//
		detailsTable = new FlexTable();
		detailsTable.setCellSpacing(0);
		detailsTable.setWidth("100%");
		detailsTable.addStyleName("contacts-ListContainer");
		detailsTable.getColumnFormatter().addStyleName(1, "add-contact-input");
		hiveName = new TextBox();
		location = new TextBox();
		barcode = new TextBox();
		rfid = new TextBox();
		initDetailsTable();
		contentDetailsPanel.add(detailsTable);

		HorizontalPanel menuPanel = new HorizontalPanel();
		saveButton = new Button("Save");
		cancelButton = new Button("Cancel");
		menuPanel.add(saveButton);
		menuPanel.add(cancelButton);
		contentDetailsPanel.add(menuPanel);
		contentDetailsDecorator.add(contentDetailsPanel);
	}

	public Widget asWidget()
	{
		return this;
	}

	@Override
	public HasValue<String> getBarcode()
	{
		return this.barcode;
	}

	@Override
	public HasClickHandlers getCancelButton()
	{
		return this.cancelButton;
	}

	@Override
	public HasValue<String> getHiveName()
	{
		return this.hiveName;
	}

	@Override
	public HasValue<String> getLocation()
	{
		return this.location;
	}

	@Override
	public HasValue<String> getRFID()
	{
		return this.rfid;
	}

	@Override
	public HasClickHandlers getSaveButton()
	{
		return this.saveButton;
	}

	private void initDetailsTable()
	{
		detailsTable.setWidget(0, 0, new Label("Hive Name"));
		detailsTable.setWidget(0, 1, hiveName);
		detailsTable.setWidget(1, 0, new Label("Location"));
		detailsTable.setWidget(1, 1, location);
		detailsTable.setWidget(2, 0, new Label("Barcode"));
		detailsTable.setWidget(2, 1, barcode);
		detailsTable.setWidget(2, 0, new Label("RFID Tag"));
		detailsTable.setWidget(2, 1, rfid);
		hiveName.setFocus(true);
	}

}
