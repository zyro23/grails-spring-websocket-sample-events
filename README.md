# grails-spring-websocket-sample-events

Sample app using the spring-websocket plugin together with grails-events (at the moment just plain Reactor because I did not find a working grails-events release). Grails 2.4.0.RC2.

* `component-scan` active on package `sample` (`Config.groovy`)
* `SchedulingConfig`: enables spring scheduling (`grails-app/conf/sample`)
* `ReactorConfig`: enables reactor (`grails-app/conf/sample`) - this is likely just until a working grails-events release is out
* `EventGenerator`: triggers `EventGeneratorService` in a fixed interval (`src/groovy/sample`)
* `EventGeneratorService`: generates events and dispatches them via Reactor (`grails-app/services/sample`)
* `EventHandlerService`: listens for events via Reactor and if one is received, forwards it via websocket (`grails-app/services/sample`)
* `index.gsp`: super-minimalistic dummy UI (`grails-app/views`)
