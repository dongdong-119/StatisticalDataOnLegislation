<h1>:office:국회의원이 발의한 법률안들에 대한 통계정보를 제공합니다.<h1>
Statistical Data On Legislation Proposed By Members of National Assembly
<h6>:key:본 프로젝트는 국회 OPEN API를 이용하여 제작되었습니다.<h6>
<h6>:page_facing_up: '열린국회정보'가 제공하는 <국회의원 발의법률안 API 명세서>에 참고하면 좋을 정보들을 담아 수정본을 만들었습니다. 해당 API를 이용하실 분들은 자유롭게 사용하시면 되겠습니다. 파일은 코드와 함께 첨부하였습니다.<h6>
<br/>
<h3>:bar_chart:본 프로젝트는 다음과 같은 데이터를 제공합니다.<h3>
<p>1. 특정 국회의원이 발의한 법률안 수<p>
<p>2. 특정 국회의원이 발의한 법률안 목록<p>
<p>3. 특정 국회의원이 발의한 법률안의 주제에 따른 분포<p>
<p>4. 특정 국회의원이 발의한 법률안의 처리 상태에 따른 분포<p>

<br/>
<br/>

<h3>:hammer:개발/수정 내용:wrench:<h3>

> <h5>기본 기능 구현 2022.09.18 ~ 09.21.<h5>
<h6>- <국회의원 발의 법률안 API> 연동<h6>
<h6>- 법률안 관련 통계 데이터(rateByArea, rateByProcess) 로직 개발, 구현, 테스트<h6>
<h6>- <국회의원 발의 법률안 API> 명세서 수정<h6>
<h6>- 검색 페이지, 통계정보 페이지 구현<h6>
<h6>- 통계정보 뷰 전달 로직 및 차트 구현<h6>


<그림 1: 메인페이지 - 국회의원 이름 및 소속 검색>
<img width="1422" alt="Screen Shot 2022-09-21 at 10 52 59 AM" src="https://user-images.githubusercontent.com/85717356/191398207-d6b3da56-b8f1-45a6-853b-785c1cd39e6d.png">


<그림 2: 통계 info 페이지 - 국회의원 발의 법률안 통계 개괄, 분야별 발의, 처리상태별 정보 차트로 표시>
<img width="1422" alt="Screen Shot 2022-09-21 at 10 52 43 AM" src="https://user-images.githubusercontent.com/85717356/191398728-71587698-cbaa-4966-8e91-395077533d53.png">

<br/><br/>

> <h3>1차 수정 및 추가 기능 구현
> 2022.09.22 ~ (개발중)<h3>
