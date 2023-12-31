# 🐶 목차
1. MVC 적용하기 위해 지킨 규칙
2. MVC를 선택한 이유
3. 기능 목록
4. 객체 구조

---

## 🖋 MVC 적용하기 위해 지킨 규칙
1. Model은 Controller와 View에 의존하지 않아야 한다. 
   1. Model 내부에 Controller와 View에 관련된 코드가 있으면 간된다.
2. View는 Model에만 의존해야 하고, Controller에는 의존하면 안된다.
   2. View 내부에 Model의 코드만 있을 수 있고, Controller의 코드가 있으면 안된다.
3. View가 Model로부터 데이터를 받을 때는, 사용자 마다 다르게 보여주어야 하는 데이터에 대해서만 받아야 한다.변하지 않는 것은 view 자체적으로 가지고 있어야 한다.
4. Controller는 Model과 View에 의존해도 된다.
   4. Controller 내부에는 Model과 View의 코드가 있을 수 있다.
5. View 가 Model로부터 데이터를 받을 때는 반드시 Controller에서 받아야 한다.
-----
## 🔎 MVC 패턴을 선택한 이유
> MVC패턴을 선택한 이유는 처음에는 가장 흔히 들어서 였다. 하지만 10분 테코톡의 제리의 MVC
> 패턴 강의를 보고 A4지에 그려가며 공부한 후에는 왜 MVC인지 알게 되었다. MVC는 유지보수가 편해지는 코드
> 구성 방식이다. 즉, 변경에 유리한 코드라고 나는 받아들였다. 변경에 유리하다는 말이 위에 적은 5가지 규칙을 읽어보면
> 왜 변경에 유리한지 감이 올 것이다. 내가 느낀 것은 방향성이 있기 때문이라고 생각했다.
> 이것이 객체를 분리 했을 때의 가장 큰 장점이라고 생각했다.
> 
> 이번 주차 미션도 3주 차와 마찬가지로 글래스(객체)를 분리하는 연습을 하는 것이다.
> 그래서 객체 분리에 대해서 고민을 프리코스 전에는 해본적이 없었기에 2주차부터 흔히 들은
> MVC패턴을 내 마음대로 적용해서 클래스를 분리 했었다. 그러고 3주차에는 2주차 보다 규칙성을 가지고
> 적용하기 시작했다. 이번 4주차에는 위 5가지 규칙을 생각하며
> MVC 패턴을 적용 하고자 한다. 

## 🎄 크리스마스 프로모션 기능 설명 

[크리스마스 손님 기능]
1. input ( 정보 입력 )
   - 날짜 입력
   - 주문할 메뉴와 개수 입력

-----
[시스템 기능]
1. input 처리
   - 입력 날짜에 따라 할인 금액 체크 기능
   - 입력 값 저장 기능
   - 입력 메뉴 총 금액 계산 기능
2. 주문 금액에 따른 혜택 기능
   - 총 금액에 따라 증정 메뉴 고르는 기능
   - 할인 금액 계산 기능
   - 총 금액에 따라 배지 선택 기능
3. 총 할인 금액 계산 기능
   - 총 할인 금액 계산
-----

## 객체 분리

View
- InputView
  - 입력 받아야하는 부분을 입력 받아주는 기능
- OutputView
  - 출력 해야하는 부분을 Model의 데이터를 활용해 출력

Model
- Consumer
  - 소비자가 주문한 메뉴와 방문 날짜를 저장
- EventDiscount
  - 해당 날짜의 무슨 할인들이 들어갔는지 저장
- Menu
  - 메뉴들을 enum을 활용해 저장

Controller
- DiscountController
  - 할인을 계산해주어 Model에 저장하는 로직
- InputController
  - 입력 값을 검토하고 잘 쪼개어 Consumer객체에 데이터 저장
- TotalController

---