package br.com.microservices.sales.application.common;

import br.com.microservices.sales.domain.entity.Product;
import br.com.microservices.sales.persistence.entity.ProductEntity;

import java.io.Serializable;
import java.util.UUID;

public class CommonProduct implements Product, Serializable {

    private UUID id;
    private String code;
    private double unitValue;
    private CommonOrder order;

    private CommonProduct() {
    }
    @Override
    public UUID getId() {
        return id;
    }
    @Override
    public String getCode() {
        return code;
    }
    @Override
    public double getUnitValue() {
        return unitValue;
    }

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .code(getCode())
                .unitValue(getUnitValue())
                .build();
    }
    public static CommonProductBuilder builder() {
        return new CommonProductBuilder();
    }

    public void setOrder(CommonOrder commonOrder) {
        this.order = commonOrder;
    }

    public static final class CommonProductBuilder {
        private UUID id;
        private String code;
        private double unitValue;

        private CommonProductBuilder() {
        }
        public CommonProductBuilder id(UUID id) {
            this.id = id;
            return this;
        }
        public CommonProductBuilder code(String code) {
            this.code = code;
            return this;
        }
        public CommonProductBuilder unitValue(double unitValue) {
            this.unitValue = unitValue;
            return this;
        }
        public CommonProduct build() {
            CommonProduct commonProduct = new CommonProduct();
            commonProduct.id = this.id;
            commonProduct.code = this.code;
            commonProduct.unitValue = this.unitValue;
            return commonProduct;
        }
    }
}
