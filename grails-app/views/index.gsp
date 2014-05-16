<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>grails-spring-websocket-sample-events</title>
		
		<asset:javascript src="jquery" />
		<asset:javascript src="spring-websocket" />
		
		<script type="text/javascript">
		 	$(function() { 
				var socket = new SockJS("${createLink(uri: '/stomp')}");
				var client = Stomp.over(socket);
			
				client.connect({}, function() {
	                client.subscribe("/topic/pushMessages", function(message) {
		                var data = JSON.parse(message.body);
	                    $("#eventList").append("<li>new event: " + data.id + "</li>");
	                });
	            });
		 	});
		 </script>
	</head>
	
	<body>
		<h1>Events</h1>
		<ul id="eventList"></ul>
	</body>
</html>
