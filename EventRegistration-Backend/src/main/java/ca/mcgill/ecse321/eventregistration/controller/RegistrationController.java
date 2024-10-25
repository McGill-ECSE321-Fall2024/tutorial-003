package ca.mcgill.ecse321.eventregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.eventregistration.dto.RegistrationResponseDto;
import ca.mcgill.ecse321.eventregistration.model.Registration;
import ca.mcgill.ecse321.eventregistration.service.RegistrationService;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService service;

    @PutMapping("/registration/{pid}/{eid}")
    public RegistrationResponseDto register(@PathVariable int pid, @PathVariable int eid) {
        Registration reg = service.register(pid, eid);
        return new RegistrationResponseDto(reg);
    }

    @GetMapping("/registration/{pid}/{eid}")
    public RegistrationResponseDto findRegistration(@PathVariable int pid, @PathVariable int eid) {
        Registration reg = service.findRegistration(pid, eid);
        return new RegistrationResponseDto(reg);
    }
}
