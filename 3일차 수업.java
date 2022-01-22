~~.exe = 실행파일


<JAVA 설치> (집가서 설치)
버전이 낮을수록 안정화 되어 있음
우리는 12버전 사용

*설치시 주의점 :
1. jd-12.0.2어쩌고 파일 설치 
2. c드라이브 - program files - 자바 확인하기
내pc - 바탕 오른쪽 마우스 - 속성 - 고급시스템 설정 - 환경변수
아래쪽 시스템변수의 새로만들기 클릭 - 별칭 설정 (JAVA_HOME)
3. c드라이브-> program files -> java -> jdk-12 들어가서 주소창 복사 -> 복사한 내용이 변수 값임 
확인 
아래 path  - 편집 - 새로만들기 - %JAVA_HOME%\bin\ 입력 - 확인 버튼 계속
cmd - javac입력  - java -version입력

(*jdk= Java Development kit)

<설치한 java 삭제하기>
고급시스템설정 - 환경변수 - java_home 지우기 - path 들어가서 변수편집 -  %JAVA_HOME%\bin\ 삭제


<ssh 비밀키 생성 다시하기>
1. 프로필 - ssh and gpg keys(집열쇠만들기) - new ssh key  - 타이틀 (DW-ssh-window) 입력 
2. key 생성 : bash 열기 -  ssh-keygen -t rsa -C "das03041@gmail.com" 입력 + 엔터 한번 더 
3. enter same 옆에 비번 치기 (안보임)
4. pc - c - 사용자 - 23 - ssh 엑셀파일을 메모장으로 열기
5. 내용 복사 - 키에 입력 (이메일 바로 옆에 커서 두고 확인)


### IT용어
디폴트 : 기본 값을 의미 ex) 축구할 때 축구화는 기본 
--------------------------------------------------------------


-git과 연결이 안된 기러기 파일
1. git init 
2. git remote <주소>

-git과 연결이 된 참새 파일
git clone <주소>

위 작업을 했다 가정하고 (위 작업은 최초 한번만 진행)

1. 출근해서 git pull 실행 (팀원 추가 업무 확인)
2. git add . (업무 중 내가 한 작업이 있으면 업로드)
3. git commit (내가 한 작업 저장, 업로드 준비 완료)
4. git push (깃허브에 업로드 완료)

5.git config --global user.name "사용자 이름 입력"
6.git config --global user.email "내 이메일"

<프로젝트 만들기>
repsitory 들어가서 - new - public  - new - 체크박스x 

remote add origin git@github.com:daxnee/-.git




제어판 - 사용자계정 -  windows 자격증명관리 - github@다른사람꺼 - 제거 (다른 사람 주소가 있으면 push가 안됨)

아메리카노 추가