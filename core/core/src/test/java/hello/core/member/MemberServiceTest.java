package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {


    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean("memberService", MemberService.class);

    @Test
    void join(){
        //given -> ~한 상황이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when -> ~했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then -> 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
