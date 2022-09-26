<h1>:office:국회의원이 발의한 법률안들에 대한 통계정보를 제공합니다.<h1>
Statistical Data On Legislation Proposed By Members of the National Assembly of Republic of Korea
<h6>:key: 본 프로젝트는 국회 OPEN API를 이용하여 제작되었습니다.<h6>
<h6>:page_facing_up: '열린국회정보'가 제공하는 <국회의원 발의법률안 API 명세서>에 참고하면 좋을 정보들을 담아 수정본을 만들었습니다. 해당 API를 이용하실 분들은 자유롭게 사용하시면 되겠습니다. 파일은 코드와 함께 첨부하였습니다.<h6>
<h6>:link: 프로젝트 과정 설명 포스팅 : https://dongdong-119.tistory.com/45</h6>
<h6>:wrench: 기술 스택<h6> 
  <img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=spring boot&logoColor=white"> 
  <img src="https://img.shields.io/badge/h2 database-FECC00?style=for-the-badge&logo=h2 database&logoColor=white">
  <img src="https://img.shields.io/badge/jpa-311C87?style=for-the-badge&logo=jpa&logoColor=white">
  <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css&logoColor=white">
  <img src="https://img.shields.io/badge/amcharts-FF6384?style=for-the-badge&logo=amcharts&logoColor=white">
  

  

  


<br/><br/>
<h3>:bar_chart:본 프로젝트는 다음과 같은 데이터를 제공합니다.<h3>
<p>1. 특정 국회의원이 발의한 법률안 수<p>
<p>2. 특정 국회의원이 발의한 최신 법률안 목록<p>
<p>3. 특정 국회의원이 발의한 법률안의 주제에 따른 분포<p>
<p>4. 특정 국회의원이 발의한 법률안의 처리 상태에 따른 분포<p>

<br/><br/>


<h5><그림 1: 메인페이지 - 국회의원 이름 및 소속 검색></h5>
<img width="1422" alt="Screen Shot 2022-09-21 at 10 52 59 AM" src="https://user-images.githubusercontent.com/85717356/191398207-d6b3da56-b8f1-45a6-853b-785c1cd39e6d.png">


<h5><그림 2, 3: 통계 info 페이지 - 국회의원 발의 법률안 통계 개괄, 분야별 발의, 처리상태별 정보 차트로 표시></h5>
<img width="1440" alt="Screen Shot 2022-09-26 at 4 20 26 PM" src="https://user-images.githubusercontent.com/85717356/192218483-e80a3709-b044-440a-b200-438de79a9f2e.png">
<img width="1440" alt="Screen Shot 2022-09-26 at 4 20 32 PM" src="https://user-images.githubusercontent.com/85717356/192217446-ba3877ba-5f12-439e-995f-7dc2c4f68b9f.png">



<h5><그림 3: 개관 및 각 통계에 대한 주의사항, 용어 정리를 확인할 수 있음><h5>
<img width="1440" alt="Screen Shot 2022-09-26 at 4 20 50 PM" src="https://user-images.githubusercontent.com/85717356/192218592-4d1e4ed0-af39-4747-9369-3c78c0fb3812.png">


<br/><br/><br/>


<h3>:hammer:개발/수정 내용:wrench:<h3>

> <h5>기본 기능 구현 2022.09.18 ~ 09.21.<h5>
<h6>- <국회의원 발의 법률안 API> 연동<h6>
<h6>- 법률안 관련 통계 데이터(rateByArea, rateByProcess) 로직 개발, 구현, 테스트<h6>
<h6>- <국회의원 발의 법률안 API> 명세서 수정<h6>
<h6>- 테스트 데이터 DB 저장<h6>
<h6>- 검색 페이지, 통계정보 페이지 구현<h6>
<h6>- 통계정보 뷰 전달 로직 및 차트 구현<h6>

<br/>

> <h3>수정 및 추가 기능 구현
> 2022.09.24 ~ 09.25.<h3>
<h6>- 선택한 의원이 최근에 발의한 법률안 목록 표시<h6>
<h6>- 분야별 법률안 차트 분류 수정<h6>
<h6>- 각 차트에 대한 설명, 용어 정리를 포함한 팝오버 추가<h6>
<h6>- 차트 색 수정<h6>
<h6>- 코드 리팩토링<h6>
