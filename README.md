# JPA-code-review
JPA-code-review

## 1회차(22.08.18~22.08.24)
### Done
- Article, Comment Entity 최소 기본 컬럼으로 설계
- 엔티티 공통 컬럼 BaseEntity(id, createdAt, modifiedAt) 로 분리하여 상속
- Jpa Auditing 적용하여 생성, 수정일시 자동 관리
- 게시글 리스트 조회 기능, 뷰 적용
- 게시글 작성폼 뷰 추가 및 입력값 유효성 검증
- 게시글 상세조회 기능, 뷰 적용
- 답변 작성 기능
<details>
<summary>view</summary>
<div markdown="1">
    <img width="960" alt="image" src="https://user-images.githubusercontent.com/48237976/186438213-8f3137cc-68ee-41a5-b2e3-030d22803bbf.png">
    <img width="1179" alt="스크린샷 2022-08-24 오후 11 05 54" src="https://user-images.githubusercontent.com/48237976/186439465-7bcb53c4-dcec-4fa0-bc7f-b136a61a41ca.png">
    <img width="1176" alt="스크린샷 2022-08-24 오후 11 07 28" src="https://user-images.githubusercontent.com/48237976/186439841-e990409a-b8f0-42df-b980-5fb34490518f.png">
</div>
</details>

## 2회차(22.08.25~22.09.04)
### Done
- BaseEntity id 필드 제거 및 Article, Comment Entity에 id 필드 추가
- 게시글 리스트 paging 적용(페이지 개수 고정)
- 로그인 기능 구현을 위한 SiteUser Entity 설계(추후 부가적인 필드 추가 예정) 및 권한 부여를 위한 UserRole 추가
- 회원가입 기능 구현 및 view 적용(추후 error message 처리, view 수정 예정)
- 회원 로그인, 로그아웃 기능 구현 및 view 적용
- navbar 추가 및 layout 적용(로그인 시 loginId, Logout 버튼 show, 로그아웃시 login 버튼 show)