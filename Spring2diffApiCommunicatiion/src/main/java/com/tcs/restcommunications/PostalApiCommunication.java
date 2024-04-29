package com.tcs.restcommunications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostalApiCommunication {
    private String Name;
    private String Description;
    private String PINCode;
    private String BranchType;
    private String DeliveryStatus;
    private String Circle;
    private String District;
    private String Division;
    private String Region;
    private String State;
    private String Country;
}
