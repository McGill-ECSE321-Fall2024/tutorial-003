package ca.mcgill.ecse321.eventregistration.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.InPersonEvent;
import ca.mcgill.ecse321.eventregistration.model.OnlineEvent;
import ca.mcgill.ecse321.eventregistration.repository.EventRepository;
import jakarta.transaction.Transactional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepo;

    @Transactional
    public OnlineEvent createOnlineEvent(String name, LocalDate date, LocalTime startTime, LocalTime endTime,
            int registrationLimit, String url) {
        OnlineEvent event = new OnlineEvent(name, Date.valueOf(date), Time.valueOf(startTime), Time.valueOf(endTime),
                registrationLimit, url);
        return eventRepo.save(event);
    }

    @Transactional
    public InPersonEvent createInPersonEvent(String name, LocalDate date, LocalTime startTime, LocalTime endTime,
            int registrationLimit, String address) {
        InPersonEvent event = new InPersonEvent(name, Date.valueOf(date), Time.valueOf(startTime),
                Time.valueOf(endTime), registrationLimit, address);
        return eventRepo.save(event);
    }

    @Transactional
    public Event findEventById(int id) {
        return eventRepo.findEventById(id);
    }

    @Transactional
    public Iterable<Event> findAllEvents() {
        return eventRepo.findAll();
    }
}
