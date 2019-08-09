package com.docto.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.docto.client.GreetingService;
import com.docto.client.GreetingServiceAsync;
import com.docto.client.Login;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Login extends Composite {

GreetingServiceAsync bb=GWT.create(GreetingService.class);
	

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
		
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Myproject.getInstance().hstry();
			}
		});
	}
	

	
	@UiField
	MaterialTextBox t;
	
	
	@UiField
	MaterialTextBox t2;

	@UiField
	MaterialButton button;
	
	@UiField
	Label l;
	

	
	
	

	public Login(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
		
	}
	

	
	@UiHandler("l")
	void onClick1(ClickEvent e) {
		
	/*	RootPanel.get("tt1").clear();
		Register a=new Register();
		RootPanel.get("tt1").add(a);*/
		History.newItem("ee");
		Myproject.getInstance().hstry();
		
		
		
		
	}
	

	@UiHandler("button")
	void onClick(ClickEvent e) {
		  String s1=t.getText();
			String s2=t2.getText();
	
		if(s1.isEmpty()||s2.isEmpty()) {
			
			MaterialToast.fireToast("Please Enter details");
		}else {
		
		bb.Login(s1, s2, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("yes"))
				{  
				
					MaterialToast.fireToast("Successfully logging in....");
				/*	RootPanel.get().clear();
					After a=new After();
					RootPanel.get().add(a);		*/
					History.newItem("dd");
					Myproject.getInstance().hstry();
				}
				else {
					
					MaterialToast.fireToast("No Account found");
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
			
		});
		}
	}

}
