# Mobile-Programming

## 첫번째 화면: 상품 선택 페이지
RelativeLayout을 사용하였습니다.   
빵 종합세트와 최신형 오븐 두개의 상품을 이미지는 ImageView에, 제품명과 가격은 TextView에 담았습니다.   
상품을 선택하기 위해 CheckBox를 사용하였습니다.   
상품을 선택한 후 장바구니 버튼을 누르면 장바구니 페이지로 이동되게 구현하였습니다.   
MainActivity에서 setOnClickListener를 사용하여 CheckBox가 선택되어있는 경우를 if문으로 나누었습니다.   
Intent를 이용하여 MainActivity와 secondActivity를 연결하여 intent.putExtra함수를 통해 선택한 상품의 정보와 이미지를 장바구니 페이지로 넘겨주었습니다.   
이미지 파일을 putExtra함수로 넘기기 위해 bitmap을 사용하였고 byteArray로 변경하여 보냈습니다.
아무 상품도 선택하지 않은 경우에는 Toast.makeText에 장바구니에 넣을 상품을 하나 이상 선택하라는 메세지를 띄어줍니다. 그리고 다음 페이지로 넘어가지 않게 return문을 넣어주었습니다.   
상품을 선택한 후 바로 구매 버튼을 누르면 구매 페이지로 이동되게 구현하였습니다.   

## 두번째 화면: 장바구니 페이지
LinearLayout을 사용하였습니다.   
큰 LinearLayout안에 두가지 작은 LinearLayout을 만들어 그 안에 체크박스, 제품명, 가격을 horizontal로 넣어주었습니다.   
상품 선택 페이지에서 넘겨준 정보를 받기 위해 getIntent()를 사용하였습니다.   
제품명, 가격은 TextView에 넣기 위해 name값을 이용해서 가져온 정보를 getExtras().getString으로 넣어주었습니다.  
이미지를 ImageView에 넣기 위해 가져온 정보를 byteArray로 받고 다시 bitmap으로 변환한 후 imageView에 넣어주었습니다.      
가져온 이미지 만 넣기 위해 if문으로 처리해서 배열이 비어있지 않은 경우에만 이미지를 넣었습니다.    
가져온 텍스트 정보가 비어있으면 그 제품의 checkBox와 필요없는 텍스트를 invisible로 주었습니다.   
홈 버튼을 누르면 상품 선택 페이지로 전환되게 구현하였습니다.   
구매 버튼을 누르면 MainActivity에서와 같은 방법을 사용하여 구매 페이지로 전환되게 구현하였습니다.   

## 세번째 화면: 구매 페이지
GridLayout을 사용하였습니다.   
EditText를 사용하여 주소와 연락처 정보를 입력받았습니다.   
선택된 정보를 SecondActivity에서 받아왔습니다.   
총 결제 금액을 구하기 위해 가격 정보를 Integer로 전환하여 계산하였습니다.    
주소와 연락처 정보를 입력하지 않으면 Toast.makeText로 정보를 입력하라는 메세지를 출력하고 return문을 통해 페이지가 전환되지 않게 하였습니다.   
결제하기 버튼을 누르면 상품 선택 페이지로 전환되고 Toast.makeText로 구매 완료되었다는 메세지와 함께 총 결제 금액을 출력해 주었습니다.   
___
실습환경   
Android SDK: Android 10.0(Q)   
Android AVD: Pixel 2 API 29   
갤럭시 S8도 연동하여 실습 해보았습니다
