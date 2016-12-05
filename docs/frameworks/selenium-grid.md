---
layout: page
title: Selenium Grid
permalink: /frameworks/selenium-grid
---

### Overview
Selenium acts as an interface for the browser. Tests are written similar to unit tests and are annotated using the `@Test` annotation. Selenium Grid allows a test to connect to multiple browsers on multiple systems at once. Selenium can have one or more Nodes that connect to a central Hub, this setup it called 'grid'. The test communicates with the Hub and the Hub forwards the requests to the node that hosts the required browser.

### Setup
To get Selenium Grid running you need to download Selenium 3 from [http://www.seleniumhq.org/download/](http://www.seleniumhq.org/download/) and the Browser drivers that you want to use for your test. In this example I use the Chrome and Firefox (Mozilla Geckodriver) driver.

You can start the grid hub with the command:

```
java -jar selenium-server-standalone-[version].jar -role hub
```
This will start a grid hub server that will wait for nodes to connect. Now you can add your own system as a node using the command:

```console
java -Dwebdriver.gecko.driver=/opt/selenium/geckodriver 
     -Dwebdriver.chrome.driver=/opt/selenium/chromedriver 
     -jar selenium-server-standalone-3.0.1.jar 
     -port 5555 
     -role node 
     -hub http://localhost:4444/grid/register 
     -browser "browserName=firefox,version=ANY,maxInstances=10, platform=ANY, seleniumProtocol=WebDriver" 
     -browser "browserName=chrome,version=ANY,maxInstances=10,platform=ANY"
```
Be aware that you should change the webdriver.gecko.driver and webdriver.chrome.driver locations to where you placed the drivers, in my case the /opt/selenium folder.