<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Addresses Home</title>
    <meta name="layout" content="main"/>
</head>

<body>
    <div><h3>My Addresses</h3>
        <g:each in="${myAddresses}" var="address">
            <div>${address.streetAddress}</div>
        </g:each>
    </div>
    <div>
        <g:link action="search">Search for places</g:link>
    </div>
</body>
</html>