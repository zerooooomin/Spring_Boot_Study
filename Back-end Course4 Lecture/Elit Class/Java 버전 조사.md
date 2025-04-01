# 버전 조사 이유
프로젝트를 진행할 때, 모든 행동에 이유를 찾는 것이 좋은 습관이라고 생각한다.

단순히 Java 버전을 고를 때에도 버전마다의 차이가 있다. 다양한 버전 중에 내가 하려고 하는 프로젝트에 맞는 버전을 찾는 것 또한 중요하다.


# LTS? Non-LTS?
### LST
(*Long Term Support*)
LTS 버전은 출시 후 수년간 보안 업데이트, 버그 수정 등 장기적인 지원을 제공하는 버전이다.
안정성이 높음

### Non-LTS
LTS 버전에 비해 지원 기간이 매우 짧다.
안정성이 상대적으로 낮다.



# Java 11
---
2018년 9월 출시
LTS 버전 (Long-Term Support) 
2024년 9월까지 지원
*(현재는 공식 지원 종료)*

Spring Boot 2.0 이후 버전 호환


### 특징
- 인터페이스에 private 메서드 가능
- ParallelGC에서 G1 GC로 기본 GC로 설정
- 람다 지역변수 var 키워드 사용 가능
- 컬렉션, 스트림 등 메소드 추가
- 지역 변수의 final 효과 확장


### 장점 : 
- 안정성
	- 오랜 기간 동안 많은 프로젝트에서 사용되었다.
- 자료의 방대함
	- 오랜 기간 서비스를 진행하여 인터넷에 정보가 많음.

### 단점 :
- LTS기간이 종료되므로, 유지보수가 필요한 프로젝트는 더 최신 LTS 버전으로 마이그레이션을 고려해야한다.




# Java 17
---
2021년 9월 출시
LTS 버전 (Long-Term Support) 
2029년 09월까지 지원

Spring boot 3.0 이후 버전 호환

### 특징
- recode class 키워드 사용 가능 - 불변 데이터 클래스를 간단히 정의.
- 난수 생성 API 추가
- 봉인 클래스(Sealed Class) 정식 추가
- String 여러 줄 사용시 텍스트 블록 기능 사용 가능
- NumberFormat, DateTimeFormatter 기능 향상
- Stream.toList() 사용 가능
- NullPointerException이 어떤 변수에 의해 발생했는지 설명
- ZGC 도입


### JVM 변경 사항 :
>JVM이란? (Java Virtual Machin) **OS에 종속받지 않고 CPU가 JAVA를 인식, 실행할 수 있게 하는 가상 컴퓨터** 입니다
- **ZGC (Z Garbage Collector) 개선:** 낮은 지연 시간을 목표로 하는 가비지 컬렉터인 ZGC가 프로덕션 준비 상태로 발전하여 **대규모 힙 메모리 관리 성능을 향상**시켰습니다.
- **NullPointerException 상세 메시지:** `NullPointerException` 발생 시 어떤 변수가 `null`인지 **더 명확하게 알려주는 상세 메시지를 제공**하여 디버깅을 용이하게 합니다.



# Java 21
---
23년 9월 출시
LTS (Long-Term Support)
2031년 09월까지 지원

Spring boot 3.0 이후 버전 호환


### 특징
- **Virtual Threads** : 수천~수만 개 스레드도 가볍게 생성 가능 → 동시성·성능 대폭 향상.
- **Pattern Matching for switch** : `switch` 문에서 다양한 타입·패턴 매칭 문법.
- **Record Patterns** : 레코드와 패턴 매칭을 결합해, 데이터 추출과 바인딩을 간결화.
- **Sequenced Collections** : 순서를 보장하는 컬렉션 인터페이스 표준화.
- **String Templates** : 문자열 안에서 변수 삽입·포매팅을 편리하게 지원.



### 가상 쓰레드 Virtual Thread

##### 프로세스(process)란?
>프로세스(process)란 단순히 실행 중인 프로그램(program)이라고 할 수 있습니다.
>즉, 사용자가 작성한 프로그램이 운영체제에 의해 메모리 공간을 할당받아 실행 중인 것을 말합니다. 이러한 프로세스는 프로그램에 사용되는 데이터와 메모리 등의 자원 그리고 스레드로 구성됩니다.
---
##### 스레드(thread)란?
>스레드(thread)란 프로세스(process) 내에서 실제로 작업을 수행하는 주체를 의미합니다. 모든 프로세스에는 한 개 이상의 스레드가 존재하여 작업을 수행합니다. 또한, 두 개 이상의 스레드를 가지는 프로세스를 멀티스레드 프로세스(multi-threaded process)라고 합니다.
![[Pasted image 20250330145234.png]]

##### IO중심 어플리케이션에서 성능 향상
- DB 연동, 외부 API 연동이 많은 서비스
- 더 적은 메모리, CPU 사용으로 더 높은 처리량 달성

### CPU를 사용하는 API 성능 비교
- Spring boot + 피보니치 계산 + 1000사용자 + 30분
- 플랫폼 쓰레드와 Virtual Thread 간 처리량, 평균 실행 시간의 큰 차이는 없음.
- 단, 쓰레드 개수에서 차이
	- 플랫폼 쓰레드 -> 235개
	- 가상 쓰레드 -> 43개 ( 더 적은 메모리 )
> https://blog.fastthread.io/virtual-threads-performance-in-spring-boot/


기존 Java 코드를 수정할 필요 X



