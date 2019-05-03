<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
         
         <script type="text/javascript">
         
function handleSelect(elm)
{
window.location = elm.value;
}

window.history.forward();
function noback(){
	 history.pushState(null,null,document.URL);
	 window.addEventListener('popstate', function(){
		 history.pushState(null,null,document.URL);
	 });
}
</script>
</head>
<body background="https://firebasestorage.googleapis.com/v0/b/policy-65ae1.appspot.com/o/backgroung.jpg?alt=media&token=9ae8da86-0d80-481a-b7c5-21c63af3b215">
<%-- <%-- <%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%> --%> --%>
        <nav class="navbar navbar-expand-md navbar-light bg-light">
               <a href="policy.html?id=${user.userId}"> <img src="https://firebasestorage.googleapis.com/v0/b/policy-65ae1.appspot.com/o/logo.png?alt=media&token=3f99482f-6af5-477e-9e56-2e55de640f3c" style="width:170px;height:75px;"></img></a>
                             
                    
               <ul class="navbar-nav ml-auto">
                   <li class="nav-item">
                       <a class="nav-link" href="#"><span class="fa fa-bell"></span></a>
                   </li>
                   <li class="nav-item">
                       <span class="navbar-text">
                           Welcome, ${user.firstName}
                       </span>
                   </li>
                   
                   </ul>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <form class="mx-2 my-auto w-full">
                             <a href="user/policy.html?id=${user.userId}" class="btn btn-secondary  form-rounded">Home</a>
                                <a href="logout1.html" class="btn btn-secondary  form-rounded" >Logout
                                
           
            </a>
                            </form>
                        </li>
                    </ul>
                        
            </nav>

<div class="container-fluid">
<br>
    <div class="row">
            <div class="col-md-3 bg-light">
                <nav class="navbar navbar-expand-md navbar-dark bg-secondary">
                    <span class="navbar-text navbar-">PROFILE</span>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                           <!--  <a href="" style="color: aliceblue">Edit</a> -->
                        </li>
                    </ul>
                </nav>

<br><center>
<c:choose>
<c:when test="${user.gender=='Male'}">
<picture>
<img src="https://firebasestorage.googleapis.com/v0/b/grizzly-5a659.appspot.com/o/avatar7.png?alt=media&token=e821e958-e39c-44d3-89fb-68cc24fc884b" alt="Profile picture" width="50px"></img>
 </picture><br>
 </c:when>
 <c:otherwise>
 <picture>
 <img src="https://firebasestorage.googleapis.com/v0/b/grizzly-5a659.appspot.com/o/defaultFemalePP.png?alt=media&token=5f5d2eeb-2618-4093-8247-e891554ef819 " alt="Profile picture" width="50px"></img>
    </picture><br>
 </c:otherwise>
</c:choose>
    <!-- <picture>
        <img src="https://firebasestorage.googleapis.com/v0/b/grizzly-5a659.appspot.com/o/avatar7.png?alt=media&token=e821e958-e39c-44d3-89fb-68cc24fc884b" alt="Profile picture" width="50px"></img>
    </picture><br> -->
    <input id="prodId" name="userName" type="hidden" value=${user.userId}>
    <b>${user.userId}</b>
<br>

                   <a href="user/userShowPolicy.html?id=${user.userId}" class="btn btn-secondary form-rounded"  width="50px"> &emsp;My Policy&emsp; 
                              </a>&emsp;&emsp;
                   <br>
<br><br>

  </div>

                <div class="col-md-9 bg-light">
            
                    <div class="btn-group col-md-12">
                        <div class="container">
                            
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs" role="tablist">
                              <li class="nav-item">
                             
                                <a  class="nav-link active" data-toggle="tab"> POLICY</a>
                              </li>
                            
                            
                            </ul>
                          
                            <!-- Tab panes -->
                            <div class="tab-content">
                              <div id="home" class="container tab-pane active"><br>
        
                        <div class="col-md-12 bg-light">
                                <form class="mx-2 my-auto d-inline w-20" action="user/search.html?id=${user.userId}" method="POST">
                                        <div class="input-group">
                                               <input list="category" name="selectby" class="form-rounded" placeholder="Search By">
                                            <datalist id="category">
                                              			<option value="By Name">By Name</option>
                                                         <option value="By Id">By Id</option>
                                                         <option value="By Type">By Type</option>
                                                         <option value="By Duration">By Duration</option>
                                             </datalist> &emsp;&emsp;&emsp;&emsp;&emsp;
                                                
                                            <input type="text" name="search" class="form-rounded" placeholder="Search">   

&emsp;&emsp;&emsp;&emsp;&emsp;
                                                 
                                                     


        <input id="prodId" name="userId" type="hidden" value=${user.userId}>   
             <button type="submit"  class="btn btn-dark form-rounded" >Search Policy</a>
</form>
		
<form>
                        </div>
    
                                     <br>     <br>                
                                     <table border="1" class="table table-bordered">
                                            <tr>
                                                <td>
                                                    <center><span style="color: gray">policyId</span>
                                                </td>
                                                <td>
                                                        <center> <span style="color: gray">policyName</span>
                                                    </td>
                                                    <td>
                                                            <center><span style="color: gray">policyType</span>
                                                        </td>
                                                        <td>
                                                                <center><span style="color: gray">duration</span>
                                                            </td>
                                                            
                                                            <td>
                                                                    
                                                                </td>
                                            </tr>
						<c:forEach  var="product"  items= "${products}">
                        <tr>
                          <td>
                            <div class="checkbox checkbox-info checkbox-circle">
                              <input id="checkbox11" type="checkbox" checked="">
                              <label for="checkbox11">
                                ${product.policyId}
                              </label>
                            </div>    
                          </td>
                          <td>
                            ${product.policyName}
                          </td>
                          <td>
                            ${product.policyType}
                          </td>
                          <td>
                            <span style="color: gray">${product.duration}
                            </span>
                          </td>
              
                          <td>
                            <center>
                              <a href="user/viewPolicyByUser.html?id=${product.policyId}" class="btn btn-secondary form-rounded"  width="50px"> &emsp;View&emsp; 
                              </a>&emsp;&emsp;
								<input id="productId" name="userName" type="hidden" value=${user.userId}>
                             <a href="user/addToCart1.html?id=${product.policyId}&id1=${user.userId}" class="btn btn-secondary form-rounded"  width="50px"> &emsp;Buy&emsp; 
                              </a>&emsp;&emsp;
                             
                            </center>
                          </td>
                        </tr>
                       </c:forEach>                                

                                        </table>

                        </div>
               
                              </div>
                              <div id="menu1" class="container tab-pane fade"><br>
                                <p>
                                    VENDOR SIDE
                                    </p>
                              </div>
                            </div>
                          </div>
                    </div>
                    <br>
    </div>    

           
</body>
</html>