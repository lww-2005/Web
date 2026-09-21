package com.neuedu.service;


import com.neuedu.dto.CalendarRequestDto;
import com.neuedu.dto.CalendarResponseDto;

import java.util.List;

public interface CalendarService {

    //生成预约日历
    public List<CalendarResponseDto> listAppointmentCalendar(CalendarRequestDto calendarRequestDto);

    public List<CalendarResponseDto> list(CalendarRequestDto calendarRequestDto);
}
