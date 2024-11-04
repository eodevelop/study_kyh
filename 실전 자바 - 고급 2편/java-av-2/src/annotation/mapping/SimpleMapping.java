package annotation.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // 꼭 적어줘야 한다. 자세한건 나중에 이야기 해줌
public @interface SimpleMapping {
    String value();
}
