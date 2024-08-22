package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class
        )
        // 예제 코드를 살리기 위해서 excludeFilters 추가.
        // 기본적으론 @ComponentScan 만 사용해도 상관 없음
)
public class AutoAppConfig {
}
