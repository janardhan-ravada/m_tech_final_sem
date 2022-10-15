package com.directfromfarm.cart.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "product_id")
    private Long productId;

    @JoinColumn(name = "product_variant_id")
    private Long productVariantId;

    @JoinColumn(name = "consumer_id")
    private Long consumerId;

    @JoinColumn(name = "added_quantity")
    private Double quantity;

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(Long productVariantId) {
        this.productVariantId = productVariantId;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder().append(id, cart.id).append(productId, cart.productId).append(productVariantId, cart.productVariantId).append(consumerId, cart.consumerId).append(quantity, cart.quantity).isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37).append(id).append(productId).append(productVariantId).append(consumerId).append(quantity).toHashCode();
    }
}
