package com.google.swt.BeeApp3.shared.model;

import java.util.Comparator;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * JDO persistable TaskData.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Location implements IsSerializable, Comparable<Location>
{

	private double[][] area;

	private String city;

	private String Country;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	private double latitude;

	private String locationName;

	private double longitude;

	private String postcode;

	private String region;

	private String street;

	public Location()
	{

	}

	public double[][] getArea()
	{
		return area;
	}

	public String getCity()
	{
		return city;
	}

	public String getCountry()
	{
		return Country;
	}

	public String getDisplayName()
	{
		return this.locationName + " :: " + this.region;
	}

	public String getId()
	{
		return id;
	}

	public String toString()
	{
		return this.locationName;
	}
	
	public double getLatitude()
	{
		return latitude;
	}

	public String getLocationName()
	{
		return locationName;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public String getRegion()
	{
		return region;
	}

	public String getStreet()
	{
		return street;
	}

	public void setArea(double[][] area)
	{
		this.area = area;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setCountry(String country)
	{
		Country = country;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	@Override
	public int compareTo(Location lToCompare)
	{
		return this.toString().compareToIgnoreCase(lToCompare.toString());
	}

	public static Comparator<Location> LocationNameComparator = new Comparator<Location>()
	{

		public int compare(Location l1, Location l2)
		{

			String location1Name = l1.getLocationName().toUpperCase();
			String location2Name = l2.getLocationName().toUpperCase();

			// ascending order
			return location1Name.compareTo(location2Name);

		}

	};

}
