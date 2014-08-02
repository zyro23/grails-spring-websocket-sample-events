package sample

import reactor.core.Reactor
import reactor.event.Event

class EventGeneratorService {

	static transactional = false
	
	Reactor reactor
	
	void generate() {
		println "generating event..."
		def key = "appEvents"
		def data = [id: UUID.randomUUID().toString()]
		reactor.notify key, Event.wrap(data)
	}
	
}
