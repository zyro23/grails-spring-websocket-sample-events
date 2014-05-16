package sample

import reactor.core.Reactor
import reactor.event.Event

class EventGeneratorService {

	static transactional = false
	
	// TODO: remove when grails-events is ready
	Reactor reactor
	
	void generate() {
		println "generating event..."
		
		def key = "appEvents"
		def data = [id: UUID.randomUUID().toString()]
		// TODO: use grails-events when ready
		// event key: key, data: data
		reactor.notify key, Event.wrap(data)
	}
	
}
