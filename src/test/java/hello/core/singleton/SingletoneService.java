package hello.core.singleton;

public class SingletoneService {
    // 1. static 영역에 객체를 딱 1개만 생성한다.
    private static final SingletoneService instance = new SingletoneService();

    // 2. public 으로 열어서 객체 인스턴스가 필요하면 이 static 매서드를 통해서만 조회하도록 허용한다.
    public static SingletoneService getInstance() {
        return instance;
    }

    // 3. 생성자를 private 으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하도록 막는다.
    private SingletoneService() {
    }

    public void logic() {
        System.out.println("싱긑톤 객체 로직 호출");
    }
}
