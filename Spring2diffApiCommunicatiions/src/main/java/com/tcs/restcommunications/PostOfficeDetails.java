package com.tcs.restcommunications;

import java.util.List;

import lombok.Data;

@Data
public class PostOfficeDetails {
    private String name;
    private String description;
    private String branchType;
    private String deliveryStatus;
    private String circle;
    private String district;
    private String division;
    private String region;
    private String state;
    private String country;
	public List<PostOfficeDetails> getPostOffice() {
		// TODO Auto-generated method stub
		return null;
	}

}
