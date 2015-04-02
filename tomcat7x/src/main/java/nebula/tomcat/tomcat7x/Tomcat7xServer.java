package nebula.tomcat.tomcat7x;

import nebula.tomcat.embedded.TomcatServer;
import nebula.tomcat.embedded.TomcatServerException;
import nebula.tomcat.embedded.TomcatStartParameters;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.naming.resources.VirtualDirContext;

import java.io.File;

public class Tomcat7xServer implements TomcatServer {
    @Override
    public void start(TomcatStartParameters startParameters) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(startParameters.getPort());
            tomcat.setBaseDir(new File(new File(System.getProperty("user.home")), "embeddedTomcat7x").getCanonicalPath());

            StandardContext ctx = (StandardContext)tomcat.addWebapp(startParameters.getContextPath(), startParameters.getWebAppBaseDir().getCanonicalPath());
            ctx.setReloadable(true);

            VirtualDirContext resources = new VirtualDirContext();
            resources.setExtraResourcePaths("/WEB-INF/classes=" + startParameters.getClassesDir());
            ctx.setResources(resources);

            tomcat.start();
            System.out.println(buildStartMessage(startParameters));
            tomcat.getServer().await();
        }
        catch(Exception e) {
            throw new TomcatServerException(e);
        }
    }

    private String buildStartMessage(TomcatStartParameters startParameters) {
        StringBuilder message = new StringBuilder();
        message.append("Started server on port ");
        message.append(startParameters.getPort());
        message.append(" and context path '");
        message.append(startParameters.getContextPath());
        message.append("'");
        return message.toString();
    }
}