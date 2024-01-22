<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<body>
<h1>ajax get 요청</h1><hr>
<button onclick="getPost()">통신요청</button>

<script>
    function getPost(){
        $.ajax({
            type:"get",  // fetch의 method 기능
            url: "http://localhost:8080/account/balance", // json 넣어놨음
            dataType:"json"
            // 메타데이터 타입을 명시해주면, ajax가 자동으로 js오브젝트로 파싱해준다
            // 성공
        }).done((abc)=>{
            console.log(abc);
            if(abc.code == 1){
                alert('통신성공');
            }
        })
            // 실패
            .fail((err)=>{
                console.log(err);

            });  // 실패시 - 상태코드 200 아닐때  // done + fail 은 콜백
    }
</script>
</body>
</html>
