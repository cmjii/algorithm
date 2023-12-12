<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
    <style>
        body, html{
            height: 100%;
            margin: 0;
            position: relative;
            font-family: 'Jua', sans-serif;
        }
        .bi-tree-fill{
            font-size: 35px;
            margin-left: 30px;
            color: rgba(243, 154, 154, 0.59);
        }
        .navbar{
         background-color: rgb(194, 242, 255);!important;
         border-bottom: solid 1px #c4c4c4;
        }   
        .navbar-nav{
            align-items: center;
            display: flex;
            margin: 0 auto;
            flex-direction: row;
            justify-content: center;
        }
        .nav1{
            margin-left: 120px;
            font-size: 25px;
            font-weight: 600;
            color: rgb(90, 90, 90);
            
        }
        .nav2{
            color:rgb(170, 170, 170);
            text-decoration: none;
        }
        .nav2:hover{
           font-size: 28px;
           font-weight: 800;
           color: rgb(95, 45, 45);
        }
        .navbar-brand{
            margin-left: 10px;
            font-size: 40px;
            font-weight: 800;
            color: rgb(42, 59, 46);
        }
        .in{
         	margin-top: 15px;
            background-color: rgba(240, 248, 255, 0);
            color: white;
            border: 1px solid rgb(186, 170, 170);
            border-radius: 8px;
            width: 220px;
            margin-right: 20px;
            height: 40px;
        }
        .in::placeholder {
            color: #938282;
            padding-left: 10px;
        }

   
        footer {
          width: 100%;
          height: 100px;
          bottom: 0px; 
          position: absolute;
          border-top: 1px solid #c4c4c4;
          padding-top: 18px;
          font-size: 15px;
          color: rgb(96, 90, 90);
          background-color: #ececec;
        }
        footer span {
          display: inline-block;
          margin-left: 250px;
        }
        footer i {
            float: right;
            font-size: 20px;
            margin-right: 60px; 
        }
     	.ch{
     	margin-top: 15px;
            margin-right: 10px;
            border-radius: 10px;
            background-color: #ffffff93;
            height: 40px;
        }
        h2{
            text-align: center;
            margin-top: 45px;
            font-weight: 800;
            font-size: 35px;
        }
        .container{
          background-color: rgba(252, 233, 233, 0.47);
            border: 5px solid rgba(255, 200, 200, 0.852);
            border-radius: 10px;
            padding: 50px;
            width: 600px;
            height: 500px;
            margin-top: 58px;
            font-weight: 700;
        }
        .btn{
            margin-top: 15px;
           float: right;
        }
         .abt{
            margin-right: 20px;
            margin-top: 60px;
            
        }

        
    </style>
<body>
    <header>     
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <i class="bi bi-tree-fill"></i>
                <a class="navbar-brand" href="#">MY JSP</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav1">
                            <a class="nav2" href="/brd/list">게시판</a>
                        </li>
                        <li class="nav1">
                            <a class="nav2" href="/brd/register">글쓰기</a>
                        </li>
                        <li class="nav1">
                            <a class="nav2" href="/memb/list">회원리스트</a>
                        </li>
                        <li class="nav1">
                            <a class="nav2" href="/memb/move">내정보</a>
                        </li>
                    </ul>
                    <!-- search line -->
<div class="text-center">
<form class="d-flex" role="search" action="/brd/list" method="get">
	<c:set value="${ph.pgvo.type }" var="typed"></c:set>
	<select name="type" class = "ch">
		<option ${typed == null ? 'selected' : ''}>선택</option>
		<option value="t" ${typed eq 't' ? 'selected' : '' }>제목</option>
		<option value="w" ${typed eq 'w' ? 'selected' : '' }>작성자</option>
		<option value="c" ${typed eq 'c' ? 'selected' : '' }>내용</option>
		<option value="tc" ${typed eq 'tc' ? 'selected' : '' }>제목&내용</option>
		<option value="tw" ${typed eq 'tw' ? 'selected' : '' }>제목&작성자</option>
		<option value="wc" ${typed eq 'wc' ? 'selected' : '' }>작성자&내용</option>
		<option value="twc" ${typed eq 'twc' ? 'selected' : '' }>제목&작성자&내용</option>
	</select>
	<input class="in"  placeholder="검색어를 입력하세요."  type="text" name="keyword" placeholder="Search" value="${ph.pgvo.keyword }">
	<input class="in"  placeholder="검색어를 입력하세요."  type="hidden" name="pageNo" value="1">
	<input class="in"  placeholder="검색어를 입력하세요."  type="hidden" name="qty" value="${ph.pgvo.qty }">
	<button type="submit" class="btn btn-light" style="width: 80px;">검색</button>
<%-- 	<span>${ph.totalCount }</span> --%>
</form>
</div>
                </div>
            </div>
        </nav>
    </header>


<form action="/memb/detail" method="post">
    <h2>내 정보</h2>
    <div class="container">
        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label">ID</label>
          <input type="text" class="form-control" name="id" id="exampleFormControlInput1" value="${ses.id }" readonly="readonly"">
        </div>
        <div class="mb-3">
          <label for="exampleFormControlTextarea1" class="form-label">PASSWORD</label>
            <input type="text" name="pwd" value="${ses.pwd }" class="form-control" id="exampleFormControlInput1">
        </div>
        <div class="mb-3">
          <label for="exampleFormControlTextarea1" class="form-label">E-mail</label>
            <input type="email" name="email" value="${ses.email }" class="form-control" id="exampleFormControlInput1">
        </div>
        <div class="mb-3">
          <label for="exampleFormControlTextarea1" class="form-label">age</label>
            <input type="text" name="age" value="${ses.age }" class="form-control" id="exampleFormControlInput1">
        </div>
        <button type="submit" class="btn btn-secondary">수정</button>
        </div>
</form>





<a href="/memb/remove?id=${ses.id }"><button type="button" class="btn btn-outline-success abt">회원탈퇴</button></a>
<a href="/index.jsp"><button type="button" class="btn btn-outline-success abt">돌아가기</button></a>

 <footer>
    
        <span> (주) CMJ WORLD</span><br/>
        <span>이메일 : aaaaa@aaaa.com</span><br/>
        <span>Copyright 2023. cmj. All Rights Reserved.</span>
        <i class="bi bi-twitter"></i>
        <i class="bi bi-instagram"></i>
        <i class="bi bi-github"></i>

</footer> -

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
</body>
</html>


<%-- <h1>회원정보</h1>
<form action="/memb/detail" method="post">
아이디 : <input type="text" name="id" value="${ses.id }" readonly="readonly"> <br>
비밀번호 : <input type="text" name="pwd" value="${ses.pwd }"> <br>
이메일 : <input type="email" name="email" value="${ses.email }"> <br>
나이 : <input type="text" name="age" value="${ses.age }"> <br>
<button type="submit">수정</button> <br>
</form>
<a href="/memb/remove?id=${ses.id }"><button>회원탈퇴</button></a>
<a href="/index.jsp"><button>처음으로</button></a> --%>