package com.docto.client;

import java.util.Date;
import com.docto.shared.DctRegbeans;
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
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class DoctReg extends Composite {
	
	GreetingServiceAsync aa=GWT.create(GreetingService.class);
	private static DoctRegUiBinder uiBinder = GWT.create(DoctRegUiBinder.class);

	interface DoctRegUiBinder extends UiBinder<Widget, DoctReg> {
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public DoctReg() {
		initWidget(uiBinder.createAndBindUi(this));
		MaterialRadioButton m=new MaterialRadioButton("gender","male");
		MaterialRadioButton f=new MaterialRadioButton("gender","Female");
		gen.add(m);
		gen.add(f);
		 if(m.isChecked()) {
			 String g=m.getText();
			 m.setChecked(false);
		 }
		 if (f.isChecked()) {
			
			 String g=f.getText();
			f.setChecked(false);
			}
		 
		
	}



	
	//Calendar calendar = Calendar.getInstance();
	
	@UiField
	MaterialTextBox nave;
	@UiField
	MaterialTextBox Email;
	@UiField
	MaterialTextBox pass;
	
	@UiField
	MaterialPanel gen;
	
	@UiField
	MaterialTextBox cpass;
	@UiField
	MaterialIntegerBox age;
	@UiField
	MaterialDatePicker dp;
	@UiField
	MaterialTextBox paddress;
	@UiField
	MaterialTextBox city;
	
	@UiField
	MaterialTextBox Country;
	@UiField
	MaterialIntegerBox mobile;
	@UiField
	MaterialTextBox caddress;
	
	
	
	@UiField
	MaterialListBox mem;
	
	@UiField
	MaterialButton reg;
	
	

    
	
	@UiHandler("reg")
	 void onClick(ClickEvent e) {
		 
		
		 
		 Window.alert("working");
		 String n=nave.getText();
		 String em=Email.getText();
		 String p=pass.getText();
		 String a=age.getText();
		 Date h=dp.getValue();
		 String d=h.toString();
		 String ad=paddress.getText();
		 String cad=caddress.getText();
		 String mb=mobile.getText();
		 String cty=city.getText();
		 String cntry=Country.getText();
		 
	
		
		 
		 
		 DctRegbeans db=new DctRegbeans();
		 db.setFullname(n);
		 db.setEmail(em);
		 db.setPassword(p);
		 db.setAge(a);
		 db.setDob(d);
		 db.setPaddress(ad);
		 db.setCaddress(cad);
		 db.setMobile(mb);
		 db.setCountry(cntry);
		 db.setCity(cty);
		 
	//     db.setGender(g);
		 
		 aa.Regdoc(db, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("OK")) {
					Window.alert("registered");
				}
				else {
					Window.alert("failed");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("failed...");
			}
		});
		 
		 
		 
		 
		
	 }
	 
	

	

}
