package sample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import reactor.Environment
import reactor.bus.EventBus
import reactor.spring.context.config.EnableReactor


/**
 * TODO: remove when grails-events is ready
 */
@Configuration
@EnableReactor
class ReactorConfig {

	@Autowired
	Environment environment
	
	@Bean
	EventBus eventBus() {
		return EventBus.create(environment, Environment.THREAD_POOL)
	}
	
}
