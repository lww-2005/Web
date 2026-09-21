package com.neuedu.controller;

import com.neuedu.dto.CalendarRequestDto;
import com.neuedu.dto.CalendarResponseDto;
import com.neuedu.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    //生成预约日历
    @RequestMapping("/listAppointmentCalendar")
//	http://localhost:8088/tijian/calendar/listAppointmentCalendar
//	{}
    public List<CalendarResponseDto> listAppointmentCalendar(@RequestBody CalendarRequestDto calendarRequestDto) {
        return calendarService.listAppointmentCalendar(calendarRequestDto);
    }
}
