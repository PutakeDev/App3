package com.google.swt.BeeApp3.client.view.Location;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.Presenter.HivePresenter;
import com.google.swt.BeeApp3.client.Presenter.LocationPresenter;
import com.google.swt.BeeApp3.client.event.LocationAddEvent;
import com.google.swt.BeeApp3.shared.model.Location;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.widget.client.TextButton;
import com.google.gwt.uibinder.client.UiHandler;

public class LocationViewImpl<T> extends Composite implements LocationView<T>

{

	@UiTemplate("LocationView.ui.xml")
	  interface LocationViewUiBinder extends UiBinder<Widget, LocationViewImpl> {}
	  private static LocationViewUiBinder uiBinder = GWT.create(LocationViewUiBinder.class);
	
	  @UiField TextButton CreateLocationButton;
	  @UiField TextBox locationName;
	  @UiField TextBox region;
	  @UiField TextBox street;
	  @UiField TextBox city;
	  @UiField TextBox postCode;
	  @UiField TextBox Country;
	  @UiField Label statusLabel;
	  @UiField ListBox LocationList;
	  
	  private Presenter<T> presenter;
	  private Location[] rowData;
	
	  
	public LocationViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	
	public void setStatusLabelText(String t)
	{
		this.statusLabel.setText(t);
	}
	
	@Override
	public void onLocationAdded(LocationAddEvent event)
	{
		this.setStatusLabelText("Location added");
	}

	@Override
	public void setPresenter(Presenter<T> presenter)
	{
		this.presenter = presenter;
	}
	
	  @UiHandler("CreateLocationButton")
	  void onAddButtonClicked(ClickEvent event) {
	    if (presenter != null) {
	      presenter.onAddButtonClicked();
	      this.statusLabel.setText(this.locationName.getText());
	    }
	    this.CreateLocationButton.setText("pressed");
	  }
	
	  private void doCreateNewLocation()
	  {
		  Location l = new Location();
		  l.setLocationName(this.locationName.getText());
		  l.setRegion(this.region.getText());
		  l.setStreet(this.street.getText());
		  l.setCity(this.city.getText());
		  l.setCountry(this.Country.getText());
	  }
	  
	  
	  @Override	
	public void setRowData(Location[] rowData)
	{
		this.rowData =  rowData;
		for(int i = 0; i<this.rowData.length; i++)
		{
		this.LocationList.addItem(this.rowData[i].getDisplayName());
		}
		
	}
	
	  public Widget asWidget() {
		    return this;
		  }
}
