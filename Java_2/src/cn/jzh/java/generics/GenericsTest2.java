package cn.jzh.java.generics;

public class GenericsTest2 {
    public static void main(String[] args) {
        // 上界通配符
        // 一个能放苹果以及一切是苹果子类的盘子
        Plate<? extends Apple> plate;

        plate = new Plate<>(new Apple());
        plate.getItem().describe();
        plate = new Plate<>(new RedApple());
        plate.getItem().describe();
        // plate = new Plate<>(new Fruit()); // 无法放置fruit
        // plate = new Plate<Pork>(new Pork()); // 无法放置猪肉

        // 副作用：只能get无法set
        // 通配符<?>和类型参数<T>的区别就在于，对编译器来说所有的T都代表同一种类型
        // 编译器无法判断后来set的类型是否可以替换原来的T
        // plate.setItem(new Apple()); // error



        // 下界通配符
        // 元素是Apple的超类，那往里存粒度比Apple小的都可以, 存粒度比Apple大的也可以
        Plate<? super Apple> plate1;
        plate1 = new Plate<>(new Apple());
        plate1 = new Plate<>(new RedApple());
        plate1 = new Plate<>(new Fruit());
        plate1 = new Plate<>(new Pork());
        plate1 = new Plate<>(new Meat());

        plate1.setItem(new Apple());
        plate1.setItem(new RedApple());
        // 进行set时，无法加入任何Apple的超类，只能加入Apple及其子类
        // 编译器不知道对象是Apple的哪个超类
        // plate1.setItem(new Fruit());

        // 副作用：只能set无法get，如果get也只能保存为obj对象，无法调用describe方法
        // plate1.getItem().describe();
        Object obj = plate1.getItem();

        /*
        PECS原则
        PECS（Producer Extends Consumer Super）原则
        频繁往外读取内容的，适合用上界Extends
        经常往里插入的，适合用下界Super
        */
    }
}

class Plate<T> {
    private T item;
    public Plate(T t) {item = t;}

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
abstract class Food {
    public abstract void describe();
}
class Fruit extends Food{
    public void describe() {
        System.out.println("fruit");
    }
}
class Meat extends Food {
    public void describe() {
        System.out.println("meat");
    }
}

class Apple extends Fruit {
    @Override
    public void describe() {
        System.out.println("apple");
    }
}
class RedApple extends Apple {
    @Override
    public void describe() {
        System.out.println("red apple");
    }
}
class Pear extends Fruit {
    @Override
    public void describe() {
        System.out.println("pear");
    }
}
class Pork extends Meat {
    @Override
    public void describe() {
        System.out.println("pork");
    }
}