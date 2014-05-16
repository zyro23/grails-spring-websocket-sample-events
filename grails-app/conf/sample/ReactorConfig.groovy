package sample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import reactor.core.Environment
import reactor.core.Reactor
import reactor.core.spec.Reactors
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
	Reactor reactor() {
		return Reactors
			.reactor()
			.env(environment)
			.dispatcher(Environment.THREAD_POOL)
			.get()
	}
	
}
