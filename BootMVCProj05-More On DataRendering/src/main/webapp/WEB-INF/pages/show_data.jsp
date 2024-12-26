<%@ page isELIgnored="false" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
    
      <h1 style="color:red;text-align:center">  Model  Attributes are  </h1>
      
<!--       <br><br> -->
<%--         <b> Model  attriubues  (simple values):: ${name},${age}</b> --%>
      
      
 <%--      <br><br>
      <b> Model Attributes (Arrays and Collections)</b> <br><br>
      <%
          String favColors[]=(String[])request.getAttribute("favColors");
          List<String> friends=(List<String>)request.getAttribute("friends");
          Set<Long> phones=(Set<Long>)request.getAttribute("phoneNumbers");
          Map<String,Object> idsMap=(Map<String,Object>)request.getAttribute("idDetails");
      %>
         <b> Fav Colors:: <%=Arrays.toString(favColors) %></b> <br>
         <b> Friends :: <%=friends %></b> <br>
         <b> phones :: <%=phones %></b> <br>
         <b> idsMap :: <%=idsMap %></b> <br>
     --%>     
   <%--   <b> Favourite  colors::</b>
     <c:if test="${favColors ne null}">
          <c:forEach var="color" items="${favColors}">
                   <br> ${color}  
          </c:forEach>
     </c:if>
         
     <br>
     <c:if test="${friends ne null}">
          <c:forEach var="fr" items="${friends}">
                    ${fr} ,
          </c:forEach>
     </c:if>
     <br>
     <c:if test="${phoneNumbers ne null}">
          <c:forEach var="ph" items="${phoneNumbers}">
                    ${ph} ,
          </c:forEach>
     </c:if>
     <br>
     <c:if test="${idDetails ne null}">
          <c:forEach var="id" items="${idDetails}">
                    ${id.key} = ${id.value} ,
          </c:forEach>
     </c:if> --%>
     
     
   <%--    <b> Model Attributes (Model class object)</b> <br><br>
      <c:if  test="${!empty studDetails}">
           Student details ::  ${studDetails} <br>
           Student details ::  ${studDetails.sno},${studDetails.sname},${studDetails.sadd},${studDetails.avg} <br>
      </c:if> --%>
      
        <b> Model Attributes (Collection of  Model class objects)</b>
        
        <c:choose>
             <c:when test="${!empty studList}">
                <table border="1"  bgcolor="cyan" align="center">
                    <tr> <th> SNO</th><th>SNAME</th><th>SADD</th><th>AVG</th>  </tr>
                   <c:forEach var="st" items="${studList}">
                        <tr >
                          <td>${st.sno} </td>
                          <td>${st.sname} </td>
                          <td>${st.sadd} </td>
                          <td>${st.avg} </td>
                        </tr>
                    </c:forEach>    
                </table>
             </c:when>
             <c:otherwise>
                      <h1  style="color:red;text-align:center"> No Records found  </h1>
             </c:otherwise>
        </c:choose>
     
     
    
    