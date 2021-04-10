package pt.learning.fundamentals.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pt.learning.fundamentals.dto.ApplicationInformationDto;
import pt.learning.fundamentals.service.ApplicationService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/application")
@AllArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping(produces = "application/json")
    public List<ApplicationInformationDto> findAll() {
        return applicationService.findAllApplications();
    }

    @GetMapping(path = "{name}", produces = "application/json")
    public ApplicationInformationDto findByName(@PathVariable("name") final String name) {
        return applicationService.findApplicationWithName(name);
    }

    @PostMapping(path = "create")
    public void createApplication(@RequestBody ApplicationInformationDto application) {
        applicationService.createApplication(application);
    }

}
