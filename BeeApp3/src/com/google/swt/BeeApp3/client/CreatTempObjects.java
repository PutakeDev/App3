package com.google.swt.BeeApp3.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.swt.BeeApp3.shared.model.Location;

public class CreatTempObjects
{

	private final ApiAsync api;

	public CreatTempObjects(ApiAsync a)
	{
		this.api = a;
	}

	public void locations()
	{
		Location l = new Location();
		l.setCountry("New Zealand");
		l.setLocationName("Name of Location 1");
		l.setCity("Blenheim");
		l.setRegion("North of South Island");

		Location l2 = new Location();
		l2.setCountry("New Zealand");
		l2.setLocationName("Name of Location 2");
		l2.setCity("Nelson");
		l2.setRegion("North of South Island");

		Location l3 = new Location();
		l3.setCountry("New Zealand");
		l3.setLocationName("Name of Location 3");
		l3.setCity("Auckland");
		l3.setRegion("North Island");

		this.api.persistLocation(l, new AsyncCallback<String>()
		{
			@Override
			public void onFailure(Throwable caught)
			{
			}

			@Override
			public void onSuccess(String result)
			{
			}
		});
		this.api.persistLocation(l2, new AsyncCallback<String>()
		{
			@Override
			public void onFailure(Throwable caught)
			{
			}

			@Override
			public void onSuccess(String result)
			{
			}
		});
		this.api.persistLocation(l3, new AsyncCallback<String>()
		{
			@Override
			public void onFailure(Throwable caught)
			{
			}

			@Override
			public void onSuccess(String result)
			{
			}
		});

	}

}
