package com.docto.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import com.docto.shared.Csumm;
import com.docto.shared.DctRegbeans;
import com.docto.shared.Event;
import com.docto.shared.Everegistbeans;
import com.docto.shared.News;
import com.docto.shared.Summm;
import com.docto.shared.regist;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	
	void Reg(regist r, AsyncCallback<String> callback);
	
	void Login(String s1, String s2, AsyncCallback<String> callback)throws IllegalArgumentException;
	void Doct(News n, AsyncCallback<String> callback) throws IllegalArgumentException;


	void Edit(String s1, String s2, AsyncCallback<String> callback);
	void fact(Summm s1, AsyncCallback<String> callback) throws IllegalArgumentException;
	void insert(Summm e3, AsyncCallback<String> callback) throws IllegalArgumentException; 
	
	void feed(String s3, AsyncCallback<Csumm[]> callback) throws IllegalArgumentException;

	void EventCreation(Event r, AsyncCallback<String> callback)throws IllegalArgumentException;

	void eventdisplay(String s5,AsyncCallback<Event[]> asyncCallback);

	void Everegist(Everegistbeans eb, AsyncCallback<String> callback);

	void Regdoc(DctRegbeans db, AsyncCallback<String> callback)throws IllegalArgumentException;

	void update(String s1, String s2, AsyncCallback<String> callback);

	void delete(String s1, AsyncCallback<String> callback);

	
	


}
