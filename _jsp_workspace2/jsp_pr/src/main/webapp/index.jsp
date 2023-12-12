<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            font-family: 'Jua', sans-serif;
        }
        .image{
            /* z-index: 1;
            height: 100%; */
           opacity: 5;
            position: absolute; top:0; left: 0;
            width: 100%;
            height: 100%;
        }
        .bi-tree-fill{
            font-size: 35px;
            margin-left: 30px;
            color: rgba(243, 154, 154, 0.59);
        }
        .navbar{
         background-color:rgba(255, 255, 253, 0) !important;
         border-bottom: solid 1px rgb(123, 121, 121);
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
            
        }
        .nav2{
            color: rgb(255, 255, 253); 
            text-decoration: none;
        }
        .nav2:hover{
           font-size: 28px;
           font-weight: 800;
           color: rgb(252, 240, 136);
        }
        .navbar-brand{
            margin-left: 10px;
            font-size: 40px;
            font-weight: 800;
            color: rgb(255, 255, 255);
        }
     .in{
            background-color: rgba(240, 248, 255, 0);
            color: white;
            border: 1px solid white;
            border-radius: 8px;
            width: 220px;
            margin-right: 20px;
        }
        .in::placeholder {
            color: #ffffff;
            padding-left: 10px;
        }  color: #ffffff;
        }
        .container{
            width: 100%;
            height: 5px;
        }
            .ss{
            font-size: 90px;
            font-weight: 800;
            color: white;
            position: absolute;
            top: 40%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }
        .loginput1{
            position: absolute;
            width: 150px;
            height: 35px;
            top: 60%;
            left: 44%;
            transform: translate(-50%, -50%);
            text-align: center;
            border: 1px solid white;
            background-color: transparent;
            border-radius: 10px;
        }
        .loginput2{
            position: absolute;
            width: 150px;
            height: 35px;
            top: 60%;
            left: 58%;
            transform: translate(-50%, -50%);
            text-align: center;
            border: 1px solid white;
            background-color: transparent;
            border-radius: 10px;
        }
        .loginput1:focus, .loginput2:focus{
            background-color: white;
        }
        .login{
            width: 150px;
            height: 60px;
            position: absolute;
            top: 68%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
            background-color: #d3aeae7a;
            border: solid 3px rgb(250, 248, 248);
            font-weight: 700;
            padding-top: 10px;
        }

        .id{
            color: white;
            position: absolute;
            top: 60%;
            left: 38%;
            transform: translate(-50%, -50%);
            text-align: center;
            font-size: 28px;
            font-weight: 800;
        }
        .pw{
            color: white;
            position: absolute;
            top: 60%;
            left: 52%;
            transform: translate(-50%, -50%);
            text-align: center;
            font-size: 28px;
            font-weight: 800;
        }
             	.ch{
            margin-right: 10px;
            border-radius: 10px;
            background-color: #ffffff93;
        }
        
        .join:hover{
        	color: rgb(255, 41, 41);
        	font-size: 23px;
        }
        

/*         footer {
          width: 100%;
          height: 100px;
          bottom: 0px; 
          position: absolute;
          border-top: 1px solid #c4c4c4;
          padding-top: 18px;
          font-size: 15px;
          color: rgb(96, 90, 90);
          background-color: #87878725;
        }
        footer span {
          display: inline-block;
          margin-left: 250px;
        }
        footer i {
            float: right;
            font-size: 20px;
            margin-right: 60px;
        } */
    </style>

  <body>
    <div class="full">
        <img class="image" src="https://images.unsplash.com/photo-1699094762785-18632b561826?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D">
    <header>     
        <nav class="navbar navbar-expand-lg bg-body-tertiary" >
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
    </header>
            <span class="ss">WELCOME <br> MY JSP! <br></span>
            
    <div class="d">
        <form action="/memb/login" method="post">
            <span class="id">ID : </span> <input type="text" name="id" class="loginput1"> <br>
            <span class="pw">PW : </span> <input type="password" name="pwd" class="loginput2">
            <button class="btn btn-secondary btn-lg login" type="submit">LOGIN</button> 
        </form>

<br><a href="/memb/join"><button class="btn login join" style="color:white; border:none; font-size:20px; border-bottom:3px solid white; padding-bottom:0px; margin-top: 55px; width: 100px; height: 50px; background-color: rgba(240, 248, 255, 0); " >회원가입</button></a>

    </div>
</div>

<c:if test="${ses.id ne null }">
    <div class="full">
        <img class="image" src="https://images.unsplash.com/photo-1699094762785-18632b561826?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D">
    <header>     
        <nav class="navbar navbar-expand-lg bg-body-tertiary" style="margin-top: -125px;" >
            <div class="container-fluid" >
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
            <span class="ss">WELCOME <br> MY JSP! <br></span>
           <span class="ss" style="margin-top: 180px"> <h3>반가워요! ${ses.id }님!</h3> </span>
    <div class="d">
            <a  href="/memb/logout"><button class="btn btn-secondary btn-lg login">LOGOUT</button></a>
    </div>
</div>
</c:if>


<!-- <footer>
    
        <span> (주) CMJ WORLD</span><br/>
        <span>이메일 : aaaaa@aaaa.com</span><br/>
        <span>Copyright 2023. cmj. All Rights Reserved.</span>
        <i class="bi bi-twitter"></i>
        <i class="bi bi-instagram"></i>
        <i class="bi bi-github"></i>

</footer> -->

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>





<%--  <h1>메인 페이지</h1> 
<h3>로그인</h3> 
<form action="/memb/login" method="post">
아이디 : <input type="text" name="id"> <br>
비밀번호 : <input type="password" name="pwd">
<button type="submit">로그인</button>
</form>
<c:if test="${ses.id ne null }">
	<h3>${ses.id }님이 로그인 하셨습니다.</h3> 
	<a href="/memb/move"><button>내 정보</button></a>
	<a href="/memb/list"><button>회원목록</button></a><br><hr>
	<a href="/memb/logout"><button>로그아웃</button></a>
	<a href="/brd/register"><button>글쓰기</button></a>
	<a href="/brd/list"><button>글 목록</button></a> 
	
	
</c:if> --%>


<script type="text/javascript">
	const login = '<c:out value="${login}" />';
	 if(login == "false"){
		alert("로그인 실패");
	}	
	
	const logout = '<c:out value="${logout}" />';
	if(logout == "true"){
		alert("로그아웃 성공");
	}else if(logout == "false"){
		alert("로그아웃 실패");
	}
	
	const modify = '<c:out value="${modify}" />';
	if(modify == "true"){
		alert("수정 완료 다시 로그인 해주세요");
	}else if(modify == "false"){
		alert("수정 실패");
	}
	
	const remove = '<c:out value="${remove}" />';
	if(remove == "true"){
		alert("회원 탈퇴 성공");
	}else if(remove == "false"){
		alert("탈퇴 실패");
	}
</script> 
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
</body>
</html>


<%-- <form action="/memb/login" method="post">
아이디 : <input type="text" name="id"> <br>
비밀번호 : <input type="password" name="pwd">
<button type="submit">로그인</button>
</form>
<c:if test="${ses.id ne null }">
	<h3>${ses.id }님이 로그인 하셨습니다.</h3> 
	<a href="/memb/move"><button>내 정보</button></a>
	<a href="/memb/list"><button>회원목록</button></a><br><hr>
	<a href="/memb/logout"><button>로그아웃</button></a>
	<a href="/brd/register"><button>글쓰기</button></a>
	<a href="/brd/list"><button>글 목록</button></a> 
</c:if> --%>