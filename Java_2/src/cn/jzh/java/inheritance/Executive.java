package cn.jzh.java.inheritance;
/*
* 不允许扩展的类称为final类，可以阻止人们派生Executive类的子类，final类中所有方法自动成为final方法
* 类中某个特定方法也可以声明为final，这样子类就不能覆盖这个方法
* */
public final class Executive extends Manager {
    private double mInfluence;
    Executive(String name, int age, double salary, double bonus, double influence){
        super(name, age, salary, bonus);
        mInfluence = influence;
    }
    public double getInfluence(){
        return mInfluence;
    }
}
