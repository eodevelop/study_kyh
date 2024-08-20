package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 이 부분을 안고치고 변경 가능하게 하려면?
    // 인터페이스의 구현 부분을 특정 클래스에 의존하는 코드가 여기에 있으면 안된다.
    // DIP를 위반한것. 결국 인터페이스에만 의존해야한다.
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 이 문제를 해결하기 위해선 누군가 대신 discountPolicy를 생성해서 주입해줘야 한다.
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
