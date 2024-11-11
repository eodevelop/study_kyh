package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages 탐색할 패키지의 시작 위치를 지정한다
        // 없으면 모든 패키지를 찾아서 오래 걸린다.
        basePackages = "hello.core.member",
        // basePackageClasses 지정한 패키지의 클래스를 탐색 위치로 지정한다
        basePackageClasses = AutoAppConfig.class,
        // 예제 코드를 살리기 위해서 excludeFilters 추가.
        // 기본적으론 @ComponentScan 만 사용해도 상관 없음
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class
        )

        // 지정하지 않으면 현재 package로 선언된 `package hello.core;` 위치 부터 모든 코드를 뒤진다.

        // 권장하는 방법은 패키지의 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는방식을 권장
)
public class AutoAppConfig {
}
