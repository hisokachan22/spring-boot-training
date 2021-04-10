package pt.learning.fundamentals.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pt.learning.fundamentals.dto.ApplicationInformationDto;
import pt.learning.fundamentals.entity.Application;
import pt.learning.fundamentals.repository.ApplicationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public List<ApplicationInformationDto> findAllApplications() {
        return applicationRepository.findAll().stream().map(a -> ApplicationInformationDto.builder()
                        .name(a.getName())
                        .description(a.getDescription())
                        .owner(a.getOwner())
                .build()).collect(Collectors.toList());
    }

    public ApplicationInformationDto findApplicationWithName(final String name) {
        Application application = applicationRepository.findByName(name).orElse(Application.builder().build());

        return ApplicationInformationDto.builder()
                .owner(application.getOwner())
                .description(application.getDescription())
                .name(application.getName()).build();
    }

    public void createApplication(final ApplicationInformationDto applicationInformationDto) {
        Application application = Application.builder().description(applicationInformationDto.getDescription())
                .name(applicationInformationDto.getName())
                .owner(applicationInformationDto.getOwner()).build();

        applicationRepository.save(application);
    }

    public void deleteApplication(final String name) {
        applicationRepository.deleteByName(name);
    }

}
