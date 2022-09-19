package service.congressApi.domain.statistics;

import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity
@Data
public class RateByArea {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATE_BY_RATE_ID")
    private Long id;

    /**
     * 위원회 이름
     */
    private float congress;
    private float law;
    private float stateAffairs;
    private float finance;
    private float education;
    private float scienceAndTech;
    private float diplomacy;
    private float military;
    private float administration;
    private float culture;
    private float food;
    private float industry;
    private float health;
    private float environment;
    private float traffic;
    private float information;
    private float gender;
    private float budget;
    private float etc;




}
