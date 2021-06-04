<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据导入</title>
    <link rel="stylesheet" type="text/css" href="css/divForm.css">
</head>
<body class="bodyImg">
<h1>数据导入</h1>
<div class="divForm">
    <form method="post" action="/SelectSubject2_war_exploded/ImportTeachersServlet" enctype="multipart/form-data">
        选择要导入的老师文件:
        <input type="file" name="uploadFile"/>
        <input type="submit" value="上传"/>
    </form>
    <br/>
    <form method="post" action="/SelectSubject2_war_exploded/ImportStudentsServlet" enctype="multipart/form-data">
        选择要导入的学生文件:
        <input type="file" name="uploadFile"/>
        <input type="submit" value="上传"/>
    </form>
    <br/>
    <form method="post" action="/SelectSubject2_war_exploded/ImportCoursesServlet" enctype="multipart/form-data">
        选择要导入的课程文件:
        <input type="file" name="uploadFile"/>
        <input type="submit" value="上传"/>
    </form>
</div>
</body>
</html>