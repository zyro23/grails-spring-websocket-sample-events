grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.tomcat.nio = true

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
		
		// TODO: why did jcenter() not do the trick but explicit mavenRepo did?
		mavenRepo "http://jcenter.bintray.com"
    }

    dependencies {
		// TODO: use when grails-events is ready
		//compile "org.grails.plugins:events:1.0.0.M1"
		// TODO: remove when grails-events is ready
		compile "org.projectreactor:reactor-spring:1.0.1.RELEASE", {
			excludes "spring-core", "spring-expression", "spring-beans", "spring-context", "spring-context-support"
		}
		
    }

    plugins {
        build ":tomcat:7.0.53"

		compile ":asset-pipeline:1.8.7"
        compile ":cache:1.1.6"
		compile ":scaffolding:2.1.0"
		compile ":spring-websocket:1.0.0"

        runtime ":hibernate4:4.3.5.3" // or ":hibernate:3.6.10.13"
        runtime ":database-migration:1.4.0"
        runtime ":jquery:1.11.1"
    }
}
