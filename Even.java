package com.docto.client;

import com.docto.shared.Event;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Even extends Composite{
	

	private static EvenUiBinder uiBinder = GWT.create(EvenUiBinder.class);

	interface EvenUiBinder extends UiBinder<Widget, Even> {
	}

	public Even() {
		initWidget(uiBinder.createAndBindUi(this));
History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Myproject.getInstance().hstry();
			}
		});
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	@UiField
	MaterialTextBox nam;
	
	
	@UiField
	MaterialTextBox ven;
	
	@UiField
	MaterialTextBox date;
	
	@UiField
	MaterialTextBox time;

	@UiField
	MaterialButton b1;
	
	
	@UiHandler("b1")
	void onClick(ClickEvent e) {
		
		String s1=nam.getText();
		String s2=ven.getText();
		String s3=date.getText();
		String s4=time.getText();
	   Event r=new Event(); 
	    r.setName(s1);
	    r.setVenue(s2);
	    r.setDate(s3);
	    r.setTime(s4);
	  a1.EventCreation(r, new AsyncCallback<String>() {
		
		@Override
		public void onSuccess(String result) {
		
			// TODO Auto-generated method stub
			if(result.equals("OK")) {
			Window.alert("inserted yes!");
		}
		else {
			Window.alert("NO");
		}
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Not Inserted");
		}
	});   
}
}
