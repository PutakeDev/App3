/**
 * 
 */
package com.google.swt.BeeApp3.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Erik
 *
 */
/**
 * JDO persistable TaskData.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Hive implements IsSerializable
{

	@Persistent
	private String barcode;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;

	@Persistent
	private String name;

	@Persistent
	private String number;
	@Persistent
	private Apiary parentApiary;
	@Persistent
	private String RFID;

	public Hive()
	{
		this.id = null;
	}

	public String getBarcode()
	{
		return barcode;
	}

	public String getDisplayName()
	{
		return "Hive: " + name;
	}

	public String getId()
	{
		return id;
	}


	public String getName()
	{
		return name;
	}

	public String getNumber()
	{
		return number;
	}

	public Apiary getParentApiary()
	{
		return parentApiary;
	}

	public String getRFID()
	{
		return RFID;
	}


	public void setBarcode(String barcode)
	{
		this.barcode = barcode;
	}

	public void setId(String id)
	{
		this.id = id;
	}


	public void setName(String name)
	{
		this.name = name;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public void setParentApiary(Apiary parentApiary)
	{
		this.parentApiary = parentApiary;
	}

	public void setRFID(String rFID)
	{
		RFID = rFID;
	}


	@Override
	public String toString()
	{
		return "Hive [ID=" + id + ", name=" + name
				+ ", RFID=" + RFID + "]";
	}

}
