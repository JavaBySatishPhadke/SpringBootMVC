<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>
 
 
   <h1  style="color:blue;text-align:center">  Search Data Dynamically  </h1>
 
   <frm:form  action="search" modelAttribute="emp" >
    <table align="center"  bgcolor="grey" >
         <tr>
           <td>  emp name :: </td>
           <td> <frm:input path="ename"/> </td>
         </tr>
         <tr>
           <td>  emp job :: </td>
           <td> <frm:input path="job"/> </td>
         </tr>
         
         <tr>
           <td>  emp salary :: </td>
           <td> <frm:input path="sal"/> </td>
         </tr>
         
         <tr>
           <td>  emp dept no :: </td>
           <td> <frm:select path="deptno">
                          <frm:option value="">--select dept--</frm:option>
                         <frm:option value="10">10</frm:option>
                         <frm:option value="20">20</frm:option>
                         <frm:option value="30">30</frm:option>
                     </frm:select>
            </td>
         </tr>
          <tr>
              <td> <input type="submit"  value="search with Data"/> </td>
              <td> <input type="reset"  value="cancel"/> </td>
          </tr>
    </table>
    </frm:form>
    <hr> <hr>
    <br><br>
   <h1  style="color:blue;text-align:center">  Report  Data  </h1>
 <c:choose>
    <c:when  test="${!empty empsList}">
        <table align="center" border="1" bgcolor="yellow">
           <tr bgcolor="cyan">
            <th>empno</th>
            <th>ename</th>
            <th>job</th>
            <th>salary</th>
            <th>deptno</th>
            <th>operations</th>
           </tr>
        <c:forEach  var="emp"  items="${empsList}">
          <tr>
             <td>${emp.empno}  </td>
              <td>${emp.ename}  </td>
               <td>${emp.job}  </td>
                <td>${emp.sal}  </td>
                 <td>${emp.deptno}  </td>
                 <td><a href="edit?no=${emp.empno}"><img src="images/edit.jpg" width="30px" height="40px"></a>  
                         &nbsp;&nbsp; <a onclick="return confirm('Are you sure delete??')" href="delete?no=${emp.empno}"><img src="images/delete.jpg" width="30px" height="40px"></a> </td>
          </tr>
        </c:forEach>
        
         </table>
       
    </c:when>
       <c:otherwise>
                  <h1  style="color:red;text-align:center"> No Data Found </h1>
       </c:otherwise>
 </c:choose>
   <br><br>
                                         <h1 style="color:green;text-align:center">${resultMsg}</h1>
  <br><br>
                             <center> <a href="register">Add Employee <img src="images/add.jpg"/></a>   </center>
  <br><br>
                           <center>  <a href="./">home <img src="images/home.jpg"/></a>  </center>
                           
  