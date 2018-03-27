 <footer class="footer footer-light fixed-bottom" style="background-color: #f44165;">
      <div class="container text-center">
        <span class="text-white">An Initiative of CenturyLink Offshore KM Team</span>
      </div>
 </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  <!--   <script src="${pageContext.request.contextPath}/javascript/jquery-slim.min.js" ></script>-->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/jquery.countdownTimer.min.js"></script>
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   
<script>
$(function(){
	/*$("#future_date").countdowntimer({
		minutes : 0,
        seconds : 5,
        size : "lg",
        timeUp : timeisUp
	});
	
	function timeisUp() {
		$( "#dialog-confirm" ).dialog({
		      resizable: false,
		      height: "auto",
		      width: 400,
		      modal: true,
		      buttons: {
		        "OK": function() {
		          $( this ).dialog( "close" );
		      	$('form#qstnPaper').submit();    	
		        }
		      }
		});
		
    }*/
});

 function pageRedirect() {
     window.location.replace("http://localhost:8080/pareeksha/forms/user/userlogin.html");
 }      

</script>
