package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter 누르고 탭하면 배열에 대한 for 문이 자동 생성된다.
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName  + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicaitonBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter 누르고 탭하면 배열에 대한 for 문이 자동 생성된다.
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //애플리케이션을 개발하기 위한 빈을 보여준다

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
           if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
               Object bean = ac.getBean(beanDefinitionName);
               System.out.println("name = " + beanDefinitionName  + " object = " + bean);
           }
        }
    }
}

