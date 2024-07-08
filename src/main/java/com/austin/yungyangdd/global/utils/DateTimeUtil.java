package com.austin.yungyangdd.global.utils;



import com.austin.yungyangdd.global.dto.DateDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {


    public static DateDTO convertToLocalDateByString(String startDate, String endDate, DateDTO dateDTO){

        dateDTO.setStartedDate(LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dateDTO.setEndedDate(LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return dateDTO;
    }

}
