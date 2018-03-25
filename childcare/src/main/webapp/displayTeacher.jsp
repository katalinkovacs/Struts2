<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of teacher:</title>
  </head>
  <body>

    <%-- This is the teacherList from Action class!!!!!!   --%>

  <s:iterator value="teacherList">
      <li>
          <s:property value="id"/>
          <s:property value="name"/>
      </li>
  </s:iterator>

  </body>

</html>