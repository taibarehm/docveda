package com.docto.client;

import com.docto.shared.News;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;

import gwt.material.design.client.ui.MaterialPanel;

import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.MaterialToast;

public class Submit extends Composite {
	MaterialButton b;
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	private static SubmitUiBinder uiBinder = GWT.create(SubmitUiBinder.class);

	interface SubmitUiBinder extends UiBinder<Widget, Submit> {
	}
	
	@UiField
	MaterialTitle l;

	
	@UiField
	MaterialTextBox tb;
	
	
	
	@UiField
	MaterialTextArea t;
   
	@UiField
   MaterialPanel img;
	
   @UiField
	MaterialButton button,up;
	@UiField
	MaterialButton b1;
	
	@UiField
	MaterialButton su;

	@UiField
	VerticalPanel v;

	public Submit() {
		initWidget(uiBinder.createAndBindUi(this));
History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Myproject.getInstance().hstry();
			}
		});
final FormPanel form = new FormPanel();
form.setAction("http://127.0.0.1:8888/docto/upload");

// Because we're going to add a FileUpload widget, we'll need to set the
// form to use the POST method, and multipart MIME encoding.
form.setEncoding(FormPanel.ENCODING_MULTIPART);
form.setMethod(FormPanel.METHOD_POST);

// Create a panel to hold all of the form widgets.
VerticalPanel panel = new VerticalPanel();
form.setWidget(panel);


// Create a TextBox, giving it a name so that it will be submitted.


// Create a ListBox, giving it a name and some values to be associated with
// its options.


// Create a FileUpload widget.
FileUpload upload = new FileUpload();
upload.setName("uploadFormElement");
panel.add(upload);

// Add a 'submit' button.
b=new MaterialButton("Upload");
b.setBackgroundColor(Color.RED_LIGHTEN_1);
b.addClickHandler(new ClickHandler() {

@Override
public void onClick(ClickEvent event) {
	// TODO Auto-generated method stub
	  form.submit();
	
}
});
panel.add(b);


// Add an event handler to the form.
form.addSubmitHandler(new FormPanel.SubmitHandler() {
  public void onSubmit(SubmitEvent event) {
    // This event is fired just before the form is submitted. We can take
    // this opportunity to perform validation.
 
  }

public void onSubmit2(SubmitEvent event) {
	// TODO Auto-generated method stub
	
}
});
form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
  public void onSubmitComplete(SubmitCompleteEvent event) {
    Window.alert(event.getResults());
  }
});

img.add(form);
}




	
	
	@UiHandler("su")
	void onClick11(ClickEvent t) {
		
	/*	RootPanel.get().clear();
		Docveda d=new Docveda();
		RootPanel.get().add(d);*/
		
		History.newItem("gg");
		Myproject.getInstance().hstry();
		
		
		
		
	}
	
	
	@UiHandler("button")
	void onClick(ClickEvent e) {
		//FileUpload upload = new FileUpload();
	//	String s4="images"+upload.getFilename();
		News n = new News();
		String s1 ="#"+tb.getText();
		String s2 = t.getText();
		String s4="no image";
		
		n.setHeading(s1);
		n.setDesc(s2);
		n.setUpload(s4);
		a1.Doct(n,new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("OK"))
				{
					
			    MaterialToast.fireToast("Successfully Submitted");
				Window.alert("done");
				t.clear();
				
				}else {
					Window.alert("failed..please try again!");
					
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		}
		
		@UiHandler("b1")
		void onClick1(ClickEvent e1) {

			String s1="#"+tb.getText();
			String s2="";
			a1.Edit(s1, s2, new AsyncCallback<String>() {
				
				@Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
					
					t.setText(result);
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
			
			}
		@UiHandler("up")
		void onClick111(ClickEvent e1) {
			String s1="#"+tb.getText();
			String s2=t.getText();
			
			a1.update(s1, s2, new AsyncCallback<String>() {
				
				@Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
					if(result.equals("OK")) {
						MaterialToast.fireToast("Updated Successfully");
					}else {
						MaterialToast.fireToast("Failed...Try Again");
					}
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
		
		
	}
	


	

