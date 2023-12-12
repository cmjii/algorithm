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
            color: rgb(136, 136, 136);
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
            color: black;
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

        .re,.re2 {
              position: absolute;
              bottom: 120px;
              right: 120px;
             margin: 10px;
        }   
        .re1,.re3 {
              position: absolute;
              bottom: 120px;
              right: 20px;
              margin: 10px;
        }   
    
     	.ch{
     	margin-top: 15px;
            margin-right: 10px;
            border-radius: 10px;
            background-color: #ffffff93;
            height: 40px;
        }
                .btn{
            margin-top: 15px;
           float: right;
        }
         .abt{
            margin-right: 20px;
            margin-top: 60px;
            }
  
        .container{
          background-color: rgba(188, 255, 239, 0.464);
            border: 5px solid rgb(149, 248, 225);
            border-radius: 10px;
            padding: 50px;
            width: 600px;
            height: 500px;
            margin-top: 58px;
            font-weight: 700;
        }
         .t{
            margin-top: 30px;
            margin-left: 20%;
            width: 62%;
            height: 700px;
          	
        }
	.wr{
		
	        margin-left: 20%;
            width: 62%;
            height: 700px;
	}
	.wr2{
		    margin-left: 20%;
            width: 62%;
            height: 700px;
	}

    </style>
  <body>
    <header>     
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <i class="bi bi-tree-fill"></i>
                <a class="navbar-brand" href="/index.jsp">MY JSP</a>
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
</form>
</div>
                </div>
            </div>
        </nav>
    </header>
<h2>수정</h2>

<a class="re" href="/brd/list"><button class="btn btn-outline-success abt">게시판</button></a>
<a class="re1" href="/index.jsp"><button class="btn btn-outline-success abt">돌아가기</button></a>

<form action="/brd/edit" method="post" enctype="multipart/form-data">
<div class="t">
    <table class="table table-hover table-bordered" border="1px" >
        <tr>
          <thead class="table-secondary">
            <th scope="col" style="padding: 12px;">번호</th>
            <th scope="col" style="padding: 12px;">제목</th>
            <th scope="col" style="padding: 12px;">작성자</th>
            <th scope="col" style="padding: 12px;">작성일</th>
            <th scope="col" style="padding: 12px;">수정일</th>
            <th scope="col" style="padding: 12px;">조회</th>
            </thead>
        </tr>
          <tbody class="table-group-divider">
            <tr>
                <th scope="col" style="padding: 12px;">${bvo.bno }</th>
				<td><input type="text" name="title" value="${bvo.title }"></td>
                <td >${bvo.writer }</td>	
                <td>${bvo.regdate }</td>	
                <td >${bvo.moddate }</td>	
                <td >${bvo.readcount }</td>	        
            </tr>      
            </tbody>
        </table>
<div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label"><p style="font-size: 20px;">내용</p></label>
  <div class="form-control" id="exampleFormControlTextarea1" >
	<img alt="" src="/_fileUpload/${bvo.imageFile }" class="img-fluid" alt="..."><br>
  <textarea rows="3" cols="100" name="content"> ${bvo.content }</textarea></div>
</div>
<div class="mb-3">
  <input class="form-control" type="hidden" id="formFile" name="image_file" value="${bvo.imageFile }">
  <input class="form-control" type="file" id="formFile" name="new_file" accept="image/png, imapge/jpg, image/gif">
</div>
</div>
</div>

	<c:if test="${ses.id == bvo.writer }">
	<button type="submit" class="btn btn-outline-secondary re2" style="bottom: 170px; margin-right: 40px;">수정</button>
	<a href="/brd/remove?bno=${bvo.bno }"><button type="button" class="btn btn-outline-secondary re3" style="bottom: 170px; margin-right: 40px;">삭제</button></a>
	</c:if>
</form>

<%-- 
<h1>Modify Page</h1>
<div>
<img alt="" src="/_fileUpload/${bvo.imageFile }">
</div>
<form action="/brd/edit" method="post" enctype="multipart/form-data">
<table class="table">
	<tr>
		<th>번호:</th>
		<td><input type="text" name="bno" value="${bvo.bno }"></td>
	</tr>
	<tr>
		<th>제목:</th>
		<td><input type="text" name="title" value="${bvo.title }"></td>
	</tr>
	<tr>
		<th>작성자:</th>
		<td>${bvo.writer }</td>
	</tr>
	<tr>
		<th>작성일:</th>
		<td>${bvo.regdate }</td>
	</tr>
	<tr>
		<th>수정일:</th>
		<td>${bvo.moddate }</td>
	</tr>
	<tr>
		<th>조회:</th>
		<td>${bvo.readcount }</td>
	</tr>	
	<tr>
		<th>내용:</th>
		<td><textarea rows="10" cols="30" name="content"> ${bvo.content }</textarea></td>
	</tr>
	<tr>
		<th>image_file</th>
		<td>
			<input type="hidden" name="image_file" value="${bvo.imageFile }">
			<input type="file" name="new_file" accept="image/png, imapge/jpg, image/gif">
		</td>
	</tr>
	</table>
	<c:if test="${ses.id == bvo.writer }">
	<button type="submit">수정</button>
	<button type="reset">취소</button>
	<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제</button></a>
	</c:if>


	</form>
 --%>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
</body>
</html>