package com.example.jaz_s28413_nbp.jaz_s28413_nbp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="gold")
public class GoldData {
    @Schema(description = "ID of request")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Gold ENUM")
    @Enumerated(EnumType.STRING)
    private Gold gold;

    @Schema(description = "StartDate")
    private LocalDate data_start;

    @Schema(description = "EndDate")
    private LocalDate data_end;

    @Schema(description = "AvaragePrice")
    private Double avgprice;

    @Schema(description = "Request Time")
    private LocalDateTime reqdate;

    public GoldData(){

    }

    public GoldData(Gold gold, LocalDate data_start, LocalDate data_end, LocalDateTime reqdate, Double avgprice) {
        this.gold = gold;
        this.data_start = data_start;
        this.data_end = data_end;
        this.reqdate = reqdate;
        this.avgprice = avgprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public LocalDate getData_start() {
        return data_start;
    }

    public void setData_start(LocalDate data_start) {
        this.data_start = data_start;
    }

    public LocalDate getData_end() {
        return data_end;
    }

    public void setData_end(LocalDate data_end) {
        this.data_end = data_end;
    }

    public Double getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(Double avgprice) {
        this.avgprice = avgprice;
    }

    public LocalDateTime getReqdate() {
        return reqdate;
    }

    public void setReqdate(LocalDateTime reqdate) {
        this.reqdate = reqdate;
    }
}