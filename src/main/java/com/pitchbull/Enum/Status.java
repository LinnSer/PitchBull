package com.pitchbull.Enum;

import lombok.Getter;

@Getter
public enum Status {
	STOP("STOPPED"), 
	BOOT("BOOTING"), 
	START("STARTED");
	
	
    private final String status;
	  
    	    private Status(String status) {
    	        this.status = status;
    	    }
}
