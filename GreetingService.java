package com.docto.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import com.docto.shared.Csumm;
import com.docto.shared.DctRegbeans;
import com.docto.shared.Event;
import com.docto.shared.Everegistbeans;
import com.docto.shared.News;
import com.docto.shared.Summm;
import com.docto.shared.regist;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	String Reg(regist r) throws IllegalArgumentException;
	String Login(String s1,String s2)throws IllegalArgumentException;
	String Doct(News n) throws IllegalArgumentException;
	String Edit(String s1,String s2)throws IllegalArgumentException;
	
	String fact(Summm s1) throws IllegalArgumentException;
	String insert(Summm e3) throws IllegalArgumentException;
	
	Csumm[] feed(String s3) throws IllegalArgumentException;
	
	String EventCreation(Event  r) throws IllegalArgumentException;
	Event[] eventdisplay(String s5) throws IllegalArgumentException;
	String Everegist(Everegistbeans eb) throws IllegalArgumentException;
	String Regdoc(DctRegbeans db) throws IllegalArgumentException;
	String update(String s1,String s2)throws IllegalArgumentException;
	String delete(String s1)throws IllegalArgumentException;
	
	
	
	
	
	

}
