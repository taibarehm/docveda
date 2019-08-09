package com.docto.client;

import com.docto.shared.Csumm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardAction;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardImage;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;

public class Feed extends Composite{

	private static FeedUiBinder uiBinder = GWT.create(FeedUiBinder.class);

	interface FeedUiBinder extends UiBinder<Widget, Feed> {
	}
	
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	MaterialLabel hl,sl,lg;
	MaterialLink lk;
	int j;

	public Feed() {
		
		initWidget(uiBinder.createAndBindUi(this));
		
		
			History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Myproject.getInstance().hstry();
			}
		});
		
		fee();
		
		
	
	
		
	
	}	
	
	public void fee() {
		
a1.feed(null, new AsyncCallback<Csumm[]>() {
			
			@Override
			public void onSuccess(com.docto.shared.Csumm[] result) {
				// TODO Auto-generated method stub
				
			//	RootPanel.get("tt1").clear();
				
				MaterialPanel p1= new MaterialPanel();
				MaterialRow rr = new  MaterialRow();
				MaterialColumn cc=new MaterialColumn();
				cc.setGrid("s12 l6");
			
			
				for(j=0;j<result.length;j++)
				{    
					
					
				
					MaterialCard cd= new MaterialCard();//card
					cd.setBackgroundColor(Color.WHITE);
				//	cd.setBackgroundColor(Color.GREEN_DARKEN_1);
					MaterialRow r1= new MaterialRow();//row
					MaterialColumn c1= new MaterialColumn();//colum
					MaterialColumn c2= new MaterialColumn();//colum
					
				
					MaterialCardImage icd= new MaterialCardImage();//materialcardimage
					MaterialImage mi=new MaterialImage("data:image/jpeg;base64,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");//materialimage
					MaterialCardContent mcc2=new MaterialCardContent();
					MaterialCardAction act=new MaterialCardAction();//Matrialcard actio
					hl =new MaterialLabel(result[j].getHeading());
					hl.setFontSize("2em");
					hl.getElement().getStyle().setFontWeight(FontWeight.BOLD);
					sl=new  MaterialLabel();
					sl.setText(result[j].getSumm());
					
					
					
					sl.setFontSize("1.4em");
				    sl.getElement().getStyle().setProperty("fontFamily", "Comic Sans MS");
					//sl.setFontWeight(fontWeight);
					sl.getElement().getStyle().setColor("Black");
				
					
				  // MaterialButton p1 =new MaterialButton("LongData :");
					lk =new MaterialLink("Click For More Details");
					lk.getElement().getStyle().setFontWeight(FontWeight.BOLD);
					lk.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							
							
							lg.setText(result[j].getLodata());
							
							mcc2.add(lg);
							
						}
					});
					
					
				    mcc2.add(hl);
					mcc2.add(sl);
				   act.add(lk);
				   mcc2.add(act);
					icd.add(mi);
					c1.add(icd);
					c2.add(mcc2);
					r1.add(c1);
					r1.add(c2);
					cd.add(r1);
					p1.add(cd);
					cc.add(p1);
					rr.add(cc);
					c1.setGrid("s1 m4 l2" );
					c2.setGrid("s12 m4 l6" );
					cd.setGrid("s12 m4 l6" );
					
					RootPanel.get("tt1").add(p1);
					//cd.add(c1);
					//cd.add(act);
					//cd.add(icd);
			}
			
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
	


