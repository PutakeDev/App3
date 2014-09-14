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
	  @UiField Label statusLabel;
	
	  private Presenter<T> presenter;
	  private List<T> rowData;
	
	  
	public LocationViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	

	@UiHandler("CreateLocationButton")
	void onCreateLocationButtonClick(ClickEvent event) {
	    if (presenter != null) {
	    	Location l = new Location();
	    	l.setLocationName(this.locationName.getText());	    	
	        presenter.onAddButtonClicked(l);
	      }
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
	public void setPresenter(
			com.google.swt.BeeApp3.client.view.Location.LocationView.Presenter<T> presenter)
	{
		this.presenter = presenter;
	}
	

	@Override
	public void setRowData(List<T> rowData)
	{
		// TODO Auto-generated method stub
		
	}
	
	  public Widget asWidget() {
		    return this;
		  }
}
