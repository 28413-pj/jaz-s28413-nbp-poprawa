package com.example.jaz_s28413_nbp.jaz_s28413_nbp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
public class GoldController {

    private final GoldService goldService;

    public GoldController(GoldService goldService) {
        this.goldService = goldService;
    }

    @Operation(summary = "Get And Put Into Database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Founfed",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoldData.class)) }),
            @ApiResponse(responseCode = "400", description = "Wrong request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "timeout",
                    content = @Content) })
    @GetMapping("/rate/gold/{startDate}/{endDate}")
    public ResponseEntity<AvgGold> getCurrency(@PathVariable("startDate") LocalDate dateFrom, @PathVariable("endDate") LocalDate dateTo){
        AvgGold avgGold;
        avgGold = goldService.calculate(dateFrom, dateTo);
        return ResponseEntity.ok(avgGold);
    }
}