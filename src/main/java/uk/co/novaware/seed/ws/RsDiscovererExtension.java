package uk.co.novaware.seed.ws;

import org.apache.deltaspike.core.util.metadata.builder.AnnotatedTypeBuilder;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.util.AnnotationLiteral;
import javax.ws.rs.*;


public class RsDiscovererExtension implements Extension {
    public boolean enabled;

    public RsDiscovererExtension() {
        try {
            Class.forName("javax.ws.rs.GET");
            enabled = true;
        } catch (ClassNotFoundException e) {

        }
    }

    <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {

        if (enabled) {
            AnnotatedType<T> annotatedType = pat.getAnnotatedType();

            if (hasJaxRsAnnotaton(annotatedType)) {

                AnnotatedTypeBuilder<T> builder = new AnnotatedTypeBuilder<T>();
                builder.readFromType(pat.getAnnotatedType());
                builder.addToClass(new AnnotationLiteral<Default>() {

                });
                builder.addToClass(DiscoveredRs.LITERAL);
                pat.setAnnotatedType(builder.create());
            }
        }
    }

    private boolean hasJaxRsAnnotaton(AnnotatedType<?> annotatedType) {
        if (annotatedType.getAnnotation(javax.ws.rs.ext.Provider.class) != null) {
            return true;
        }
        for (AnnotatedMethod method : annotatedType.getMethods()) {
            if (method.getAnnotation(GET.class) != null || method.getAnnotation(POST.class) != null || method.getAnnotation(PUT.class) != null || method.getAnnotation(DELETE.class) != null || method.getAnnotation(OPTIONS.class) != null || method.getAnnotation(HEAD.class) != null) {
                return true;
            }
        }
        return false;

    }
}
