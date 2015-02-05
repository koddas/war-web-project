# About this project

This project is a simple demo web application using Java annotations. It
runs on Java 7 and requires an application server, such as
[Glassfish](https://glassfish.java.net), to run\*. The project, built using
[Maven](http://maven.apache.org/), will produce a deployable WAR file. It
outputs JSON using Google's [Gson](http://code.google.com/p/google-gson/)
library, which is imported and bundled at build time.

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

in your terminal. Your generated JAR fileS can be found as
*./target/WarWebProject-1.0.0.jar*.

# How do I run this project?

First of all, you'll need an application server. For this guide, I'll assume
you've installed Glassfish (for a guide on doing so, please refer to
Glassfish's [get started guide](https://glassfish.java.net/getstarted.html)).

Navigate to Glassfish's directory. Start Glassfish by executing the following
command from the command line:

    glassfish4/bin/asadmin start-domain

Open a new browser window/tab and type in *localhost:4848*. Find the
*Applications* link in the menu and click it. Next, click the *Deploy* button
and select *./target/WarWebProject-1.0.0.jar*.

TODO: Skriv klart det här avsnittet.