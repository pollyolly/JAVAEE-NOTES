<c:choose>
	<c:when test="${alertStatus == 'SUCCESS'}">
		<div class="alert alert-dismissable alert-success">
			<strong>Well done!</strong> ${message}
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
		</div>
	</c:when>
	<c:when test="${alertStatus == 'FAILED'}">
		<div class="alert alert-dismissable alert-danger">
			<strong>Oh snap!</strong> ${message}
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
		</div>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>