### 주간 박스오피스 데이터를 실시간으로 가져와서 표시하기

#### 1. API 호출을 위한 Spring Service 클래스 작성

```java
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class BoxOfficeService {

    public String getWeeklyBoxOffice() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.example.com/box_office/week"; // 실제 API URL로 변경
        String response = restTemplate.getForObject(apiUrl, String.class);

        // JSON 파싱
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray movies = jsonResponse.getJSONArray("movies");

        // HTML 테이블 생성
        StringBuilder htmlContent = new StringBuilder("<table><tr><th>Title</th><th>Gross Income</th></tr>");
        for (int i = 0; i < movies.length(); i++) {
            JSONObject movie = movies.getJSONObject(i);
            htmlContent.append("<tr><td>").append(movie.getString("title")).append("</td><td>")
                       .append(movie.getDouble("gross_income")).append("</td></tr>");
        }
        htmlContent.append("</table>");

        return htmlContent.toString();
    }
}
```

#### 2. Controller 작성

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoxOfficeController {

    @Autowired
    private BoxOfficeService boxOfficeService;

    @GetMapping("/box_office")
    public String getBoxOffice(Model model) {
        String boxOfficeData = boxOfficeService.getWeeklyBoxOffice();
        model.addAttribute("boxOfficeData", boxOfficeData);
        return "boxOffice"; // boxOffice.jsp
    }
}
```

#### 3. JSP 파일 작성 (boxOffice.jsp)

```jsp
<!DOCTYPE html>
<html>
<head>
    <title>Weekly Box Office</title>
</head>
<body>
    <h1>Weekly Box Office</h1>
    <div>
        <c:out value="${boxOfficeData}"/>
    </div>
</body>
</html>
```

이렇게 하면 Spring과 JSP를 사용하여 주간 박스오피스 데이터를 API에서 가져와 실시간으로 웹페이지에 표시할 수 있습니다. `BoxOfficeService` 클래스에서 API 호출과 데이터 파싱을 처리하고, `BoxOfficeController`에서 JSP 페이지에 데이터를 전달합니다. JSP 파일에서는 전달된 데이터를 HTML로 출력합니다.
