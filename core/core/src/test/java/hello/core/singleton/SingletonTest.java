package hello.core.singleton;

import hello.core.Appconfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        Appconfig appconfig = new Appconfig();
        MemberService memberService1 = appconfig.memberService();

        MemberService memberService2 = appconfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //계속 객체를 생성해야 한다.

        //memberservice1 != memberservice2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
