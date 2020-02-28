<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.UserDTO"%>
    <%@ page import="dao.UserDAO" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Register Here</title>
  </head>
  <body>
  <%
  	String regcode = request.getParameter("regcode");
  	String userid = request.getParameter("userid");
  	String password = request.getParameter("password");
  	String email = request.getParameter("email");
  	String phone = request.getParameter("phone");
	UserDTO userDTO = new UserDTO();
 	if(regcode!=null && userid!=null){
	 userDTO.setRegcode(regcode);
	 userDTO.setUserid(userid);
	 userDTO.setPassword(password);
	 userDTO.setEmail(email);
	 userDTO.setPhone(phone);
	 UserDAO userDAO = new UserDAO();
	 boolean result = userDAO.register(userDTO);
	 String message = result?"Register SuccessFully":"Not able to register";
 	out.println(message);
 }
  %>
  	<div class='container'>
  		<h1>Student Register Here</h1>
  		<form action='register.jsp' method="post">
  		<div class='form-group'>
  		<label>RegCode</label>
  		<input name='regcode' class='form-control' type='text' placeholder="Type Reg Code Here">
  		</div>
  		<div class='form-group'>
  		<label>Userid</label>
  		<input name='userid' class='form-control' type='text' placeholder="Type Userid Here">
  		</div>
  		<div class='form-group'>
  		<label>Password</label>
  		<input name='password' class='form-control' type='password' placeholder="Type Password Here">
  		</div>
  		<div class='form-group'>
  		<label>Email</label>
  		<input name='email' class='form-control' type='email' placeholder="Type Email Here">
  		</div>
  		<div class='form-group'>
  		<label>Phone</label>
  		<input name='phone' class='form-control' type='text' placeholder="Type Phone Here">
  		</div>
  		<div class='form-group'>
  		
  		<button type='submit' class='btn btn-primary'>Register</button>
  		</div>
  		</form>
  	</div>
    

    
  </body>
</html>