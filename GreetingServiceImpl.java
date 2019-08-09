package com.docto.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.docto.client.GreetingService;
import com.docto.shared.Csumm;
import com.docto.shared.DctRegbeans;
import com.docto.shared.Event;
import com.docto.shared.Everegistbeans;
import com.docto.shared.News;
import com.docto.shared.Summm;
import com.docto.shared.regist;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	
	Connection con=null;
	Statement st=null;
	PreparedStatement stt=null;
	PreparedStatement ev=null;
	ResultSet rs=null;
	ResultSet rx=null;
	PreparedStatement sumz=null;
	ResultSet rz=null;
	ResultSet re=null;
	String ss="NO";
    Csumm a[]=new  Csumm[100];
    Event e[]=new Event[20];
    int i;
	
	public void init()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
		}
		try{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hashtag","root","");
	st=con.createStatement();
		}catch(SQLException e)
		{
		}
	}

	@Override
	public String Login(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String ss="not found";
		ResultSet rs=null;
		try {
			rs=st.executeQuery("select * from reg where email='"+s1+"' and password='"+s2+"'");
			if(rs.next()) {
				ss="yes";
			
		}
		}catch(SQLException e)
		{
			
		}
		return ss;
	}

	@Override
	public String Reg(regist r) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String s1=r.getName();
		String s2=r.getEmail();
		String s3=r.getPassword();
		String s4=r.getMobile();
		String ss="NO";
		if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty())
		{
			Window.alert("enter");
		
		}
		int k=0;
		try{
		k=st.executeUpdate("insert into reg values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
		if(k!=0)
		{
			ss="OK";
		}
		}catch(SQLException t)
		{
			
			System.out.println(t.getMessage());
		}
		return ss;
		
	}

	public String Doct(News n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String s1 = n.getHeading();
		String s4 = n.getUpload();
		String s3 = n.getDesc();
		String sy="NO";
		int k=0;
		try {
			k=st.executeUpdate("insert into News values('" + s1 + "','"+s3+"','"+s4+"')");
			if(k!=0)
			{
				sy="OK";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return sy;
	}

	@Override
	public String Edit(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		init();
		String ss="not found";
		ResultSet rs=null;
		try {
			rs=st.executeQuery("select * from News where heading='"+s1+"'");
			if(rs.next()) {
				String h=rs.getString("heading");
				ss=rs.getString("Description");
			
		}
		}catch(SQLException e)
		{
			
		}
		return ss;
	}

	@Override
	public String fact(Summm s1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String s=s1.getSearch();
		String ss="not found";
		ResultSet rs=null;
		try {
			rs=st.executeQuery("select * from News where heading='"+s+"'");
			if(rs.next()) {
				
				String h=rs.getString("heading");
				ss=rs.getString("Description");
			
		}
		}catch(SQLException e)
		{
			
		}
	
		return ss;
	}

	@Override
	public String insert(Summm e3) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String he=e3.getHeading();
		String lo=e3.getLodata();
		String sum=e3.getSumm();
		String se="No";
		int k=0;
		try {
			 k=st.executeUpdate("insert into final(heading,longd,summd) values('"+he+"','"+lo+"','"+sum+"')");
		     if(k!=0)
		     {
			  se="OK";
		     }
			}catch (SQLException es) {
			es.printStackTrace();
			// TODO: handle exception
			}
		return se;
	}
		
	
	
	@Override
	public Csumm[] feed(String s3) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		try {
			stt=con.prepareStatement("select * from final");
			rx=stt.executeQuery();
			i=0;
			while(rx.next())
			{   
			   a[i]=new Csumm();
			   //a[i].setId(rs.getIntSt("ID"));
			   a[i].setHeading(rx.getString("heading"));
			   a[i].setLodata(rx.getString("longd"));
			   a[i].setSumm(rx.getString("summd"));
			
			   i++;
			}
		} catch (Exception f) {
			// TODO: handle exception
			f.printStackTrace();
		}
		return a;
	}

	@Override
	public String EventCreation(Event r) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String s1=r.getName();
		String s2=r.getVenue();
		String s3=r.getDate();
		String s4=r.getTime();
		String rt="NO";
		int k=0;
		try {
			k=st.executeUpdate("insert into event values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
			if(k!=0)
			{
				rt="OK";
			}
		}catch(SQLException t)
		{
			System.out.println(t.getMessage());
		}
		return rt;
	}

	@Override
	public Event[] eventdisplay(String s5) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		try {
			ev=con.prepareStatement("select * from event");
			re=ev.executeQuery();
			i=0;
			while(re.next())
			{   
			   e[i]=new Event();
			   e[i].setName(re.getString("Name"));
               e[i].setVenue(re.getString("Venue"));
               e[i].setDate(re.getString("Date")); 
               e[i].setTime(re.getString("Time")); 
			
			   i++;
			}
		} catch (Exception ev) {
			// TODO: handle exception
			ev.printStackTrace();
		}
		return e;
	}

	@Override
	public String Everegist(Everegistbeans eb) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String s1=eb.getName();
		String s2=eb.getEmail();
		String s3=eb.getAddress();
		String s4=eb.getRegmobile();
		String s5=eb.getEventname();
		String s6=eb.getDate();
		String ss="NO";
		if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty())
		{
			Window.alert("enter");
		
		}
		int k=0;
		try{
		k=st.executeUpdate("insert into eventreg values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
		if(k!=0)
		{
			ss="OK";
		}
		}catch(SQLException t)
		{
			
			System.out.println(t.getMessage());
		}
		return ss;
	}

	@Override
	public String Regdoc(DctRegbeans db) throws IllegalArgumentException {
		// TODO Auto-generated method stub
	
		init();
		 String s1=db.getFullname();
		 String s2=db.getEmail();
		 String g=db.getGender();
		 String s3=db.getPassword();
		 String s4=db.getAge();
		 String s5=db.getDob();
		 String s6=db.getPaddress();
		 String s7=db.getCaddress();
		 String s8=db.getMobile();
		 String s9=db.getCountry();
		 String s10=db.getCity();
		String ss="NO";
	/*	if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty())
		{
			Window.alert("enter");
		
		}*/
		int k=0;
		try{
		k=st.executeUpdate("insert into docreg values('"+s1+"','"+s2+"','"+g+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"')");
		if(k!=0)
		{
			ss="OK";
		}
		}catch(SQLException t)
		{
			
			System.out.println(t.getMessage());
		}
		return ss;
	}

	@Override
	public String update(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		int k=0;
		String ss="not found";
		try {
			k=st.executeUpdate("Update news Set Description='"+s2+"' where heading='"+s1+"'");
			if(k!=0) {
				ss="OK";
			}
		}catch(SQLException t)
		{
			System.out.println(t.getMessage());
		}
		
		return ss;
	}

	@Override
	public String delete(String s1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		
		int k=0;
		String ss="not found";
		try {
			k=st.executeUpdate("Delete from final where heading='"+s1+"'");
			if(k!=0) {
				ss="OK";
			}
		}catch(SQLException t)
		{
			System.out.println(t.getMessage());
		}
		
		return ss;
	}

	

}
	
  