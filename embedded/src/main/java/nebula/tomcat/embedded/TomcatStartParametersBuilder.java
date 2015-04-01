package nebula.tomcat.embedded;

import java.io.File;

public class TomcatStartParametersBuilder {
    public TomcatStartParameters build() {
        String tomcatPortSysProp = TomcatStartParameterSystemProperty.PORT.getProperty();
        String tomcatContextPathSysProp = TomcatStartParameterSystemProperty.CONTEXT_PATH.getProperty();
        String tomcatClassesDirSysProp = TomcatStartParameterSystemProperty.CLASSES_DIR.getProperty();
        String tomcatWebAppBaseDirSysProp = TomcatStartParameterSystemProperty.WEB_APP_BASE_DIR.getProperty();
        TomcatStartParameters startParameters = new TomcatStartParameters();

        if(tomcatPortSysProp != null) {
            startParameters.setPort(Integer.valueOf(tomcatPortSysProp));
        }

        if(tomcatContextPathSysProp != null) {
            startParameters.setContextPath(tomcatContextPathSysProp);
        }

        if(tomcatClassesDirSysProp != null) {
            startParameters.setClassesDir(new File(tomcatClassesDirSysProp));
        }

        if(tomcatWebAppBaseDirSysProp != null) {
            startParameters.setWebAppBaseDir(new File(tomcatWebAppBaseDirSysProp));
        }

        return startParameters;
    }
}
