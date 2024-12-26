
<%@taglib uri="http://www.springframework.org/tags/form"   prefix="frm"%>

<h1  style="color:red;text-align:center">Dancer Registration Page</h1>

<frm:form    modelAttribute="dancer">
 <table  align="center"  bgcolor="cyan">
    <tr>
       <td>  Dancer ID  : </td>
       <td>  <frm:input type="text" path="did"/></td>
    </tr>
       <tr>
       <td>  Dancer Name  : </td>
       <td>  <frm:input type="text" path="name" title="takes name"/></td>
    </tr>
 
       <tr>
       <td>  Dancer Address  : </td>
       <td>  <frm:input type="text" path="addrs"/></td>
    </tr>
       <tr>
       <td>  Dancer Dance form  : </td>
       <td>  <frm:input type="text" path="danceForm"/></td>
    </tr>
       <tr>
       <td>  Dancer Fee  : </td>
       <td>  <frm:input type="text" path="fee"/></td>
    </tr>
      <tr>
       <td>  <input type="submit" value="Send"> </td>
       <td>  <input type="Reset"  value="cancel"></td>
    </tr>
    
    
 
 </table>

</frm:form>