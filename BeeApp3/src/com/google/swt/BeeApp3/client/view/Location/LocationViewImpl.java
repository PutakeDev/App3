package com.google.swt.BeeApp3.client.view.Location;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.widget.client.TextButton;
import com.google.swt.BeeApp3.client.Presenter.LocationPresenter;
import com.google.swt.BeeApp3.client.event.LocationAddEvent;
import com.google.swt.BeeApp3.shared.model.Location;

public class LocationViewImpl<T> extends Composite implements LocationView<T>

{

	@UiTemplate("LocationView.ui.xml")
	interface LocationViewUiBinder extends UiBinder<Widget, LocationViewImpl>
	{
	}

	private static LocationViewUiBinder uiBinder = GWT
			.create(LocationViewUiBinder.class);

	@UiField
	TextBox city;
	@UiField
	TextBox Country;
	@UiField
	TextButton CreateLocationButton;
	@UiField
	ListBox LocationList;
	@UiField
	TextBox locationName;
	@UiField
	TextBox postCode;
	private Presenter<Location> presenter;
	@UiField
	TextBox region;
	private Location[] rowData;

	@UiField
	Label statusLabel;
	@UiField
	TextBox street;
	@UiField
	TextButton deleteLocationButton;

	@UiField
	HTMLPanel TEMP;

	public LocationViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget()
	{
		return this;
	}

	private Location doCreateNewLocation()
	{
		Location l = new Location();
		l.setLocationName(this.locationName.getText());
		l.setRegion(this.region.getText());
		l.setStreet(this.street.getText());
		l.setCity(this.city.getText());
		l.setCountry(this.Country.getText());
		return l;
	}

	@UiHandler("CreateLocationButton")
	void onAddButtonClicked(ClickEvent event)
	{
		if (presenter != null)
		{
			presenter.addLocation(this.doCreateNewLocation());
		}

	}

	@Override
	public void setPresenter(Presenter<T> presenter)
	{
		this.presenter = (com.google.swt.BeeApp3.client.view.Location.LocationView.Presenter<Location>) presenter;
	}

	@Override
	public void setRowData(Location[] rowData)
	{
		this.LocationList.clear();
		this.rowData = rowData;
		for (int i = 0; i < this.rowData.length; i++)
		{
			this.LocationList.addItem(this.rowData[i].getDisplayName());
		}

	}

	@Override
	public void setStatusLabelText(String t)
	{
		this.statusLabel.setText(t);
	}

	@UiHandler("deleteLocationButton")
	public void onDeleteLocationButtonClick(ClickEvent event)
	{

		Location l = this.rowData[this.LocationList.getSelectedIndex()];

		if (presenter != null && l != null)
		{
			presenter.deleteLocation(l);
		}
	}
	@Override
	public void setLocationDetailsView(
			LocationDetailsView<Location> l)
	{
		// TODO Auto-generated method stub
		
		this.TEMP.add(l.asWidget());
		
	}
}
