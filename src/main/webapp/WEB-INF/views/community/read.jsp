<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>${boardVO.title}</title>
    <style>
        #container { width: 800px; }
        #info { list-style-type: none; padding: 0; }
        #info::after { content: ""; display: block; clear: both; }
        #info > li { float: left; width: 25%; }
    </style>
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script>
        $(function(){
            $('#delete').on('click', function(){
                if(!window.confirm('진짜 진짜 지울거야?'))
                    return false;
            })
        });
    </script>

</head>
<body>

    <div id = "container">
        <h1>${boardVO.title}</h1>

        <ul id="info">
            <li>ID: ${boardVO.id}</li>
            <li>Writer: ${boardVO.writer}</li>
            <li>Date: ${boardVO.regdate}</li>
            <li>Last updated: ${boardVO.updatedate}</li>
        </ul>

        <p>${boardVO.content}</p>

        <hr>

        <p>
            [<a href="list?page=${criteria.page}">Go List</a>]
            [<a href="update?id=${boardVO.id}&page=${criteria.page}">UPDATE</a>]
            [<a href="delete?id=${boardVO.id}&page=${criteria.page}" id="delete">DELETE</a>]
        </p>
    </div>

</body>
</html>