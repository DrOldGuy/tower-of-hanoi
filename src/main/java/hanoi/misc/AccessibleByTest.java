/**
 * 
 */
package hanoi.misc;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This annotation is used to indicate that a field or method has greater accessibility than
 * expected. The field or method is designed to be accessed by a test.
 * 
 * @author Promineo
 *
 */
@Retention(CLASS)
@Target({FIELD, METHOD})
public @interface AccessibleByTest {

}
