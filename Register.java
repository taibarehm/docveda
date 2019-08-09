package com.docto.client;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.docto.client.GreetingService;
import com.docto.client.GreetingServiceAsync;
import com.docto.shared.regist;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Register extends Composite {
	GreetingServiceAsync aa=GWT.create(GreetingService.class);
	private static RegisterUiBinder uiBinder = GWT.create(RegisterUiBinder.class);

	interface RegisterUiBinder extends UiBinder<Widget, Register> {
	}

	public Register() {
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
	MaterialTextBox na;
	

	
	@UiField
	MaterialTextBox ema;
	

	
	@UiField
	MaterialTextBox passw;
	

	@UiField
	MaterialTextBox cpassw;
	
	@UiField
	MaterialIntegerBox mobile;
	
	
	@UiField
	MaterialButton btn;
	@UiField
	Label lo;

	public Register(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		btn.setText(firstName);
	}
	
	
	   @UiHandler("lo")
       void onClick1(ClickEvent h) {
    	   /*  RootPanel.get("tt1").clear();
    	     Login l=new Login();
    	    		 RootPanel.get("tt1").add(l);*/
			History.newItem("cc");
			Myproject.getInstance().hstry();
       }

	@UiHandler("btn")
	void onClick(ClickEvent e) {
	       String s1=na.getText();
	       String s2=ema.getText();
	       String s3=passw.getText();
	       String s5=cpassw.getText();
	       String s4=mobile.getText();
	       if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty())
	       {
	    		MaterialToast.fireToast("please enter all details");
	       }
	       if(s3.equals(s5))
	       {
	    	  
	       
	       
    	   
	       regist r=new regist();
	       r.setEmail(s2);
	       r.setName(s1);
	       r.setPassword(s3);
	       r.setMobile(s4);
	      
	       aa.Reg(r, new AsyncCallback<String>() {
			
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("OK")) {
					MaterialToast.fireToast("Successfully Registered....");
				/*	RootPanel.get().clear();
					After p=new After();
					RootPanel.get().add(p);*/
					History.newItem("dd");
					Myproject.getInstance().hstry();
				}
				else {
					
						Window.alert("failed..please try after sometime");
					
				}
				
			}
		});
	       }
else {
	    	   
	    	   MaterialToast.fireToast(" confirm password not match");
	       }
	       
	    
	}	       
	       
	
}
