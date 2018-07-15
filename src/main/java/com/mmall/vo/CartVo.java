package com.mmall.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Create by wangfei
 */
public class CartVo {

    private List<CartProductVo> cartProductVoList;
    private BigDecimal cartTotlePrice;
    private Boolean allChecked;     //是否已经都勾选
    private String imageHost;

    public List<CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List<CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public BigDecimal getCartTotlePrice() {
        return cartTotlePrice;
    }

    public void setCartTotlePrice(BigDecimal cartTotlePrice) {
        this.cartTotlePrice = cartTotlePrice;
    }

    public Boolean getAllChecked() {
        return allChecked;
    }

    public void setAllChecked(Boolean allChecked) {
        this.allChecked = allChecked;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
