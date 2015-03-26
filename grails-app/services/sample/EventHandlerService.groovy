package sample

import org.springframework.messaging.simp.SimpMessageSendingOperations

import reactor.bus.EventBus
import reactor.spring.context.annotation.Consumer
import reactor.spring.context.annotation.Selector

@Consumer
class EventHandlerService {

	static transactional = false
	
	SimpMessageSendingOperations brokerMessagingTemplate
	EventBus eventBus
	
	@Selector("appEvents")
	void sendPushMessage(String message) {
		brokerMessagingTemplate.convertAndSend "/topic/pushMessages", message
		brokerMessagingTemplate.convertAndSend("/topic/pushMessagesPogo", new Pogo(name: "pogo"))
		brokerMessagingTemplate.convertAndSend("/topic/pushMessagesPogos", [new Pogo(name: "pogo1"), new Pogo(name: "pogo2")])
	}
	
}
