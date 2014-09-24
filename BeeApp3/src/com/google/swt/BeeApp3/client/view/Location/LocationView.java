package com.google.swt.BeeApp3.client.view.Location;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.event.LocationAddEvent;
import com.google.swt.BeeApp3.shared.model.Location;

public interface LocationView<T>
{

	  public interface Presenter<T> {
	    void onAddButtonClicked();
	    void onDeleteButtonClicked();
	    void onItemClicked(T clickedItem);
	    void onItemSelected(T selectedItem);
	  }
	  
	  void setPresenter(Presenter<T> presenter);

	  void setStatusLabelText(String t);
	  
	  void setRowData(Location[] rowData);
	  
	  void onLocationAdded(LocationAddEvent event);
	  	  
	  Widget asWidget();
	}