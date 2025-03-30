

Docker 버전 확인
```
docker -v
```


MySQL 이미지 다운
```
docker pull mysql
```


다운받아진 이미지 확인
```
docker images
```


MySQL 컨테이너 생성 & 실행
```
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=<password> -d -p 3306:3306 mysql:latest
```
● **--name <container_name>** : <container_name> 이름의 컨테이너를 실행한다.
● **-e** : 컨테이너 내에서 사용할 환경변수를 설정
● **-e MYSQL_ROOT_PASSWORD=\<password>** : MySQL의 root 권한의 비밀번호를 \<password>로 설정한다.
● **-d** : detach 모드로 컨테이너가 실행된다. 컨테이너가 백그라운드로 실행된다고 보면 된다.
● **-p** <호스트 포트> <컨테이너 포트> : 호스트와 컨테이너의 포트를 연결한다
● **mysql:latest** : 컨테이너에 사용할 이미지





### MySQL 포트 구분의 이유
1. **포트 충돌 방지**:  
    로컬 머신에서 이미 3306 포트를 사용하는 MySQL 서버가 실행 중일 경우, Docker에서 MySQL을 실행할 때 `3306:3306`으로 포트를 매핑하면 충돌이 발생합니다. 이를 방지하기 위해 `3305:3306`처럼 다른 포트를 지정하여 Docker 컨테이너와 로컬 MySQL 서버가 독립적으로 실행되도록 합니다.
    
2. **여러 인스턴스 실행**:  
    동일한 머신에서 여러 개의 MySQL 인스턴스를 실행하려면 각 인스턴스에 서로 다른 호스트 포트를 할당해야 합니다. 예를 들어, `3305:3306`, `3307:3306` 등으로 설정하여 여러 인스턴스를 동시에 실행할 수 있습니다.
    
3. **테스트 환경 분리**:  
    개발 및 테스트 환경에서 MySQL 서버를 구분하여 사용하려면 포트를 다르게 설정하는 것이 유용합니다. 이를 통해 로컬 MySQL 서버와 테스트용 Docker MySQL 서버를 분리하여 각각 독립적으로 관리할 수 있습니다.\

account