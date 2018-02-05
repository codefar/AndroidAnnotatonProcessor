package davy.utils.compiler.processor;

import com.google.auto.service.AutoService;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Set;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import static davy.utils.utils.Consts.ANNOTATION_TYPE_AUTOWIRED;
import static davy.utils.utils.Consts.ANNOTATION_TYPE_ROUTE;
import static davy.utils.utils.Consts.KEY_MODULE_NAME;

/**
 * author: wangyonghua
 * version: V1.0
 * date: 2018/2/5
 * time: 14:19
 */
@AutoService(Processor.class)
@SupportedOptions(KEY_MODULE_NAME)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({ANNOTATION_TYPE_ROUTE, ANNOTATION_TYPE_AUTOWIRED})
public class RouteProcessor extends BaseAbstractProcessor{

    private String moduleName = null;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        // Attempt to get user configuration [moduleName]
        Map<String, String> options = processingEnv.getOptions();
        if (MapUtils.isNotEmpty(options)) {
            moduleName = options.get(KEY_MODULE_NAME);
        }

        if (StringUtils.isNotEmpty(moduleName)) {
            moduleName = moduleName.replaceAll("[^0-9a-zA-Z_]+", "");
            logger.info("The user has configuration the module name, it was [" + moduleName + "]");
        } else {
            logger.error("These no module name, at 'build.gradle', like :\n" +
                    "apt {\n" +
                    "    arguments {\n" +
                    "        moduleName project.getName();\n" +
                    "    }\n" +
                    "}\n");
            throw new RuntimeException("ARouter::Compiler >>> No module name, for more information, look at gradle log.");
        }

        logger.info(">>> RouteProcessor init. <<<");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (CollectionUtils.isNotEmpty(annotations)) {
//            Set<? extends Element> routeElements = roundEnv.getElementsAnnotatedWith(Route.class);
//            try {
//                logger.info(">>> Found routes, start... <<<");
//                this.parseRoutes(routeElements);
//
//            } catch (Exception e) {
//                logger.error(e);
//            }
//            return true;
        }
        return false;
    }

    private void parseRoutes(Set<? extends Element> routeElements) {
        
    }
}
