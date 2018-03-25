<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of children:</title>
  </head>
  <body>

    <%-- This is the childrenList from Action class!!!!!!   --%>

  <s:iterator value="childrenList">
      <li>
          <s:property value="id"/>
          <s:property value="fullName"/>
          <s:property value="ageMonth"/>
      </li>
  </s:iterator>

  </body>

</html>