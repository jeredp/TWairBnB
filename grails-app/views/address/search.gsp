<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Addresses</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div>
    <g:form action="search">
        <g:render template="form"/>
        <g:submitButton name="submit"/>
    </g:form>
</div>
<div class="addressRow">
    <span class="addressColumn">Street Address</span>
    <span class="addressColumn">City</span>
    <span class="addressColumn">State</span>
    <span class="addressColumn">Area Code</span>
</div>
    <g:each in="${addresses}" var="address">
        <div class="addressRow">
            <g:link class="addressColumn" action="show" id="${address.id}" name="${address.id}">${address.streetAddress}</g:link>
            <span class="addressColumn">${address.city}</span>
            <span class="addressColumn">${address.state}</span>
            <span class="addressColumn">${address.areaCode}</span>
        </div>
    </g:each>
</body>
</html>