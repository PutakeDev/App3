package com.google.swt.BeeApp3.client.view.Hive;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.widget.client.TextButton;
import com.google.swt.BeeApp3.client.Presenter.HivePresenter;

public class HiveMainView extends Composite implements HivePresenter.Display
{

	interface Binder extends UiBinder<Widget, HiveMainView>
	{
	}

	private static final Binder binder = GWT.create(Binder.class);
	@UiField
	TextBox createHiveBarCode;
	@UiField
	TextButton CreateHiveButton;
	@UiField
	TextBox createHiveName;
	@UiField
	TextBox createHiveNumber;
	@UiField
	TextBox createHiveRFID;
	@UiField
	ListBox HiveList;

	@UiField
	ListBox LocationList;

	public HiveMainView()
	{

		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<List<String>> handler)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandlers getAddButton()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getClickedRow(ClickEvent event)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HasClickHandlers getDeleteButton()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandlers getList()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getSelectedRows()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getValue()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@UiHandler("CreateHiveButton")
	void onCreateHiveButtonClick(ClickEvent event)
	{

	}

	@Override
	public void setData(List<String> data)
	{
		this.HiveList.clear();

		for (int i = 0; i < data.size(); ++i)
		{
			this.HiveList.addItem(data.get(i));
		}
	}

	private void setLocationList()
	{

	}

	@Override
	public void setValue(List<String> value)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setValue(List<String> value, boolean fireEvents)
	{
		// TODO Auto-generated method stub

	}
}
