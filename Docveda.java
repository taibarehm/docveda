package com.docto.client;

import com.docto.shared.Summm;
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
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialToast;

public class Docveda extends Composite{
	
	GreetingServiceAsync a1=GWT.create(GreetingService.class);

	private static DocvedaUiBinder uiBinder = GWT.create(DocvedaUiBinder.class);

	interface DocvedaUiBinder extends UiBinder<Widget, Docveda> {
	}
	
	@UiField
	MaterialTextArea ts;
	
	@UiField
	 MaterialButton bs;
	
	@UiField
	MaterialTextArea tx;
	
   
	@UiField
	 MaterialButton sum;
	
	 @UiField
	 MaterialTextArea td;
	 
	 @UiField
	 MaterialButton sub;
	 
	 @UiField
	 MaterialButton edit;
	 
	 @UiField
	 MaterialButton delete;
		
	 public Docveda() {
			initWidget(uiBinder.createAndBindUi(this));
			History.addValueChangeHandler(new ValueChangeHandler<String>() {
				
				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					// TODO Auto-generated method stub
					Myproject.getInstance().hstry();
				}
			});
			
		
		}
	 
	 
	
	 
	 @UiHandler("bs")
		public void onClick(ClickEvent e)
		{ 
		    String p1="#"+ts.getText();
			Summm ee=new Summm();
			ee.setSearch(p1);
			a1.fact(ee,new AsyncCallback<String>() {
			@Override
		  public void onSuccess(String result) {
					// TODO Auto-generated method stub
					tx.setText(result);
					//tx.setText("");
			}
			@Override
			public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
			}
			});
		}

		@UiHandler("sub")
		public void onClick1(ClickEvent s)
		{
			String h="#"+ts.getText();
			String l=tx.getText();
			String s1=td.getText();
			Summm e3=new Summm();
			e3.setHeading(h);
			e3.setLodata(l);
			e3.setSumm(s1);
			a1.insert(e3,new AsyncCallback<String>() {
				
				@Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
					if(result.equals("OK"))
					{
					
					Window.alert("yess");					
				}
					else {
						Window.alert("no");
					}
				}
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
	}
		 @UiHandler("delete")
			public void onClick11111(ClickEvent e)
			{ 
			    String s1="#"+ts.getText();
			    a1.delete(s1, new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if(result.equals("OK")) {
							MaterialToast.fireToast("Deleted");
						}
						else {
							MaterialToast.fireToast("Failed...");
						}
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
	
		 
}






