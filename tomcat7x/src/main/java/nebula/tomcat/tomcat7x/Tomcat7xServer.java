package nebula.tomcat.tomcat7x;

import nebula.tomcat.embedded.TomcatServer;
import nebula.tomcat.embedded.TomcatServerException;
import nebula.tomcat.embedded.TomcatStartParameters;
import org.apache.catalina.Loader;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;
import org.apache.naming.resources.VirtualDirContext;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Tomcat7xServer implements TomcatServer {
    @Override
    public void start(TomcatStartParameters startParameters) {
        try {
            Tomcat tomcat = createEmbeddedServer(startParameters);

            StandardContext ctx = createContext(tomcat, startParameters);
            addClassesToContext(ctx, startParameters);
            addLibsToWebAppClasspath(ctx, startParameters);

            tomcat.start();
            System.out.println(buildStartMessage(startParameters));
            tomcat.getServer().await();
        }
        catch(Exception e) {
            throw new TomcatServerException(e);
        }
    }

    private Tomcat createEmbeddedServer(TomcatStartParameters startParameters) throws IOException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(startParameters.getPort());
        tomcat.setBaseDir(new File(new File(System.getProperty("user.home")), "embeddedTomcat7x").getCanonicalPath());
        return tomcat;
    }

    private StandardContext createContext(Tomcat tomcat, TomcatStartParameters startParameters) throws IOException, ServletException {
        StandardContext ctx = (StandardContext)tomcat.addWebapp(startParameters.getContextPath(), startParameters.getWebAppBaseDir().getCanonicalPath());
        ctx.setReloadable(true);
        return ctx;
    }

    private void addClassesToContext(StandardContext context, TomcatStartParameters startParameters) {
        VirtualDirContext resources = new VirtualDirContext();
        resources.setExtraResourcePaths("/WEB-INF/classes=" + startParameters.getClassesDir());
        context.setResources(resources);
    }

    private void addLibsToWebAppClasspath(StandardContext ctx, TomcatStartParameters startParameters) throws MalformedURLException {
        Loader loader = new WebappLoader();

        for(File classpathFile : startParameters.getClasspathFiles()) {
            loader.addRepository(classpathFile.toURI().toURL().toString());
        }

        ctx.setLoader(loader);
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