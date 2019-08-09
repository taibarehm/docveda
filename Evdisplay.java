package com.docto.client;

import com.docto.shared.Event;
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

import gwt.material.design.client.constants.CenterOn;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;

public class Evdisplay extends Composite {

	private static EvdisplayUiBinder uiBinder = GWT.create(EvdisplayUiBinder.class);

	interface EvdisplayUiBinder extends UiBinder<Widget, Evdisplay> {
	}

	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	int i;
	MaterialCard card;

	public Evdisplay() {
		initWidget(uiBinder.createAndBindUi(this));
		History.addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Myproject.getInstance().hstry();
			}
		});

		a1.eventdisplay(null, new AsyncCallback<Event[]>() {

			@Override
			public void onSuccess(Event[] result) {
				
				MaterialPanel p1 = new MaterialPanel();
				MaterialRow r1 = new MaterialRow();
				for (i = 1; i < result.length; i++) {

					MaterialColumn c1 = new MaterialColumn();

					card = new MaterialCard();

					card.setBackgroundColor(Color.BLUE_GREY_DARKEN_1);
					MaterialCardContent cont = new MaterialCardContent();
					cont.setTextColor(Color.WHITE);
					MaterialCardTitle t1 = new MaterialCardTitle();
					t1.setText(result[i].getName());
					t1.setIconType(IconType.EVENT);
					t1.setIconPosition(IconPosition.RIGHT);
					MaterialLabel l1 = new MaterialLabel("Venue :" + result[i].getVenue());
					MaterialLabel l2 = new MaterialLabel("Date :" + result[i].getDate());
					MaterialLabel l3 = new MaterialLabel("Time :" + result[i].getTime());
					MaterialButton reg = new MaterialButton();
					reg.setText("Register");
					l1.setFontWeight(FontWeight.BOLDER);
					l1.setCenterOn(CenterOn.CENTER_ON_SMALL);
					cont.add(t1);
					cont.add(l1);
					cont.add(l2);
					cont.add(l3);
					cont.add(reg);
					card.add(cont);
					c1.add(card);
					c1.setGrid("l4 m4 s12");
					r1.add(c1);
					p1.add(r1);

					RootPanel.get("tt1").add(p1);

					reg.addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							/*
							 * RootPanel.get("tt1").clear(); Event_Regist a=new Event_Regist();
							 * RootPanel.get("tt1").add(a);
							 */
							History.newItem("ii");
							Myproject.getInstance().hstry();

						}
					});
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});

	}

}
