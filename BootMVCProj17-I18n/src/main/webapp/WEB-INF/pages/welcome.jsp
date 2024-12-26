<%@ page  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="sp"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>



<h1 style="color:red;text-align:center"><sp:message  code="home.welcome"/> </h1>

<br><br>

  <h3  style="color:red;text-align:center"><a  href="register"><sp:message code="home.link1"/></a> </h3>
  
  <br><br>
  
  <a href="?lang=de_DE">Germany</a> &nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=fr_FR">French</a> &nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=te_IN">Telugu</a> &nbsp;&nbsp;&nbsp;&nbsp;
   <a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=en_US">English</a> &nbsp;&nbsp;&nbsp;&nbsp;
  <hr>
  <h3>Current  active Locale ::  ${pageContext.response.locale }</h3>  <br><br>
      <fmt:setLocale value="${pageContext.response.locale}"/>
      
     <fmt:formatDate  var="fdate"  value="${sysDate}"  type="date"  dateStyle="MEDIUM"/>
     <b>Formatted Date :: ${fdate}</b>   
      <br>
  <fmt:formatDate  var="ftime"  value="${sysDate}"  type="time"  timeStyle="MEDIUM"/>
     <b> Formatted  Time :: ${ftime}</b>      
     
     <br><br>
      <fmt:formatNumber  var="fno"  value="${salary}"  type="number" />
      <b>Formatted number :: ${fno}</b>
       <br>
      <fmt:formatNumber  var="fcurrency"  value="${salary}"  type="currency"/>
      <b>Formatted number :: ${fcurrency}</b>
      <br>
      <fmt:formatNumber  var="fpercentage"  value="${avg}"  type="percent"/>
      <b>Formatted number :: ${fpercentage}</b>
      
      
      
  
  
  
