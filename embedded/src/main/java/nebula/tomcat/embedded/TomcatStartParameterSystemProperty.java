package nebula.tomcat.embedded;

public enum TomcatStartParameterSystemProperty {
    PORT("tomcatPort"),
    CONTEXT_PATH("tomcatContextPath"),
    CLASSES_DIR("tomcatClassesDir"),
    WEB_APP_BASE_DIR("tomcatWebAppBaseDir");

    private final String key;

    private TomcatStartParameterSystemProperty(String key) {
        this.key = key;
    }

    public String getProperty() {
        return System.getProperty(key);
    }
}
