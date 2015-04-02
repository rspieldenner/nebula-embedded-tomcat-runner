# Embedded Tomcat Runner

Provides an implementation of embedded Tomcat for the purpose of running a standalone server.

### Supported Tomcat versions

<table>
    <tr>
        <th>Major Version</th>
        <th>Concrete Version</th>
    </tr>
    <tr>
        <td>Tomcat 7</td>
        <td>7.0.59</td>
    </tr>
</table>

### Structure of distribution

Executing the Gradle task `distZip` will create a distribution of a runnable Tomcat instance. The JAR file on the root
level of the ZIP represents the executable Tomcat application. Its bundled manifest declares the main class name as well
as the classpath to the embedded Tomcat libraries.

    .
    |____embedded-tomcat7x-runner-x.x.jar
    |____libs
      |____ecj-4.4.jar
      |____tomcat-embed-core-7.0.59.jar
      |____tomcat-embed-el-7.0.59.jar
      |____tomcat-embed-jasper-7.0.59.jar
      |____tomcat-embed-logging-juli-7.0.59.jar

### Running the Tomcat instance

Extract the distribution ZIP file on your machine and execute the command `java -jar embedded-tomcat7x-runner-x.x.jar`.
You should see the output of Tomcat in your console. The output should look similar to this:

    Apr 02, 2015 10:02:03 AM org.apache.coyote.AbstractProtocol init
    INFO: Initializing ProtocolHandler ["http-bio-8080"]
    Apr 02, 2015 10:02:03 AM org.apache.catalina.core.StandardService startInternal
    INFO: Starting service Tomcat
    Apr 02, 2015 10:02:03 AM org.apache.catalina.core.StandardEngine startInternal
    INFO: Starting Servlet Engine: Apache Tomcat/7.0.59
    Apr 02, 2015 10:02:03 AM org.apache.catalina.startup.ContextConfig getDefaultWebXmlFragment
    INFO: No global web.xml found
    Apr 02, 2015 10:02:03 AM org.apache.coyote.AbstractProtocol start
    INFO: Starting ProtocolHandler ["http-bio-8080"]

By default the Tomcat instance is configured to hot reload class files of your application. Simply recompile one or many
of the classes in your project. After a couple of seconds you should see that Tomcat refreshes the context.

    Apr 02, 2015 10:02:33 AM org.apache.catalina.core.StandardContext reload
    INFO: Reloading Context with name [/test] has started

### Configuration options

The Tomcat instance can be configured through system properties. The following table shows all options, their default
 values as well as the system property used for providing a custom value.

<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Default Value</th>
        <th>System Property</th>
    </tr>
    <tr>
        <td>HTTP Port</td>
        <td>HTTP port used for server</td>
        <td><code>8080</code></td>
        <td><code>tomcatHttpPort</code></td>
    </tr>
    <tr>
        <td>Context Path</td>
        <td>Context path for application</td>
        <td><code>/test</code></td>
        <td><code>tomcatContextPath</code></td>
    </tr>
    <tr>
        <td>Classes Directory</td>
        <td>Directory containing compiled class files</td>
        <td><code>/build/classes/main</code></td>
        <td><code>tomcatClassesDir</code></td>
    </tr>
    <tr>
        <td>Web application base directory</td>
        <td>Directory containing web assets like HTML files, JSPs etc.</td>
        <td><code>WebRoot</code></td>
        <td><code>tomcatWebAppBaseDir</code></td>
    </tr>
    <tr>
        <td>Classpath files</td>
        <td>Comma-separated list of paths to external JAR files that will be added to the web application's classpath</td>
        <td>Empty list</td>
        <td><code>tomcatClasspathFiles</code></td>
    </tr>
</table>

Let's say you want to run on a different port. Simply add the following system property to your command execution:
`-DtomcatHttpPort=9090`.