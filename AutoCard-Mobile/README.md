# AutoCard Mobile (Android starter)

이 브랜치는 원본 Windows 앱을 Android로 옮기기 위한 초기 프로젝트입니다.

## 현재 포함
- Android WebView에서 Classcard 접속
- 앱 안에서 로그인/세트 페이지 탐색
- 접근성 설정 화면 바로가기
- Android AccessibilityService 연결 지점
- GitHub Actions에서 Debug APK를 빌드하고 artifact로 업로드하는 워크플로

## 아직 구현되지 않은 기능
원본의 세트/단어 추출, 완료 상태 판별, 암기·리콜·스펠·테스트 모드 실행, 대기열, 자동 진행은 아직 이식되지 않았습니다.
Android WebView와 원본 Chrome DevTools Protocol 구현은 구조가 달라 별도 포팅과 기기 테스트가 필요합니다.
접근성 서비스는 현재 창 변경만 관찰하며 자동 클릭/정답 제출은 하지 않습니다.

## 빌드
Android Studio에서 프로젝트를 열거나, GitHub에 푸시한 뒤 Actions 탭에서 **Build Android APK**를 실행합니다.
성공하면 `AutoCard-Mobile-debug` artifact에서 `app-debug.apk`를 받을 수 있습니다.
