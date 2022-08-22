===========================
은행입출금 프로젝트
*프로젝트*패키지*클래스
==========================
고객정보 클래스
[데이터]
-이름(String)
-계좌 번호(String)
-잔액(int)
=========================
[기능]
-입금
*사용자에게 금액을 입력받아서 잔액에 누적시킨다. 단, 음수를 입력할 경우 에러메시지가 출려되어야함
-출금
*사용자에게 금약을 입력받은 후 잔액에서 뺀다. 단, 잔액보다 많을경우 에러메시지가 출력되어야함
-잔액조회
*현재작액을 화면에 출력한다.
==========================
프로그램을 실행하는 클래스
(1)반복문을 사용해서 여러명의 고객들의 정보를 저장(setter)하도록 한다.(직접 입력해도되고, parameters 로 전달해도 됨)
(2)저장된 모든 고객들의 정보를 출력하도록 한다.(반복문)
(3)특정 고객의 이름이나 계좌번호를 입력받아서 검색이 가능하도록 해준다.(사용자 입력->이름 or 계좌 -> 해당데이터를 conatins로 검색 -> 결과출력)

=============================
잔액의 범위를 지정해서 그 정도 잔액이 있는 사람 출력


============================================================================
BANK 프로그램 처리 순서

------------------------
[1]계좌번호 입력
[2]프로그램 종료
-------------------------
(1) 프로그램이 실행되면 일단 계좌번호를 물어본다.
(2)여러명의 고객중에 일치하는 사람이 있으면 해당 고객정보(객체)를 임시변수에 연결해둔다.
(3) 실제 사용할 메인메뉴를 보여준다.(입금,출금,잔액조회,종료)
(4)입금메뉴를 선택하면 처리순사가 아래와 같다.
-입금액 입력
-입금액이 정상인지 아닌지 판단해서 처리(입금액 음수일 경우 에러처리)
-에러일 경우 다시 메인메뉴
-정상일 경우 잔액에 누적시키고 현재작액을 보여줌
(5)출금메뉴를 선택하면 처리순서가 아래와 같다
-출금액 입력
-출금액이 정상인지 아닌지 판단해서 처리(출금액이 잔액보다 클경우 에러처리)
-에러일 경우 다시 메인메뉴를 보여줌
-정상일 경우 잔액에서 차감시키고 현재잔액을 보여줌
(7) 종료를 선택하면 프로그램이 종료됨


//데이터를 저장하고 불러오는 장소가 필요(메모리-리스트, 하드드라이브-자바의 파일 입출력)
자바의 파일 입출력을 검색해서 코드로 만들어보세요
(1) 은행 고객정보를 객체에 저장한 후에 그것을 하드드라이브(원하는 위치)에 저장해보기
(2)저장해둔 객체의 정보를 다시 불러와서 화면에 출력해보기
===========================================================