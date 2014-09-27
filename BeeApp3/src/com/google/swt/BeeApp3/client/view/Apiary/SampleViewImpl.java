/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.google.swt.BeeApp3.client.view.Apiary;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sample implementation of {@link SampleView}.
 */
public class SampleViewImpl extends Composite implements SampleView
{

	interface Binder extends UiBinder<Widget, SampleViewImpl>
	{
	}

	private static final Binder binder = GWT.create(Binder.class);
	@UiField
	Button button;
	private Presenter listener;

	@UiField
	Label statusLabel;

	public SampleViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event)
	{
		button.setText("Button Text");
		statusLabel.setText("button clicked" + statusLabel.getText());
	}

	@Override
	public void setName(String helloName)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setPresenter(Presenter listener)
	{
		this.listener = listener;
	}
}
