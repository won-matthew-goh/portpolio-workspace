### 최종 DB 테이블 설계

1. **users 테이블**
   - 사용자 정보를 저장합니다.
   - **컬럼**
     - `user_id` (PK): 사용자 고유 ID (자동 증가)
     - `username`: 사용자 이름 (중복 불가)
     - `passwd`: 사용자 비밀번호 (해시된 형태)
     - `email`: 사용자 이메일 (중복 불가)
     - `created_at`: 계정 생성일시
     - `provider` : 사용자가 가입한 소셜 로그인 제공업체 (예: 네이버, 카카오, 자체 제공)
     - `provider_id` : 소셜 로그인 제공업체에서 제공하는 사용자 고유 ID

2. **movies 테이블**
   - 영화 API로부터 가져온 영화 정보를 저장합니다.
   - **컬럼**
     - `movie_id` (PK): 영화 고유 ID (API에서 제공하는 ID 사용)
     - `jp_movie_id`:  
     - `title`: 영화 제목
     - `release_date`: 개봉일
     - `poster_url`: 포스터 이미지 URL
     - `description`: 영화 설명

3. **reviews 테이블**
   - 사용자 리뷰 정보를 저장합니다.
   - **컬럼**
     - `review_id` (PK): 리뷰 고유 ID (자동 증가)
     - `user_id` (FK): 리뷰를 작성한 사용자 ID
     - `movie_id` (FK): 리뷰가 작성된 영화 ID
     - `rating`: 평점 (예: 1-5)
     - `comment`: 리뷰 내용
     - `created_at`: 리뷰 작성일시

4. **sessions 테이블**
   - 사용자 세션 정보를 저장합니다.
   - **컬럼**
     - `session_id` (PK): 세션 고유 ID (자동 증가)
     - `user_id` (FK): 사용자 ID
     - `session_token`: 세션 토큰
     - `created_at`: 세션 생성일시
     - `expires_at`: 세션 만료일시

### 테이블 생성 SQL 예시

```sql
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    passwd VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    provider VARCHAR(50), -- 소셜 로그인 제공업체 (예: 네이버, 카카오)
    provider_id VARCHAR(255) -- 소셜 로그인 제공업체의 사용자 ID
);

CREATE TABLE movies (
    movie_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_date DATE,
    poster_url VARCHAR(255),
    description TEXT
);

CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    movie_id INT,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);

CREATE TABLE sessions (
    session_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    session_token VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

### 관계
- **users**와 **reviews**는 일대다(One-to-Many) 관계입니다. 한 명의 사용자가 여러 리뷰를 작성할 수 있습니다.
- **movies**와 **reviews**는 일대다(One-to-Many) 관계입니다. 한 영화에 여러 사용자가 리뷰를 작성할 수 있습니다.
- **users**와 **sessions**는 일대다(One-to-Many) 관계입니다. 한 명의 사용자가 여러 세션을 가질 수 있습니다.

