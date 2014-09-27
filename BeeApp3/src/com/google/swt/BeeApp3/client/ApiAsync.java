package com.google.swt.BeeApp3.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.swt.BeeApp3.shared.model.Apiary;
import com.google.swt.BeeApp3.shared.model.Hive;
import com.google.swt.BeeApp3.shared.model.Location;

public interface ApiAsync
{

	void addNewApiary(Apiary apiary, AsyncCallback<String> callback);

	void addNewHive(Hive hive, AsyncCallback<String> callback);

	void addNewLocation(Location locations, AsyncCallback<String> callback);

	void deleteApiary(String[] apiarysToDelete, AsyncCallback<String> callback);

	void deleteHive(String[] hiveToDelete, AsyncCallback<String> callback);

	void getApiaryList(AsyncCallback<Apiary[]> callback);

	void getHiveList(AsyncCallback<Hive[]> callback);

	void getLocationList(AsyncCallback<Location[]> callback);

	void persistApiary(Apiary apiary, AsyncCallback<String> callback);

	void persistHive(Hive hive, AsyncCallback<String> callback);

	void persistLocation(Location location, AsyncCallback<String> callback);

	void deleteLocation(Location locationToDelete, AsyncCallback<String> callback);

}
