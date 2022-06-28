package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
         //basePackages = "hello.core", --> 지정된 경로부터 컴포넌스스캔 진행 설정하지않을시 해당클래스파일 패키지 순서부터 진행
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// excludeFilters -> Configuration 어노테이션이 붙은 놈은 빼고 진행(기존 예제코드때문에)
public class AutoAppConfig {

}
