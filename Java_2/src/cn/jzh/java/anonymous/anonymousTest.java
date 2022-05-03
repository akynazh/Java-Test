package cn.jzh.java.anonymous;

public class anonymousTest {
    public static void main(String[] args) {
        new Person(){
            @Override
            public void speak() {
                System.out.println("anonymous person speak");
            }
        }.speak();

        new User<String>(){}.speak();
        //相当于下面这个
        // 新建一个类进行继承 class UserType extends User<String> {}
        new UserType().speak();
    }
}
abstract class Person{
    public abstract void speak();
}
class User<T> {
    public void speak() {
        System.out.println("anonymous user speak");
    }
}
class UserType extends User<String> {}