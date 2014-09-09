package sample

import org.springframework.messaging.simp.SimpMessageSendingOperations

import reactor.core.Reactor
import reactor.spring.annotation.Selector

class EventHandlerService {

	static transactional = false
	
	SimpMessageSendingOperations brokerMessagingTemplate
	Reactor reactor
	
	@Selector("appEvents")
	void sendPushMessage(String message) {
		brokerMessagingTemplate.convertAndSend "/topic/pushMessages", message
		brokerMessagingTemplate.convertAndSend("/topic/pushMessagesPogo", new Pogo(name: "pogo"))
		brokerMessagingTemplate.convertAndSend("/topic/pushMessagesPogos", [new Pogo(name: "pogo1"), new Pogo(name: "pogo2")])
	}
	
}
