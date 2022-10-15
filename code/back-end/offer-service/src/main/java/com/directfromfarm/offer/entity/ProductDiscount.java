package com.directfromfarm.offer.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "product_discount")
public class ProductDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_variant_id")
    private Long productVariantId;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "unit_price_with_discount")
    private Double unitPriceWithDiscount;

    @Column(name = "discount_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar discountStartDate;

    @Column(name = "discount_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar discountEndDate;

    @Column(name="offer_id")
    private Long offerId;

    public ProductDiscount() {
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

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getUnitPriceWithDiscount() {
        return unitPriceWithDiscount;
    }

    public void setUnitPriceWithDiscount(Double unitPriceWithDiscount) {
        this.unitPriceWithDiscount = unitPriceWithDiscount;
    }

    public Calendar getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(Calendar discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public Calendar getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(Calendar discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductDiscount that = (ProductDiscount) o;

        return new EqualsBuilder().append(id, that.id).append(productId, that.productId).append(productVariantId, that.productVariantId).append(discountType, that.discountType).append(discountAmount, that.discountAmount).append(unitPriceWithDiscount, that.unitPriceWithDiscount).append(discountStartDate, that.discountStartDate).append(discountEndDate, that.discountEndDate).append(offerId, that.offerId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(productId).append(productVariantId).append(discountType).append(discountAmount).append(unitPriceWithDiscount).append(discountStartDate).append(discountEndDate).append(offerId).toHashCode();
    }
}
