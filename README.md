# JPA-code-review
JPA-code-review

## 1회차(22.08.18~08.24)
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

