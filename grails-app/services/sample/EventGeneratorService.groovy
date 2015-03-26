package sample

import reactor.bus.Event
import reactor.bus.EventBus


class EventGeneratorService {

	static transactional = false
	
	EventBus eventBus
	
	void generate() {
		println "generating event..."
		def key = "appEvents"
		def message = UUID.randomUUID().toString()
		eventBus.notify key, Event.wrap(message)
	}
	
}
