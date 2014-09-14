package com.google.swt.BeeApp3.client.view.Hive;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.Presenter.HivePresenter;

public class HiveMainView extends Composite implements HivePresenter.Display
{

	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, HiveMainView>
	{
	}

	public HiveMainView()
	{
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public List<String> getValue()
	{
		// TODO Auto-generated method stub
		return null;
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
	public void setData(List<String> data)
	{
		// TODO Auto-generated method stub
		
	}

}
