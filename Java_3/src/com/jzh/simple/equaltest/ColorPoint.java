package com.jzh.simple.equaltest;

import java.awt.*;
import java.util.Objects;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/16 22:56
 */
// Adds a value component without violating the equals contract
public class ColorPoint {
    private final Point point;
    private final Color color;
    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }
    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() { // 用于只比较点坐标时不违法比较的传递性
        return point;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof ColorPoint))
            return false;
        // 如果子类有自己的相等性概念，则必须使用getClass检测
//        if (o.getClass() != getClass()) return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }
}
