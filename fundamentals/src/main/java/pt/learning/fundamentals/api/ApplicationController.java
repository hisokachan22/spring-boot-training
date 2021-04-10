package pt.learning.fundamentals.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.learning.fundamentals.dto.ApplicationInformationDto;
import pt.learning.fundamentals.exceptions.ApplicationNotFoundException;
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
    public ResponseEntity<ApplicationInformationDto> findByName(@PathVariable("name") final String name) {
        try {
            return new ResponseEntity<ApplicationInformationDto>(applicationService.findApplicationWithName(name),
                    HttpStatus.OK);
        } catch (ApplicationNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getLocalizedMessage());
        }
    }

    @PostMapping(path = "create", consumes = "application/json")
    public void createApplication(@RequestBody ApplicationInformationDto application) {
        applicationService.createApplication(application);
    }

    @DeleteMapping(path = "{name}")
    public void deleteApplication(@PathVariable("name") final String name) {
        applicationService.deleteApplication(name);
    }

}
