package hello.advanced.app.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// @RequiredArgsConstructor는 final 붙은 내용을 자동으로 생성자를 만들어주는데 이때
// 생성자가 하나인 경우 컴포넌트에서 자동으로 @Autowired 를 붙혀줘서 생략 가능하게 된다.
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
