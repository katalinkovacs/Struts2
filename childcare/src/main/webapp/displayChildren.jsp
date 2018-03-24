<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of children:</title>
  </head>
  <body>


  <h1>Hello</h1>
  <s:iterator value="childrenList">
      <li>
          <s:property value="id"/>
          <s:property value="fullName"/>
          <s:property value="ageMonth"/>
      </li>
  </s:iterator>

  <%--  <TABLE>
        <c:forEach items="${childrenList.child}" var="child">

            <tr>
                <td><c:out value="${child.id}"/></td>
                <td><c:out value="${child.fullName}"/></td>
                <td><c:out value="${child.ageMonth}"/></td>
            </tr>
        </c:forEach>
    </TABLE>--%>
  </body>

</html>