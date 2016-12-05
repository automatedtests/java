---
layout: page
title: Java | Selenium | TestNG
permalink: /frameworks/java-selenium-testng
---
### Overview
This project uses Selenium as an interface for the browser and testNG as the testing framework. Tests are written as normal unit tests and are annotated using the `@Test` annotation.

### Project requirements
- [Selenium grid](selenium-grid)
- A Java IDE such as [IntelliJ](https://www.jetbrains.com/idea/download/)
- [Maven](https://maven.apache.org/download.cgi)

### Test configuration
TestNG is responsible for the test configuration. TestNG configuration can be found in the `src/test/resources/testng.xml` file. At a minimum you should configure the url of the hub that you want to use:

```xml
<parameter name="hub_url" value="http://localhost:4444/wd/hub" />
```

Each test class should be part of a 'TestNG test', which represents a browser. In our example we specified that all test classes found in the package `nl.benkhard.testautomation.tests` should be executed in the browsers Firefox and Chrome, since its defined in both Test configurations:

```xml
<test name="Firefox">
    <parameter name="browser" value="firefox" />

    <packages>
        <package name="nl.benkhard.testautomation.tests" />
    </packages>
</test>

<test name="Chrome">
    <parameter name="browser" value="chrome" />

    <packages>
        <package name="nl.benkhard.testautomation.tests" />
    </packages>
</test>
```
The 'browser' parameter is used to select the actual browser that should be started.

### Test execution
The test can be started using maven `mvn test`. This will execute the default suite in the configuation file.
