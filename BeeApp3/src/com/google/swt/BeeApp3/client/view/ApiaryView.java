package com.google.swt.BeeApp3.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.swt.BeeApp3.client.Presenter.HivePresenter;

public class ApiaryView extends Composite implements HivePresenter.Display
{
	private final Button addButton;
	private FlexTable contactsTable;
	private final FlexTable contentTable;
	private final Button deleteButton;

	public ApiaryView()
	{
		DecoratorPanel contentTableDecorator = new DecoratorPanel();
		initWidget(contentTableDecorator);
		contentTableDecorator.setWidth("100%");
		contentTableDecorator.setWidth("18em");

		contentTable = new FlexTable();
		contentTable.setWidth("100%");
		contentTable.getCellFormatter().addStyleName(0, 0,
				"contacts-ListContainer");
		contentTable.getCellFormatter().setWidth(0, 0, "100%");
		contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0,
				HasVerticalAlignment.ALIGN_TOP);

		// Create the menu
		//
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setBorderWidth(0);
		hPanel.setSpacing(0);
		hPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		addButton = new Button("Add");
		hPanel.add(addButton);
		deleteButton = new Button("Delete");
		hPanel.add(deleteButton);
		contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListMenu");
		contentTable.setWidget(0, 0, hPanel);

		// Create the contacts list
		//
		contactsTable = new FlexTable();
		contactsTable.setCellSpacing(0);
		contactsTable.setCellPadding(0);
		contactsTable.setWidth("100%");
		contactsTable.addStyleName("contacts-ListContents");
		contactsTable.getColumnFormatter().setWidth(0, "15px");
		contentTable.setWidget(1, 0, contactsTable);

		contentTableDecorator.add(contentTable);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<List<String>> handler)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget asWidget()
	{
		return this;
	}

	@Override
	public HasClickHandlers getAddButton()
	{
		return addButton;
	}

	@Override
	public int getClickedRow(ClickEvent event)
	{
		int selectedRow = -1;
		HTMLTable.Cell cell = contactsTable.getCellForEvent(event);

		if (cell != null)
		{
			// Suppress clicks if the user is actually selecting the
			// check box
			//
			if (cell.getCellIndex() > 0)
			{
				selectedRow = cell.getRowIndex();
			}
		}

		return selectedRow;
	}

	@Override
	public HasClickHandlers getDeleteButton()
	{
		return deleteButton;
	}

	@Override
	public HasClickHandlers getList()
	{
		return contactsTable;
	}

	@Override
	public List<Integer> getSelectedRows()
	{
		List<Integer> selectedRows = new ArrayList<Integer>();

		for (int i = 0; i < contactsTable.getRowCount(); ++i)
		{
			CheckBox checkBox = (CheckBox) contactsTable.getWidget(i, 0);
			if (checkBox.getValue())
			{
				selectedRows.add(i);
			}
		}

		return selectedRows;
	}

	@Override
	public List<String> getValue()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(List<String> data)
	{
		contactsTable.removeAllRows();

		for (int i = 0; i < data.size(); ++i)
		{
			contactsTable.setWidget(i, 0, new CheckBox());
			contactsTable.setText(i, 1, data.get(i));
		}
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
