package nebula.tomcat.embedded;

import java.io.File;

public class TomcatStartParameters {
    private Integer port = 8080;
    private String contextPath = "/test";
    private File webAppBaseDir = new File("WebRoot");
    private File classesDir = new File("build/classes/main");

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

    @Override
    public String toString() {
        return "TomcatStartParameters{" +
                "port=" + port +
                ", contextPath='" + contextPath + '\'' +
                ", webAppBaseDir=" + webAppBaseDir +
                ", classesDir=" + classesDir +
                '}';
    }
}
