<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</script>
</head>
<body background="https://firebasestorage.googleapis.com/v0/b/policy-65ae1.appspot.com/o/backgroung.jpg?alt=media&token=9ae8da86-0d80-481a-b7c5-21c63af3b215">

        <nav class="navbar navbar-expand-md navbar-light bg-light">
               <a href="policy1.html?id=${user.userId}"> <img src="https://firebasestorage.googleapis.com/v0/b/policy-65ae1.appspot.com/o/logo.png?alt=media&token=3f99482f-6af5-477e-9e56-2e55de640f3c" style="width:170px;height:75px;"></img></a>
                             
                    
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
                            <a href="policy1.html?id=${user.userId}" class="btn btn-secondary  form-rounded">Home</a>
                                <a href="logout.html" class="btn btn-secondary  form-rounded" >Logout
                                
           
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
                            <!-- <a href="" style="color: aliceblue">Edit</a> -->
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
    <input id="prodId" name="userName" type="hidden" value=${user.userId}>
    <b>${user.userId}</b>
<br>

                 
                   <br>
<br><br>

  </div>

                <div class="col-md-9 bg-light">
            
                    <div class="btn-group col-md-12">
                        <div class="container">
                            
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs" role="tablist">
                              <li class="nav-item">
                             
                                <a  class="nav-link active" data-toggle="tab"> ADD POLICY</a>
                              </li>
                            
                            
                            </ul>
                          
                    
                            <br>                            
                            <div class="container">
                                    <div class="row"></div>
                                            <div class="col"></div>
                                                <form action="addPolicy.html"  method="POST"  >
                                                            <div class="row">

                                                                <div class="form-group col-sm-6">                                                    
                                                                <label for="uname">Policy ID:</label><br>
                                                                <input type="text" class="col-sm-8"   name="policyId" required>
                                                                </div>
                                                                
                                                                <div class="form-group col-sm-6">
                                                                <label for="uname">Policy Name:</label><br>
                                                                <input type="text" class="col-sm-8"   name="policyName" required>
                                                                  </div>
                                                                  
                                                                  
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Policy Type:</label><br>
                                                                        <input type="text" class="col-sm-8"   name="policyType" required>
                                                                </div>
                    
                    
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Duration In Months:</label><br>
                                                                        <input type="number" class="col-sm-8"  name="duration" required>
                                                                </div>
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Company:</label><br>
                                                                        <input type="text" class="col-sm-8"  name="company" required>
                                                                </div>
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Initial Deposit:</label><br>
                                                                        <input type="number" class="col-sm-8"  name="initialDeposit" required>
                                                                </div>
                                                               
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Term Amount:</label><br>
                                                                        <input type="number" class="col-sm-8"   name="termAmount" required>
                                                                </div>
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Interest:</label><br>
                                                                        <input type="number" class="col-sm-8"  name="interest" required>
                                                                </div>
                                                                                                                                            
                                                                <div class="form-group col-sm-6">
                                                                    <br>
                                                                    <button type="submit" class="btn btn-primary">Submit</button>
                                                                </div>
                                                            
                                                            </div>
                                                        </form>
                                            
                                                    </div>
                                       
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            <br>
                            </div>    

           
</body>
</html>