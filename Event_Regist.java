package com.docto.client;

import com.docto.shared.Everegistbeans;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialTextBox;

public class Event_Regist extends Composite{
	GreetingServiceAsync aa=GWT.create(GreetingService.class);

	private static Event_RegistUiBinder uiBinder = GWT.create(Event_RegistUiBinder.class);

	interface Event_RegistUiBinder extends UiBinder<Widget, Event_Regist> {
	}

	public Event_Regist() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField
	MaterialTextBox nave;
	
     @UiField
	MaterialTextBox Email;
     
     @UiField
 	MaterialTextBox Address;
     
     @UiField
 	MaterialTextBox eventname;
      
      @UiField
  	MaterialTextBox Date;
 	
	
    @UiField
	MaterialIntegerBox mobile;
	
	
	@UiField
	MaterialButton Register;
	
	@UiHandler("Register")
	void onClick(ClickEvent e) {
		
		String s1=nave.getText();
		String s2=Email.getText();
		String s3=Address.getText();
		String s4=mobile.getText();
		String s5=eventname.getText();
		String s6=Date.getText();
		Everegistbeans eb=new Everegistbeans();
		eb.setName(s1);
		eb.setEmail(s2);
		eb.setAddress(s3);
		eb.setRegmobile(s4);
		eb.setEventname(s5);
		eb.setDate(s6);
		aa.Everegist(eb, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("OK")) {
					Window.alert("Registered");
					
				}
				else {
					Window.alert("Failed...");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
	}
	

	

}
