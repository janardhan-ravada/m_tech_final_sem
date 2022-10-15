package com.directfromfarm.product.entity;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "product_variant")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="product_id")
    private Long productId;

    @Column(name="variant_description")
    private String variantDescription;

    @Column(name="unit_id")
    private Long unitId;

    @Column(name="unit_price")
    private Double unitPrice;

    @Column(name = "total_quantity")
    private Double totalQuantity;

    @Column(name = "available_quantity")
    private Double availableQuantity;

    public ProductVariant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Double getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductVariant that = (ProductVariant) o;

        return new EqualsBuilder().append(id, that.id).append(productId, that.productId).append(variantDescription, that.variantDescription).append(unitId, that.unitId).append(unitPrice, that.unitPrice).append(totalQuantity, that.totalQuantity).append(availableQuantity, that.availableQuantity).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(productId).append(variantDescription).append(unitId).append(unitPrice).append(totalQuantity).append(availableQuantity).toHashCode();
    }
}
