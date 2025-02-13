/***** Legacy Code *****/
// const translateNation = (nationCode) => {
//   switch (nationCode) {
//     case 'en':
//       return '미국';
//     case 'ko':
//       return '한국';
//     case 'bn':
//       return '브루나이';
//     case 'pl':
//       return '폴란드';
//     case 'th':
//       return '태국';
//     case 'us':
//       return '미국';
//     case 'kr':
//       return '한국';
//     case 'ja':
//       return '일본';
//     case 'zh':
//       return '중국';
//     case 'fr':
//       return '프랑스';
//     case 'de':
//       return '독일';
//     case 'in':
//       return '인도';
//     case 'it':
//       return '이탈리아';
//     case 'es':
//       return '스페인';
//     case 'ru':
//       return '러시아';
//     case 'br':
//       return '브라질';
//     case 'mx':
//       return '멕시코';
//     case 'ca':
//       return '캐나다';
//     case 'au':
//       return '호주';
//     case 'gb':
//       return '영국';
//     case 'se':
//       return '스웨덴';
//     case 'no':
//       return '노르웨이';
//     case 'fi':
//       return '핀란드';
//     case 'nl':
//       return '네덜란드';
//     case 'be':
//       return '벨기에';
//     case 'ch':
//       return '스위스';
//     case 'at':
//       return '오스트리아';
//     case 'dk':
//       return '덴마크';
//     case 'nz':
//       return '뉴질랜드';
//     case 'sg':
//       return '싱가포르';
//     case 'my':
//       return '말레이시아';
//     case 'id':
//       return '인도네시아';
//     case 'ph':
//       return '필리핀';
//     case 'vn':
//       return '베트남';
//     case 'sa':
//       return '사우디아라비아';
//     case 'ae':
//       return '아랍에미리트';
//     case 'eg':
//       return '이집트';
//     case 'za':
//       return '남아프리카공화국';
//     case 'ar':
//       return '아르헨티나';
//     case 'cl':
//       return '칠레';
//     case 'co':
//       return '콜롬비아';
//     case 'pe':
//       return '페루';
//     case 'pt':
//       return '포르투갈';
//     default:
//       return '미상';
//   }
// };

function translateNation(nationCode) {
  return countries[nationCode] || messages.countryUnknown;
}
