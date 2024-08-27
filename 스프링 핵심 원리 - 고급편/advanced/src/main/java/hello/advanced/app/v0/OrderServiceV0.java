package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// @RequiredArgsConstructor는 final 붙은 내용을 자동으로 생성자를 만들어주는데 이때
// 생성자가 하나인 경우 컴포넌트에서 자동으로 @Autowired 를 붙혀줘서 생략 가능하게 된다.
public class OrderServiceV0 {

    private final OrderRepositoryV0 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
