package com.tcs.restcommunication;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherReport {
String	name;
String  region;
String  country;
 double   lat;
double   lon;
  String tz_id;
  
  long  localtime_epoch;
  LocalDateTime localtime;

}
