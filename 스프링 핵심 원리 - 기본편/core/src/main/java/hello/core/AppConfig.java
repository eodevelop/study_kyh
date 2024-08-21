package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 해당 코드를 통해 사용 영역의 코드는 권한은 줄었지만 책임이 더욱 명확해 졌다.
@Configuration
// 이 어노테이션이 없어도 Bean 의 생성은 정상적으로 처리되지만 CGB를 사용하는 방식의 객체를 만들지 않아
// 싱글톤 방식을 보장하지 못하게 된다.
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 이 코드 상황에서 분명 이 메소드는 3번 호출되야 하는게 맞지만 놀랍게도 이 메소드는 한번만 호출된다.
    // 그 비밀은 @Configuration 안에 있다.
    // @Configuration 이 붙은 AppConfig는 객체로 바로 사용되는 것이 아닌
    // 이 클래스를 상속받은 다른 클래스를 만들어 내서 그 클래스를 객체로 만들어낸다.
    // 그 객체 내부에선 해당 객체 생성 부분을 이미 만들어진 빈 여부를 판단 후 재활용 및 생성하는 방식을 사용한다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 해당 영역이 변경하여, 사용 영역에 코드의 변경을 전혀 하지 않고도 정책을 변경할 수 있게된다.
        return new RateDiscountPolicy();
    }
}
