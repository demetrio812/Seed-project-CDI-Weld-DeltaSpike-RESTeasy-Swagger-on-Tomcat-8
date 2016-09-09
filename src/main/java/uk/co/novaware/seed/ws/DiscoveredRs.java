package uk.co.novaware.seed.ws;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Qualifier;
import java.lang.annotation.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
public @interface DiscoveredRs {
	public static Annotation LITERAL = new AnnotationLiteral<DiscoveredRs>() {
	};
	
}