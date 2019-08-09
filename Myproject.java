package com.docto.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;


public class Myproject {
	
	static Myproject m1=null;
	Feed fe=null;
	Evdisplay ev=null;
	Login l=null;
	After af=null;
	Register r=null;
	Submit s=null;
	Docveda d=null;
	Even e=null;
	Event_Regist  er=null;
	
	
	
	
	private Myproject(){
		
	}
  static Myproject getInstance() {
	  
	  if(m1==null)
	  {
		  m1=new Myproject();
	  }
	return m1;
	  
  }
  
  public void hstry()
  {
	   if(History.getToken().equals("aa"))
	   {
		   RootPanel.get("tt1").clear();
		   RootPanel.get("tt1").add(getFeed());
	   }
	   else if(History.getToken().equals("bb")) {
		   RootPanel.get("tt1").clear();
		   RootPanel.get("tt1").add(getEvdisplay());
	   }
	   else if(History.getToken().equals("cc")) {
		   RootPanel.get("tt1").clear();
		   RootPanel.get("tt1").add(getLogin());
	   }
	   else if(History.getToken().equals("dd")) {
		   RootPanel.get("tt1").clear();
		   RootPanel.get("tt1").add(getAfter());
	   }
	   else if(History.getToken().equals("ee")) {
		   RootPanel.get("tt1").clear();
		   RootPanel.get("tt1").add(getRegister());
	   }
	   else if(History.getToken().equals("ff")) {
		   RootPanel.get("tt1").clear();
		   RootPanel.get("tt1").add(getSubmit());
	   }
	   else if(History.getToken().equals("gg")) {
		   RootPanel.get().clear();
		   RootPanel.get().add(getDocveda());
	   }
	   else if(History.getToken().equals("hh")) {
		   RootPanel.get("tt1").clear();
		   RootPanel.get("tt1").add(getEven());
	   }
	   else if(History.getToken().equals("ii")) {
		   RootPanel.get("tt1").clear();
		   RootPanel.get("tt1").add(getEvent_Regist());
	   }
	   }
 
Event_Regist getEvent_Regist() {
	// TODO Auto-generated method stub
	if(er==null) {
		er=new Event_Regist();
	}
	return er;
}
Even getEven() {
	// TODO Auto-generated method stub
	if(e==null) {
		e=new Even();
	}
	return e;
}
Docveda getDocveda() {
	// TODO Auto-generated method stub
	if(d==null) {
		d=new Docveda();
	}
	return d;
}
Submit getSubmit() {
	// TODO Auto-generated method stub
	if(s==null) {
		s=new Submit();
	}
	return s;
}
Register getRegister() {
	// TODO Auto-generated method stub
	if(r==null) {
		r=new Register();
	}
	return r;
}
After getAfter() {
	// TODO Auto-generated method stub
	if(af==null) {
		af=new After();
	}
	return af;
}
Login getLogin() {
	// TODO Auto-generated method stub
	if(l==null) {
		l=new Login();
	}
	return l;
}
Evdisplay getEvdisplay() {
	// TODO Auto-generated method stub
	if(ev==null) {
		ev=new Evdisplay();
	}
	
		
	return ev;
}
 Feed getFeed() {
	// TODO Auto-generated method stub
	 if(fe==null) {
	     fe=new Feed();
		}
	return fe;
}

}
