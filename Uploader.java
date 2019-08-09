package com.docto.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.events.SuccessEvent;
import gwt.material.design.addins.client.fileuploader.events.TotalUploadProgressEvent;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialProgress;


public class Uploader extends Composite {
	
	

	private static UploaderUiBinder uiBinder = GWT.create(UploaderUiBinder.class);

	interface UploaderUiBinder extends UiBinder<Widget, Uploader> {
	
	}
	


	public Uploader() {
		initWidget(uiBinder.createAndBindUi(this));
		
		 // Added the progress to card uploader
		 cardUploader.addTotalUploadProgressHandler(new TotalUploadProgressEvent.TotalUploadProgressHandler() {
		  @Override
		  public void onTotalUploadProgress(TotalUploadProgressEvent event) {
		   progress.setPercent(event.getProgress());
		  }
		 });
		 
		 cardUploader.addSuccessHandler(new SuccessEvent.SuccessHandler<UploadFile>() {
			  @Override
			  public void onSuccess(SuccessEvent<UploadFile> event) {
			   lblName.setText(event.getTarget().getName());
			   lblSize.setText(event.getTarget().getType());
			   imgPreview.setUrl(GWT.getHostPageBaseURL() + "uploadedFiles/" + event.getTarget().getName());
			  }
			 });
		 
		/*  cardUploader.addDragOverHandler(new DragOverEvent.DragOverHandler() {
			  @Override
			  public void onDragOver(DragOverEvent event) {
			    MaterialAnimator.animate(Transition.RUBBERBAND, cardUploader, 0);
			  }
			 });*/
		
		}
	
	 
	
	
	 @UiField
	 MaterialFileUploader cardUploader;
	
	 @UiField
	 MaterialImage imgPreview;
	
	 @UiField 
	 MaterialProgress progress;
	 
	 @UiField 
	 MaterialLabel lblName, lblSize;
	 
	 
	 
	
	 
	 
	
	
	
	
}


	
