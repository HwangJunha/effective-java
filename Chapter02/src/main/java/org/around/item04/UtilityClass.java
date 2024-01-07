package org.around.item04;

// 코드 4-1 인스턴스를 만들 수 없는 유틸리티 클래스 (26~27쪽)
public class UtilityClass {
    // 기본 생성자가 만들어지는 것을 막는다(인스턴스화 방지용).
    private UtilityClass() {
        throw new AssertionError();
    }

    //유틸리티 클래스는 정적 메서드만 사용한다.
    public static String hello(){
        return "hello";
    }
    public static void main(String[] args){
        //에러!!
        //UtilityClass utilityClass = new UtilityClass();
        String hello = UtilityClass.hello();
        System.out.println(hello);
    }
}
