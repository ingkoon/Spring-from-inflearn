package hello.core.singleton;

public class SingletonService {

    //static선언이기 떄문에 클래스 레벨에 올라가기 때문에 하나만 존재한다
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private  SingletonService() {
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출 ");
    }


}
