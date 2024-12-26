<%@ page  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="sp"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>



<h1 style="color:red;text-align:center"><sp:message  code="registration.welcome"/> </h1>

<frm:form method="POST"  modelAttribute="cust">
   <table border="1" bgcolor="yellow"  align="center">
      <tr>
         <td><sp:message code="registration.cust.name"/>  </td>
         <td>  <frm:input path="name"/>  </td>
       </tr>
      <tr>
         <td><sp:message code="registration.cust.addrs"/>  </td>
         <td>  <frm:input path="addrs"/> </td>
       </tr>
        <tr>
         <td><sp:message code="registration.cust.mobileno"/>  </td>
         <td>  <frm:input path="mobileno"/> </td>
       </tr>
     
      <tr>
          <td  colspan="2"> <input type="submit"  value="<sp:message code='registration.cust.submitcaption'/>"></td>  
         </tr>/
      
   
   </table>

</frm:form>

<br><br>

  
  <br><br>
  
  <a href="?lang=de_DE">Germany</a> &nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=fr_FR">French</a> &nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=te_IN">Telugu</a> &nbsp;&nbsp;&nbsp;&nbsp;
   <a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=en_US">English</a> &nbsp;&nbsp;&nbsp;&nbsp;
  
  
