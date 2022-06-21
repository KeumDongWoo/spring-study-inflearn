package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

// 싱글톤 방식의 위험성
public class StatefulServiceTest {

    @Test
    void statefulServiceSingletone() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //Thread A 사용자 1000원 주문
        statefulService1.order("userA",1000);
        //Thread B 사용자 2000원 주문
        statefulService2.order("userB", 2000);

        //Thread A 사용자 주문 금액 조회
        int price1 = statefulService1.getPrice();

        //Bean은 같은 인스턴스를 참조하기 때문에 1000원이 나올것 같지만 2000원이 나옴
        System.out.println(price1);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(2000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService() ;
        }
    }
}
