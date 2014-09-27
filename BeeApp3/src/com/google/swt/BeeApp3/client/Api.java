package com.google.swt.BeeApp3.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.swt.BeeApp3.shared.model.Apiary;
import com.google.swt.BeeApp3.shared.model.Hive;
import com.google.swt.BeeApp3.shared.model.Location;

@RemoteServiceRelativePath("api")
public interface Api extends RemoteService
{
	String addNewApiary(Apiary apiary);

	String addNewHive(Hive hive);

	String addNewLocation(Location location);

	String deleteApiary(String[] apiarysToDelete);

	String deleteHive(String[] hiveToDelete);

	Apiary[] getApiaryList();

	Hive[] getHiveList();

	Location[] getLocationList();

	String persistApiary(Apiary apiary);

	String persistHive(Hive hive);

	String persistLocation(Location location);

	String deleteLocation(Location locationToDelete);
}
