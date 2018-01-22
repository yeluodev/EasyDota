package com.yeluodev.easydota.entity.openapi;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/20 17:04
 * 修改人  yeluodev1226
 * 修改时间 2018/1/20 17:04
 * 备注
 */
public class TotalFiled {

    /**
     * field : kills
     * n : 1576
     * sum : 10472
     */

    private String field;
    private int n;
    private double sum;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
