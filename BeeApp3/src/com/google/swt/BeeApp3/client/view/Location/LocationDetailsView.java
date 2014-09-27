package com.google.swt.BeeApp3.client.view.Location;

import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.Presenter.LocationDetailsViewPresenter;


public interface LocationDetailsView<T>
{

	public interface Presenter<T>
	{
		
	}
	Widget asWidget();
	void setPresenter(LocationDetailsViewPresenter locationViewDetailsPresenter);


}
