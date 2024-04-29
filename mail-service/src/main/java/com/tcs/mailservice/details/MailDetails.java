package com.tcs.mailservice.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDetails {
private String receiverMail;
private String subject;
private String body;
}
