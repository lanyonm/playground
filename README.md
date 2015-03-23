playground [![Build Status](https://travis-ci.org/lanyonm/playground.svg)](https://travis-ci.org/lanyonm/playground) [![Coverage Status](https://coveralls.io/repos/LanyonM/playground/badge.png)](https://coveralls.io/r/lanyonm/playground)
----------
A project to experiment with and demo Spring 4 integrations.


Running
-------
Assumming you have Java 7 and Maven 3:

	mvn package tomcat7:run


Testing
-------
Always be testing:

	mvn test

Travis will also take care of running tests after each push to GitHub.


Documentation
-------------
In the future, the github-site-plugin will be used to generate documentation.  For now, run `mvn site`.


TODO
----
* mybatis java config example
* logstash log4j example
