# Spring Boot를 이용한 첫번째 프로젝트  
   
  ------------  
  
<img src="https://image.yes24.com/momo/TopCate2763/MidCate003/274966717.jpg"  width="500" height="470">  
  
### 책을 참고하며 SpringBoot의 전반적인 흐름과 기능파악을 목적으로합니다.  
1. ~~인텔리제이로 스프링 부트 시작하기 / 2020-01-07~~
2. ~~스프링 부트에서 테스트코드를 작성하자 / 2020-01-08~~
3. ~~스프링 부트에서 JPA로 데이터베이스 다뤄보자 / 2020-01-09~~
4. ~~머스테치로 화면 구성하기 / 2020-01-10~~
5. 스프링 시큐리티와 OAuth2.0으로 로그인 기능 구현하기  
6. AWS 서버 환경을 만들어보자  
7. AWS에 데이터베이스 환경을 만들어보자 -AWS RDS  
8. EC2 서버에 프로젝트를 배포해 보자  
9. 코드가 푸시되면 자동으로 배포해 보자 -Travis CI 배포 자동화  
10. 24시간 365일 중단 없는 서비스를 만들자  
   
  ------------  
  

### 테스트코드  

#### TDD  
  
  <img src="https://marsner.com/wp-content/uploads/test-driven-development-TDD.png"  width="700" height="370">  
    
  - 테스트가 주도하는 개발(테스트 주도 개발)  
    1. 항상 실패하는 테스트를 먼저 작성하고(Red)  
    2. 테스트가 통과하는 프로덕션 코드를 작성하고(Green)  
    3. 테스트가 통과하면 프로덕션 코드를 리팩토링한다(Refactor)   
      
      
#### 단위테스트  
  - 단위테스트의 장점  
    1. 개발단계 초기에 문제를 발견하게 도와준다.  
    2. 단위 테스트는 개발자가 나중에 코드를 리팩로링하거나 라이브러리 업그레이드 등에서 기존 기능이 올바르게 작동하는 확인할 수 있다.  
    3. 단위 테스트는 기능에 대한 불확실성을 감소시킨다.  
    4. 단위 테스트는 시스템에 대한 실제 문서를 제공한다.  
      
      

   
  ------------  
  
  ### Spring 웹 계층  
    
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbFruEV%2FbtqAUv4HJLQ%2FH5TVBjqkKc5KBgD4Vdyvkk%2Fimg.png"  width="700" height="370">  
  
#### Web Layer  
- 흔히 사용하는 컨트롤러와 JSP/Freemaker등의 뷰 템플릿 영역  
- 이외에도 필터, 인터셉터, 컨트롤러 어드바이스 등 외부 요청과 응답에 대한 전반적인 영역을 이야기한다.  

#### Service Layer  
- @Service에 사용되는 서비스 영역  
- 일반적으로 Controller와 Dao의 중간영역에서 사용된다.  
- @Transactional이 사용되어야하는 영역이다.  

#### Repository Layer  
- Database와 같이 데이터 저장소에 접근하는 영역  
- 기존의 Dao영역으로 이해하면 된다.  

#### Dtos  
- Dto는 계층간에 데이터 교환을 위한 객체를 이야기하며, Dtos는 이들의 영역을 얘기한다.  
- 예를 들어 뷰 템플릿 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨줄 객체등이있다.  

#### Domain Model  
- 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화시킨 것을 도메인 모델이라한다.  
- @Entity가 사용된 영영 역시 도메인 모델이라고 이해하면 된다.  
- 다만, 무조건 데이터베이스의 테이블과 관계가 있어야 하는 것은 아니다.  
- VO처럼 값 객체들도 이 영역에 해당한다.  

  ------------  
    
  
  
  
