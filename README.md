# 💫 Outstagram 💫


### 💁‍♀️ 프로젝트 소개 🎤 
이 프로젝트는 제가 제일 자주 사용하는 어플인 인스타그램을 보고 해당 기능들을 직접 구현해 보고 싶어 만들게 되었습니다.

아래와 같이 인스타그램에서 제일 핵심이 되는 기능들을 본 떠 구현했습니다.
* 팔로우와 팔로우 및 팔로잉 목록보기 기능
* 내가 팔로우 한 친구들의 최근 게시물들을 모아 볼 수 있는 타임라인 기능 
* 나의 게시물들을 모아 보거나 특정 친구의 게시물을 모아 볼 수 있는 개인 홈 피드 기능
* 친구 찾기와 좋아요 및 댓글쓰기 기능을 구현했습니다. 


### 🛠 설계 🛠
* UI 기획서

  https://ovenapp.io/project/PTE75wkSLeiZRRG7tmxST1qY0NTyzvVN#InoFp
* DB 설계, URL 설계
 
  https://docs.google.com/spreadsheets/d/1ay-0BJAKlcRqr0WtQDLaxIPyscPoNUEq6H_3Iwo2j_E/edit?usp=sharing
  
  
###  🔥 주요기능 🔥
1. 회원 가입 & 로그인 & 다른 유저 찾기 기능
> - 관련 패키지 : https://github.com/sohyun119/Outstagram/tree/master/src/main/java/com/SH/outstagram/user
> * 회원 가입 view : https://github.com/sohyun119/Outstagram/blob/master/src/main/webapp/WEB-INF/jsp/user/signUp.jsp
> * 로그인 view : https://github.com/sohyun119/Outstagram/blob/master/src/main/webapp/WEB-INF/jsp/user/signIn.jsp
> * 다른 유저 검색 view : https://github.com/sohyun119/Outstagram/blob/master/src/main/webapp/WEB-INF/jsp/user/searchView.jsp

2. 타임라인 & 피드 & 게시물 상세보기 & 게시물 올리기 기능
> - 관련 패키지 : https://github.com/sohyun119/Outstagram/tree/master/src/main/java/com/SH/outstagram/post
> * 타임라인 view : https://github.com/sohyun119/Outstagram/blob/master/src/main/webapp/WEB-INF/jsp/post/timelineView.jsp
> * 피드 view : https://github.com/sohyun119/Outstagram/blob/master/src/main/webapp/WEB-INF/jsp/post/feed.jsp
> * 게시물 상세보기 view : https://github.com/sohyun119/Outstagram/blob/master/src/main/webapp/WEB-INF/jsp/post/detailView.jsp
> * 게시물 올리기 view : https://github.com/sohyun119/Outstagram/blob/master/src/main/webapp/WEB-INF/jsp/post/createView.jsp



### 💡 데모 영상 💡

#### ✨ 회원가입 및 로그인 기능
![sign.gif](demo/sign.gif)

#### ✨ 타임라인 화면 및 좋아요, 댓글 달기 기능
![timeline.gif](demo/timeline.gif)

#### ✨ 다른 사용자 피드 및 팔로우 기능 ( + 팔로워, 팔로잉 리스트 보기 )
![otherUserFeed.gif](demo/otherUserFeed.gif)

#### ✨ 다른 사용자 검색 기능 
![search.gif](demo/search.gif)

#### ✨ 나의 피드(home) 및 게시물 업로드 기능
![myFeed.gif](demo/myFeed.gif)



### 🔎 외부 라이브러리 라이센스
* Spring Framework Apache License 2.0
* tomcat Apache License 2.0
* bootstrap MIT License
* jQuery MIT License
* MySQL GPL

### 📕 사용한 기술 스택
<div class="d-flex">
<img src="https://img.shields.io/badge/java-orange?style=flat-square&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/>
<img src="https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jQuery&logoColor=white"/>
<img src="https://img.shields.io/badge/JavaScript-black?style=flat-square&logo=JavaScript&logoColor=F7DF1E"/>
<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white"/>
<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>
</div>
