package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletoneTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletoneServiceTest() {
        SingletoneService singletoneService1 = SingletoneService.getInstance();
        SingletoneService singletoneService2 = SingletoneService.getInstance();

        System.out.println(singletoneService1);
        System.out.println(singletoneService2);

        Assertions.assertThat(singletoneService1).isSameAs(singletoneService2);
    }

    @Test
    @DisplayName("스프링 없는 순수한 컨테이너")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("MemberService 1 = " + memberService1);
        System.out.println("MemberService 2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
