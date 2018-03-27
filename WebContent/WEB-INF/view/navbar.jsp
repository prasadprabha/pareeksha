<!-- Fixed navbar -->
	<nav class="navbar navbar-expand-md navbar-dark  fixed-top" style="background-color: #f44165;">
		<a class="navbar-brand" href="#">Pareeksha</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
		 <%if(session.getAttribute("userName")!=null){ %>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="userlogin.html">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
				</li>
			</ul>
   					<a class="text-white"> Welcome : <% out.print(session.getAttribute("userName"));%>	</a> <a class="text-white pl-2" href="logout.html" >LogOut</a> 
 			 <%} else {%>&nbsp;
  		
			<%} %>
		</div>
	</nav>