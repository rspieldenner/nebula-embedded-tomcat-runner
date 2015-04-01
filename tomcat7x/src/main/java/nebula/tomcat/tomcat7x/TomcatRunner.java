package nebula.tomcat.tomcat7x;

import nebula.tomcat.embedded.TomcatServer;
import nebula.tomcat.embedded.TomcatStartParameters;
import nebula.tomcat.embedded.TomcatStartParametersBuilder;

public class TomcatRunner {
    public static void main(String[] args) {
        TomcatStartParameters startParameters = new TomcatStartParametersBuilder().build();
        TomcatServer server = new Tomcat7xServer();
        server.start(startParameters);
    }
}
