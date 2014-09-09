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
		                var message = JSON.parse(message.body);
	                    $("#eventList").append("<li>new event: " + message + "</li>");
	                });
	                client.subscribe("/topic/pushMessagesPogo", function(message) {
		                var pogo = JSON.parse(message.body);
		                $("#eventList").append("<li>new pogo: " + pogo.name + "</li>");
	                });
	                client.subscribe("/topic/pushMessagesPogos", function(message) {
		                var pogos = JSON.parse(message.body);
		                $.each(pogos, function(idx, val) {
		                	$("#eventList").append("<li>new pogo: " + val.name + "</li>");
			            });
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
