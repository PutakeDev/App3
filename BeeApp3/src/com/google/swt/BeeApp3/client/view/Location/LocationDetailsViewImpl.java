package com.google.swt.BeeApp3.client.view.Location;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.Presenter.LocationDetailsViewPresenter;
import com.google.swt.BeeApp3.client.view.Location.LocationView.Presenter;
import com.google.swt.BeeApp3.client.view.Location.LocationViewImpl.LocationViewUiBinder;
import com.google.swt.BeeApp3.shared.model.Location;

public class LocationDetailsViewImpl<T> extends Composite implements LocationDetailsView<T>

{
	@UiTemplate("LocationDetailsView.ui.xml")
	interface LocationDetailsViewUiBinder extends UiBinder<Widget, LocationDetailsViewImpl>
	{
	}

	private Presenter<Location> presenter;
	
	private static LocationDetailsViewUiBinder uiBinder = GWT
			.create(LocationDetailsViewUiBinder.class);
	public LocationDetailsViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget()
	{
		return this;
	}
	@Override
	public void setPresenter(
			LocationDetailsViewPresenter locationViewDetailsPresenter)
	{
		this.presenter = locationViewDetailsPresenter;
		
	}

}


