package com.tcs.restcommunication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestApiQuotes {
    private int id;
    private String quote;
    private String author;
}
