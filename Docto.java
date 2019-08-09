package com.docto.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Docto implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		//Home a=new Home();
		RootPanel.get().add(new Home());
		//RootPanel.get().add(new Evdisplay());
		
		
		
	}
	
	
}
