<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of children:</title>
  </head>
  <body>
    <s:iterator  value="childrenList">
        <fieldset>
            <s:property value="id"/><br/>
            <s:property value="fullName"/><br/>
            <s:property value="ageMonth"/><br/>
        </fieldset>
    </s:iterator>

  </body>
</html>