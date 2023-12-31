<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<a href="logout.do">Log-out</a>
	<hr>
	<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<table border="1">
	  <tr>
	    <td bgcolor="skyblue" width="70">제목</td>
	    <td align="left"><input type="text" name="title"></td>
	  </tr>
	  <tr>
	    <td bgcolor="skyblue">작성자</td>
	    <td align="left"><input type="text" name="writer" size="10" autocomplete="off"/></td>
	  </tr>
	  <tr>
	    <td bgcolor="skyblue">내용</td>
	    <td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
	  </tr>
	  <tr>
	  	<td bgcolor="skyblue">파일 업로드</td>
	  	<td align="left">
	  		<input type="file" name="uploadFile">
	  	</td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
	    <input type="submit" value="새 게시글 등록" />
	  	</td>
	  </tr>
	</table>
	</form>
	<hr>
	<a href="getBoardList.do">게시글 목록 가기</a>
</body>
</html>
  