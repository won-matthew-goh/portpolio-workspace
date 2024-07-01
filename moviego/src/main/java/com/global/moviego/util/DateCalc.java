package com.global.moviego.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateCalc {
  
  public static String getLastWeek() {
    
    DecimalFormat df = new DecimalFormat("00");
    Calendar currentCalendar = Calendar.getInstance();

  //일주일 전 날짜 구하기
    try {
      currentCalendar.add(currentCalendar.DATE, -7);
      String strYear7 = Integer.toString(currentCalendar.get(Calendar.YEAR));
      String strMonth7 = df.format(currentCalendar.get(Calendar.MONTH) + 1);
      String strDay7 = df.format(currentCalendar.get(Calendar.DATE));
      String strDate7 = strYear7 + strMonth7 + strDay7;
      return strDate7;
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  
  }
}
