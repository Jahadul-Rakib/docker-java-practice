package com.example.testproject.domain;

import com.example.testproject.domain.enums.CarColor;
import com.example.testproject.domain.enums.CarType;
import com.example.testproject.domain.enums.EngineType;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "car_model", nullable = false)
    private String carModel;
    @Column(name = "car_type", nullable = false)
    private CarType carType;
    @Column(name = "car_color", nullable = false)
    private CarColor carColor;
    @Column(name = "engine_type", nullable = false)
    private EngineType engineType;
}
