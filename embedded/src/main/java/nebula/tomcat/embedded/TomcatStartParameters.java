package nebula.tomcat.embedded;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TomcatStartParameters {
    /**
     * The port used to run the embedded Tomcat server. Defaults to {@code 8080}.
     */
    private Integer port = 8080;

    /**
     * The context path used for the web application. Defaults to {@code /test}.
     */
    private String contextPath = "/test";

    /**
     * The web application base directory containing web resources like JSPs, HTML files etc. Defaults to {@code WebRoot}.
     */
    private File webAppBaseDir = new File("WebRoot");

    /**
     * The directory containing compiled class files. Defaults to {@code build/classes/main}.
     */
    private File classesDir = new File("build/classes/main");

    /**
     * The files to be added to the classpath of the web application. Defaults to an empty list.
     */
    private List<File> classpathFiles = new ArrayList<File>();

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public File getWebAppBaseDir() {
        return webAppBaseDir;
    }

    public void setWebAppBaseDir(File webAppBaseDir) {
        this.webAppBaseDir = webAppBaseDir;
    }

    public File getClassesDir() {
        return classesDir;
    }

    public void setClassesDir(File classesDir) {
        this.classesDir = classesDir;
    }

    public List<File> getClasspathFiles() {
        return classpathFiles;
    }

    public void setClasspathFiles(List<File> classpathFiles) {
        this.classpathFiles = classpathFiles;
    }

    @Override
    public String toString() {
        return "TomcatStartParameters{" +
                "port=" + port +
                ", contextPath='" + contextPath + '\'' +
                ", webAppBaseDir=" + webAppBaseDir +
                ", classesDir=" + classesDir +
                ", classpathFiles=" + classpathFiles +
                '}';
    }
}
