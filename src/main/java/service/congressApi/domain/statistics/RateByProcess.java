package service.congressApi.domain.statistics;


import lombok.Data;

import javax.persistence.*;


/**
 * 법률안 처리 상태 분포에 대한 통계값을 제공합니다.
 *
 * <법률안 처리 상태 분류>
 *  1. null, 2.
 */

@Entity
@Data
public class RateByProcess {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATE_BY_PROCESS_ID")
    private Long id;


    // 원안가결
    private float passNotRevised;

    // 수정가결
    private float passRevised;

    // 대안반영폐기
    private float alternative;

    // 부결
    private float rejected;

    // 철회
    private float withdrawal;

    // 폐기
    private float discard;

    // 기타(계류,)
    private float etc;

}
