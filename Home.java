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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialPanel;


public class Home extends Composite{

	private static HomeUiBinder uiBinder = GWT.create(HomeUiBinder.class);

	interface HomeUiBinder extends UiBinder<Widget, Home> {
	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	MaterialLabel hl,sl,lg;
	MaterialLink lk;
	int j;

	public Home() {
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
	MaterialLink b,acc;
	
	
	@UiField
	MaterialLink feed;
	
	
	@UiField
	MaterialLink trending;
	
	@UiField
	MaterialPanel materpanel;
	
	@UiField
	MaterialLink btnSearch;
	
	
	@UiField
	MaterialNavBar navBar;
	
	@UiField
	MaterialLink evdisplay;
	//@UiField
	//MaterialSearch txtSearch;
	
		

	public Home(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	b.setText(firstName);
	}
	
	
	

	
	@UiHandler("b")
	void onClick(ClickEvent e) {
	/*	RootPanel.get("tt1").clear();
		Login l=new Login();
	    RootPanel.get("tt1").add(l);*/
		History.newItem("cc");
		Myproject.getInstance().hstry();
	    }
	
	@UiHandler("feed")
	void onClick1(ClickEvent e) {
		
		RootPanel.get("tt1").clear();
		Feed f=new Feed();
		RootPanel.get("tt1").add(f);
		//History.newItem("aa");
	//	Myproject.getInstance().hstry();
		
		        }
	
	@UiHandler("trending")
      void onClick11(ClickEvent e) {
		
		RootPanel.get("tt1").clear();
		
		        }
	@UiHandler("evdisplay")
	void onClick111(ClickEvent e) {
		RootPanel.get("tt1").clear();
	  Evdisplay l=new Evdisplay();
	   RootPanel.get("tt1").add(l);
	//	History.newItem("bb");
	//	Myproject.getInstance().hstry();
		
	    
	    }
	@UiHandler("acc")
    void onClick1111(ClickEvent e) {
		
		RootPanel.get("tt1").clear();
		RootPanel.get("tt1").add(new DoctReg());
	//	navBar.setBackgroundColor(Color.BLUE);
		
	
		
    }
/*	@UiHandler("btnSearch")
	 void onClick11111(ClickEvent e){
		 txtSearch.setVisible(true);
       RootPanel.get("tt1").add(txtSearch);
       
  
	
	}*/
	  
	
	
	
}

