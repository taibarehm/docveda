package com.docto.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialTitle;

public class After extends Composite {

	private static AfterUiBinder uiBinder = GWT.create(AfterUiBinder.class);

	interface AfterUiBinder extends UiBinder<Widget, After> {
	}
   
	
	
	 @UiField
	 MaterialTitle lo;
	 
	 @UiField
	 MaterialImage lon; 
	 
	 @UiField
	 MaterialTitle su;
	 
	 @UiField
	 MaterialImage sum;
	 
	 @UiField
	 MaterialTitle Event;
	 
	 @UiField
	 MaterialImage event;
	 
	 
	 
	 
	 
	public After() {
		initWidget(uiBinder.createAndBindUi(this));
History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Myproject.getInstance().hstry();
			}
		});
	}
	@UiHandler("lo")
	void onClick11(ClickEvent e) {
		
	/*	RootPanel.get().clear();
		Submit a=new Submit();
		RootPanel.get().add(a);*/
		History.newItem("ff");
		Myproject.getInstance().hstry();
		
	
	}
	
	@UiHandler("lon")
	void onClick2(ClickEvent e) {
	/*	RootPanel.get().clear();
		Submit a=new Submit();
		RootPanel.get().add(a);*/
		
		History.newItem("ff");
		Myproject.getInstance().hstry();
		
	
	}
	
	@UiHandler("su")
	void onClick1(ClickEvent e) {
		
	
		History.newItem("gg");
		Myproject.getInstance().hstry();
		
		
	
	}
	
	@UiHandler("sum")
	void onClick(ClickEvent e) {

		History.newItem("gg");
		Myproject.getInstance().hstry();
	
	}
	@UiHandler("event")
	void onClick111(ClickEvent e) {
	
		History.newItem("hh");
		Myproject.getInstance().hstry();
	
	}
	@UiHandler("Event")
	void onClick1111(ClickEvent e) {
		
		History.newItem("hh");
		Myproject.getInstance().hstry();
	
	}


}
