package hello.core.singleton;

// 싱글톤 방식의 위험성
public class StatefulService {

    private int price; //상태를 유지하는 필드

    public void order(String name , int price ){
        System.out.println("name = " + name + "price = " + price);
        this.price = price; // 여기부분이 문제!!!!
    }

    public int getPrice() {
        return price;
    }

}
