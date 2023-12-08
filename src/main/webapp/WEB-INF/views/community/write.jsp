<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
    <c:when test="${not empty boardVO}">
        <c:set var="action" value="update" />
        <c:set var="title" value="Update the post" />
    </c:when>
    <c:otherwise>
        <c:set var="action" value="write" />
        <c:set var="title" value="Write a new post" />
    </c:otherwise>
</c:choose>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <style>
        #container {width: 800px;}
        #container > form > p > label {display: block;}
        #container > form > p > textarea {
            display: block; width: 100%; box-sizing: border-box; font: 1rem sans-serif;
        }
        #container > form > p > textarea {line-height: 1.5; height: 12em;}
    </style>
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script>
        $(function () {
            $('#write').on('click', function() {
                if (!window.confirm('완료 하시겠습니까?')) return false;
            })
        });
    </script>
</head>
<body>

    <div id="container">
        <h1>${title}</h1>

        <form action="${action}" method="post">
    </div>

<c:choose>
    <c:when test="${action == 'update'}">
        <input type="hidden" name="id" value="${board.id}">
        <input type="hidden" name="page" value="${criteria.page}">
        <input type="hidden" name="rowsPerPage" value="${criteria.rowsPerPage}">
    </c:when>
</c:choose>

            <p>
                <label>Title:</label>
                <input type="text" name="title" value="${boardVO.title}">
            </p>

            <p>
                <label>Writer:</label>
                <input type="text" name="writer" value="${boardVO.writer}">
            </p>

            <p>
                <label>Content:</label>
                <textarea name="content">${boardVO.content}</textarea>
            </p>

            <p>
                <input type="submit" name="submit" value="${fn:toUpperCase(action)}" id="write">
            </p>

        </form>


</body>
</html>