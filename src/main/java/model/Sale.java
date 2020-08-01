package model;

import java.math.BigDecimal;

public class Sale {

    private Long operation;
    private Long client;
    private Integer quantityTickets;
    private BigDecimal totalValue;
    private String status;

    public Sale(Long operation, Long client, Integer quantityTickets, BigDecimal totalValue) {
        this.operation = operation;
        this.client = client;
        this.quantityTickets = quantityTickets;
        this.totalValue = totalValue;
    }

    public Long getOperation() {
        return operation;
    }

    public void setOperation(Long operation) {
        this.operation = operation;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Integer getQuantityTickets() {
        return quantityTickets;
    }

    public void setQuantityTickets(Integer quantityTickets) {
        this.quantityTickets = quantityTickets;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "sale{" +
                "operation=" + operation +
                ", client=" + client +
                ", quantityTickets=" + quantityTickets +
                ", totalValue=" + totalValue +
                ", status='" + status + '\'' +
                '}';
    }
}
