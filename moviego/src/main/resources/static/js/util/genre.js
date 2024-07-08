/***** genereKr For문 스타일 *****/
// function genreKr(genreIds) {
//   const genres = [];
//   for (let i = 0; i < genreIds.length; i++) {
//     switch (genreIds[i]) {
//       case 28:
//         genres.push('액션');
//         break;
//       case 12:
//         genres.push('모험');
//         break;
//       case 16:
//         genres.push('애니메이션');
//         break;
//       case 35:
//         genres.push('코미디');
//         break;
//       case 80:
//         genres.push('범죄');
//         break;
//       // 다른 장르들도 추가할 수 있습니다.
//       default:
//         genres.push('기타');
//         break;
//     }
//   }
//   return genres;
// }

/***** map 메소드를 이용한 방법 ******/
// function genreKr(genreIds) {
//   return genreIds.map((id) => {
//     switch (id) {
//       case 28:
//         return '액션';
//       case 12:
//         return '모험';
//       case 16:
//         return '애니메이션';
//       case 35:
//         return '코미디';
//       case 80:
//         return '범죄';
//       case 99:
//         return '다큐멘터리';
//       case 18:
//         return '드라마';
//       case 10751:
//         return '가족';
//       case 14:
//         return '판타지';
//       case 36:
//         return '역사';
//       case 27:
//         return '공포';
//       case 10402:
//         return '음악';
//       case 9648:
//         return '미스터리';
//       case 10749:
//         return '로맨스';
//       case 878:
//         return 'SF';
//       case 10770:
//         return 'TV 영화';
//       case 53:
//         return '스릴러';
//       case 10752:
//         return '전쟁';
//       case 37:
//         return '서부';
//       default:
//         return '기타';
//     }
//   });
// }

function genreKr(genreIds) {
  return genreIds.map((id) => genres[id] || messages.genreOther);
}
