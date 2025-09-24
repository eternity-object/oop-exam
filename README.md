객체지향 설계 과제

### **[실습 코드]**

과제 리파지토리(https://github.com/eternity-object/oop-exam.git)를 개인 리파지토리로 fork 합니다.

fork 한 프로젝트를 clone해서 열어보면 다음과 같은 클래스로 구성된 Spring Boot 애플리케이션을 확인할 수 있습니다.

- Lecture : 강의 제목, 날짜, 일수를 데이터로 포함하는 클래스
- LectureReporter : Lecture 클래스를 JSON, CSV, XML 중 하나로 변환한 후 데이터베이스나 파일에 기록하는 클래스
- MainApplication : Lecture와 LectureReporter를 생성한 후 실행하는 Spring Boot 메인 클래스

LectureReporter 클래스를 보면 아래와 같이 포맷과 저장 스토리지 타입에 따라 분기를 처리하는 로직이 존재합니다.

Lecture 클래스는 JSON, CSV, XML 포맷으로 변경할 수 있고, 데이터베이스와 파일에 저장할 수 있습니다.

### **[문제]**

새로운 포맷과 스토리지 타입이 계속 추가된다고 가정하고 현재 코드를 SOLID 원칙에 따라 리팩터링하세요.

힌트: 인터페이스와 의존성 주입을 활용하시면 수월하게 문제를 해결하실 수 있습니다.

### **[풀이]**

- formatter, storage 인터페이스 생성하여 기능 추상화
- LectureReporter 생성시점에 객체주입하도록 DIP화