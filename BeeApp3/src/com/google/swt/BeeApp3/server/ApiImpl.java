package com.google.swt.BeeApp3.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.swt.BeeApp3.client.Api;
import com.google.swt.BeeApp3.shared.model.Apiary;
import com.google.swt.BeeApp3.shared.model.Hive;
import com.google.swt.BeeApp3.shared.model.Location;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

@SuppressWarnings("serial")
public class ApiImpl extends RemoteServiceServlet implements Api
{

	/**
	 * 
	 */

	private final PersistenceManagerFactory pmf = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	public ApiImpl()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addNewApiary(Apiary apiary)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(apiary);
		pm.close();
		return apiary.getId();
	}

	public String addNewHive(Hive newHive)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(newHive);
		pm.close();
		return newHive.getId();
	}

	@Override
	public String addNewLocation(Location location)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(location);
		pm.close();
		return location.getId();
	}

	@Override
	public String deleteApiary(String[] apiarysToDelete)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteHive(String[] hiveToDelete)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLocation(String[] locationsToDelete)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Apiary[] getApiaryList()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		List<Apiary> apiaries = null;

		List<Apiary> persistedApiaries = getPersistedApiaries(pm);

		apiaries = (List<Apiary>) pm.detachCopyAll(persistedApiaries);
		pm.close();

		return apiaries.toArray(new Apiary[0]);
	}

	@Override
	public Hive[] getHiveList()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		List<Hive> hives = null;

		List<Hive> persistedHives = getPersistedHives(pm);

		hives = (List<Hive>) pm.detachCopyAll(persistedHives);
		pm.close();

		return hives.toArray(new Hive[0]);
	}

	@Override
	public Location[] getLocationList()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		List<Location> locations = null;

		List<Location> persistedLocations = getPersistedLocations(pm);

		locations = (List<Location>) pm.detachCopyAll(persistedLocations);
		pm.close();

		return locations.toArray(new Location[0]);
	}

	@SuppressWarnings("unchecked")
	private List<Apiary> getPersistedApiaries(PersistenceManager pm)
	{
		Query q = pm.newQuery(Hive.class);

		return ((List<Apiary>) q.execute());

	}

	@SuppressWarnings("unchecked")
	private List<Hive> getPersistedHives(PersistenceManager pm)
	{
		Query q = pm.newQuery(Hive.class);

		List<Hive> persistedHives = ((List<Hive>) q.execute());
		return persistedHives;
	}

	@SuppressWarnings("unchecked")
	private List<Location> getPersistedLocations(PersistenceManager pm)
	{
		Query q = pm.newQuery(Location.class);

		return ((List<Location>) q.execute());
	}

	@Override
	public String persistApiary(Apiary apiary)
	{
		return this.addNewApiary(apiary);
	}

	@Override
	public String persistHive(Hive hive)
	{

		return persistNewHive(hive);

	}

	@Override
	public String persistLocation(Location location)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(location);
		pm.close();
		return location.getId();
	}

	private String persistNewHive(Hive newHive)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(newHive);
		pm.close();
		return newHive.getId();
	}

	private String updateExistingHive(Hive existingHive)
	{
		String hiveId = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		try
		{
			((javax.jdo.Transaction) tx).begin();
			Hive managedHive = (Hive) pm.getObjectById(Hive.class,
					existingHive.getId());
			if (managedHive != null)
			{

				managedHive.setName(existingHive.getName());
				managedHive.setRFID(existingHive.getRFID());
				hiveId = managedHive.getId();
			}
			((javax.jdo.Transaction) tx).commit();
		}
		catch (Exception e)
		{
			if (((javax.jdo.Transaction) tx).isActive())
			{
				((javax.jdo.Transaction) tx).rollback();
			}
		}
		finally
		{
			pm.close();
		}
		return hiveId;
	}

}
