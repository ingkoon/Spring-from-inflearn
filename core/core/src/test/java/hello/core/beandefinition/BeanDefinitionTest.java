package hello.core.beandefinition;

import hello.core.Appconfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac =   new AnnotationConfigApplicationContext(Appconfig.class);

    @Test
    @DisplayName(("빈 설정 메타 정보 확인"))
    void findApplicationBean() {
        //option + command + v 로 변수 선언
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinition = " + beanDefinition + "beanDefinition = " + beanDefinition);
            }
        }
    }
}
//팩토리 빈에서 팩토리 메서드가 호출이 된다라고 볼 수 있음
// 스프링은 beanDefinition을 통