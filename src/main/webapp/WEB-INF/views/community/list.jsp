<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Board List</title>
    <style>

        h1 > a:link { text-decoration: none;}
        h1 > a:visited { text-decoration: none;}

        body{background-color: rgb(231, 231, 231);}


        .logo {
        background-repeat: no-repeat;
        position:absolute;
        width: 100%;
        }

        #pagination {
            list-style-type: none;
            padding: 0;
            margin: 1em 0;
            font: 0.825em Tahoma, Verdana, sans-serif;
        }

        #pagination > li {
            display: inline-block;
            border: 1px soild #aaa;
        }

        #pagination > li > a,
        #pagination > li > span {
            display: block;
            padding: 0.3em 0.6em;
        }

        #pagination > li > a {
            text-decoration: none;
        }

        #pagination > li > span {
            background-color: #555;
            font-weight: bold;
            color: white;
        }
    </style>
</head>
<body>

    <h1><a href="list">Community</a></h1>

    <table border="1">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
                <th>최근 수정일</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
<c:forEach items="${list}" var="boardVO">
            <tr>
                <td>${boardVO.id}</td>
                <td><a href="read?id=${boardVO.id}&page=${pageMaker.criteria.page}">${boardVO.title}</a></td>
                <td>${boardVO.writer}</td>
                <td>${boardVO.regdate}</td>
                <td>${boardVO.updatedate}</td>
                <td id="views">${boardVO.boardHit}</td>
            </tr>
</c:forEach>
        </tbody>
    </table>

    <ul id="pagination">
<c:if test="${pageMaker.startPage != 1}">
    <li><a href="list">First</a></li>
</c:if>
<c:if test="${pageMaker.prev}">
    <li><a href="list?page=${pageMaker.startPage-1}">PREV</li>
</c:if>
<c:forEach var="page" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
    <c:choose>
        <c:when test="${page != pageMaker.criteria.page}">
            <li><a href="list?page=${page}">${page}</a></li>
        </c:when>
        <c:otherwise>
            <li><span>${page}<span></li>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${pageMaker.next}">
    <li><a href="list?page=${pageMaker.endPage+1}">NEXT</a></li>
</c:if>
<c:if test="${pageMaker.lastPage != pageMaker.endPage}">
    <li><a href="list?page=${pageMaker.lastPage}">LAST</a></li>
</c:if>
    </ul>

    <p>
        [<a href="write">작성</a>]
    </p>


</body>
</html>