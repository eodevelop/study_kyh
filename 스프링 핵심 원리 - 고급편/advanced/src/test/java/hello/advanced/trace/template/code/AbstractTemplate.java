package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    // 부모 코드에 변하지 않는 템플릿 코드를 두고
    // 변하는 코드는 자식클래스에 둬서 상속과 오버라이딩을 통해 해결한다.

    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        call();
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    protected abstract void call();
}
