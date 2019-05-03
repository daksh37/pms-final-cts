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
</script>

<style>
table{
    border: 1px solid black;
    padding: 0px 0px 15px 0px;
    width: 100%;
    }
th, td {
  border: 1px solid black;
  padding: 10px 0px 10px 0px;
}
.container{
    padding: 15px 15px 15px 15px;
}
</style>
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
                             
                                <a  class="nav-link active" data-toggle="tab"> VIEW POLICY</a>
                              </li>
                            
                            
                            </ul>
                          
                    
                            <br>                            
                            <div class="container">
                                    <div class="row"></div>
                                            <div class="col"></div>
                                                <form action="editPolicy.html"  method="POST"  >
                                                            <table>
                                                                <tr>
                                                                    <th colspan="2" left-padding="10px"><center>POLICY DETAILS</center></th>
                                                                </tr>
                                                                <tr>
                                                                    <th><center>Policy Name</center></th>
                                                                    <td><center>${policy.policyName}</center></td>
                                                                </tr> 
                                                                <tr>
                                                                        <th><center>Policy Id</center></th>
                                                                        <td><center>${policy.policyId}</center></td>
                                                                </tr>
                                                                <tr>
                                                                        <th><center>Policy Type</center></th>
                                                                        <td><center>${policy.policyType}</center></td>
                                                                </tr>
                                                                <tr>
                                                                        <th><center>Policy Duration</center></th>
                                                                        <td><center>${policy.duration}</center></td>
                                                                </tr>
                                                                <tr>
                                                                        <th><center>Company</center></th>
                                                                        <td><center>${policy.company}</center></td>
                                                                </tr>
                                                                <tr>
                                                                        <th><center>Policy Initial Deposit</center></th>
                                                                        <td><center>${policy.initialDeposit}</center></td>
                                                                </tr>
                                                                <tr>
                                                                        <th><center>Policy Term Amount</center></th>
                                                                        <td><center>${policy.termAmount}</center></td>
                                                                </tr>
                                                                <tr>
                                                                        <th><center>Interest Rate</center></th>
                                                                        <td><center>${policy.interest}</center></td>
                                                                </tr>  
                                                            </table>


                                                            <!-- <div class="row">
                                                                <div class="form-group col-sm-6">                                                    
                                                                <label for="uname">Policy ID:</label><br>
                                                                <input type="text" class="col-sm-8"   name="policyId" value=${display.policyId} readonly="readonly">
                                                                </div>
                                                                
                                                                <div class="form-group col-sm-6">
                                                                <label for="uname">Policy Name:</label><br>
                                                                <input type="text" class="col-sm-8"   name="policyName" value=${display.policyName} required>
                                                                  </div>
                                                                  
                                                                  
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Policy Type:</label><br>
                                                                        <input type="text" class="col-sm-8"   name="policyType" value=${display.policyType} required>
                                                                </div>
                    
                    
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Duration In Months:</label><br>
                                                                        <input type="text" class="col-sm-8"  name="duration" value=${display.duration} required>
                                                                </div>
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Company:</label><br>
                                                                        <input type="text" class="col-sm-8"  name="company" value=${display.company} readonly="readonly">
                                                                </div>
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Initial Deposit:</label><br>
                                                                        <input type="text" class="col-sm-8"  name="initialDeposit" value=${display.initialDeposit} readonly="readonly">
                                                                </div>
                                                               
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Term Amount:</label><br>
                                                                        <input type="text" class="col-sm-8"   name="termAmount" value=${display.termAmount} required>
                                                                </div>
                                                                <div class="form-group col-sm-6">
                                                                        <label for="uname">Interest:</label><br>
                                                                        <input type="text" class="col-sm-8"  name="interest" value=${display.interest} readonly="readonly">
                                                                </div>
                                                                                                                                            
                                                                <div class="form-group col-sm-6">
                                                                    <br>
                                                                    <button type="submit" class="btn btn-primary">Submit</button>
                                                                </div>
                                                            
                                                            </div> -->
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