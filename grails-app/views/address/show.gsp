
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Show</title>
    <meta name="layout" content="main"/>
</head>

<body>
    <div>
        <span>${address.city}</span>
        <span>${address.state}</span>
        <span>${address.areaCode}</span>
    </div>
    <div>
        <span>${address.user.name}</span>
        <span>${address.user.username}</span>
    </div>
</body>
</html>