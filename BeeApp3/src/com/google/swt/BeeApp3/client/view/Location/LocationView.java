package com.google.swt.BeeApp3.client.view.Location;

import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.event.LocationAddEvent;
import com.google.swt.BeeApp3.shared.model.Location;

public interface LocationView<T>
{

	public interface Presenter<T>
	{
		void onDeleteButtonClicked();

		void onItemClicked(T clickedItem);

		void onItemSelected(T selectedItem);

		void addLocation(Location l);

		void deleteLocation(Location l);
		
	}

	Widget asWidget();

	void setPresenter(Presenter<T> presenter);

	void setRowData(Location[] rowData);

	void setStatusLabelText(String t);
	
	void setLocationDetailsView(LocationDetailsView<Location> locationDetailsView);
}
