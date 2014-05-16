package sample

import javax.annotation.Resource

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class EventGenerator {

	@Resource
	EventGeneratorService eventGeneratorService
		
	@Scheduled(fixedRate = 5000l)
	void generate() {
		eventGeneratorService.generate()
	}
	
}
