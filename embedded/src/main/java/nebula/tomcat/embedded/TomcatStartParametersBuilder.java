package nebula.tomcat.embedded;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TomcatStartParametersBuilder {
    public TomcatStartParameters build() {
        String tomcatPortSysProp = TomcatStartParameterSystemProperty.HTTP_PORT.getProperty();
        String tomcatContextPathSysProp = TomcatStartParameterSystemProperty.CONTEXT_PATH.getProperty();
        String tomcatClassesDirSysProp = TomcatStartParameterSystemProperty.CLASSES_DIR.getProperty();
        String tomcatWebAppBaseDirSysProp = TomcatStartParameterSystemProperty.WEB_APP_BASE_DIR.getProperty();
        String tomcatClasspathFilesSysProp = TomcatStartParameterSystemProperty.CLASSPATH_FILES.getProperty();
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

        if(tomcatClasspathFilesSysProp != null) {
            String[] sysPropClasspathFiles = tomcatClasspathFilesSysProp.split(",");
            List<File> classpathFiles = new ArrayList<File>();

            for(String sysPropClasspathFile : sysPropClasspathFiles) {
                classpathFiles.add(new File(sysPropClasspathFile));
            }

            startParameters.setClasspathFiles(classpathFiles);
        }

        return startParameters;
    }
}
