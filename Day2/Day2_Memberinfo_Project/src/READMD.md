로그인 기능을 클래스로 구현해보자 (회원 정보클래스부터 구현)
프로젝트(MemberInfo_Project)
패키지(Memberinfo_Package)
@회원정보클래스(Member.class)의 구조
데이터 
*회원이름(String),아이디(String),암호(String),핸드폰(String)

기능 
*회원정보를 모두 입력받아서 저장할 수 있는 기능(setMemberInfo)
*모든 회원 정보를 출력하는 기능(putMemberInfo)
*회원정보를 각각 반환하는 기능(정보의 갯수만큼 필요)
getMemberName getMemberID getMemberPass getMemberPhone

========================================

프로그램 코드동작 테스트()
-Member클래스로 객체 생성
-생성된 객체에 회원 정보저장
-저장된 정보들을 각각확인함.(get계열의 메소드들을 이용해서 정보들을 반환받은 후 출력)
-저장된 정보들을 출려함