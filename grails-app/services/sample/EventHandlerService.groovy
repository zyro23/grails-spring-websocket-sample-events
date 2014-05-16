package sample

import org.springframework.messaging.simp.SimpMessageSendingOperations

import reactor.core.Reactor
import reactor.spring.annotation.Selector

class EventHandlerService {

	static transactional = false
	
	SimpMessageSendingOperations brokerMessagingTemplate
	// TODO: remove when grails-events is ready
	Reactor reactor
	
	@Selector("appEvents")
	void sendPushMessage(Map<String, String> data) {
		brokerMessagingTemplate.convertAndSend "/topic/pushMessages", data
	}
	
}
