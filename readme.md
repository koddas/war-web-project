# About this project

This project is a simple demo web application using Java annotations. It
runs on Java 7 and requires an application server, such as
[Glassfish](https://glassfish.java.net), to run\*. The project, built using
[Maven](http://maven.apache.org/), will produce a deployable WAR file. It
outputs JSON using Google's [Gson](http://code.google.com/p/google-gson/)
library, which is imported and bundled at build time.

The annotations used are defined in the
[JAX-RS API](http://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services).

\*\) Well, it actually doesn't. You can just as well embed a Java web container
in your project, such as [Jetty](http://eclipse.org/jetty/), and be done with
it. Using an application server is probably easier for beginners, though. 

# How do I build this project?

You can easily build the code directly from within your IDE of choice (I'm
personally rather fond of [Eclipse](http://www.eclipse.org)), using its build
features (in Eclipse, right click the project and select *Run As* ->
*Maven build*, type *package* into the *Goals* field, then *Run*). If you
prefer doing stuff more old school, you can use the command line to build the
project as well. To do so, you need to have Maven installed on your machine.
Navigate to your project location. Then, simply type

    mvn package

in your terminal. Your generated WAR file can be found as
*./target/wwp-1.0.0.war*.

# How do I run this project?

First of all, you'll need an application server. For this guide, I'll assume
you've installed Glassfish (for a guide on doing so, please refer to
Glassfish's [get started guide](https://glassfish.java.net/getstarted.html)).

Navigate to Glassfish's directory. Start Glassfish by executing the following
command from the command line:

    glassfish4/bin/asadmin start-domain

Open a new browser window/tab and type in *localhost:4848*. Find the
*Applications* link in the menu and click it. Next, click the *Deploy* button
and select *./target/wwp-1.0.0.war*. Once done, click the *Launch*
link and you're all set to try your new application. It will be made available
at *http://localhost:8080/wwp-1.0.0*.

# How do I configure my application?

## The web page

The web application (or *servlet* in Java lingo) comes with a very simple web
page. It is written in
[JSP](http://www.courses.coreservlets.com/Course-Materials/csajsp2.html), a web
language akin to ASP or PHP (although I only use standard HTML in this
example). You can put as many JSP pages as you wish in the *src/main/webapp/*
folder. Static resources, such as CSS files or images, are put in
*src/main/webapp/static/* and accessed by linking to *static/style.css* (for an
example CSS file).

## The application path

As you'll see, your application's URL needs to be amended with
*/webapi/service/* in order to actually do something. This isn't something that
is selected at random, but is set in your *web.xml* file (which you'll find in
*src/main/webapp/WEB-INF/*), as well as in your servlet Java file.

The */webapi/* part is set by the *<url-pattern>* directive in *web.xml*. The
*/service/* part is set by altering the argument to the initial *@Path*
annotation in the servlet's source code. In this case, that file is
*WebService.java*, that you'll find in *src/main/java/koddas/web/war*.

By changing these values and rebuilding (and consequent redeploying) your
project, you'll be able to reach your application with your fancy new path.
Please note that the links displayed on the web page will not change
accordingly, as they are set manually.