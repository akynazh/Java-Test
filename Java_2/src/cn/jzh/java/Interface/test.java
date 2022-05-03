package cn.jzh.java.Interface;

public class test {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        mouse.open();
        mouse.open1();
        mouse.close();
        System.out.println(USB.NUM);
        USB.A();
        GameKeyBoard gkb = new GameKeyBoard();
        gkb.open();
        gkb.close();
    }
}
