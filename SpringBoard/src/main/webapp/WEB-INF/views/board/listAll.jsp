<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">listAll.jsp</h3>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 10px">#</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th style="width: 40px">조회수</th>
				</tr>
				
				<c:forEach var="vo" items="${boardList }">
					<tr>
						<td>${vo.bno }</td>
						<td><a href="/board/read?bno=${vo.bno }">${vo.title }</a></td>
						<td>${vo.writer }</td>
						<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><span class="badge bg-red">${vo.viewcnt }</span></td>
					</tr>
				</c:forEach>
			
				
				
			</tbody>
		</table>
	</div>

	
			
	<div class="box-footer clearfix">
		<ul class="pagination pagination-sm no-margin pull-right">
			<li><a href="#">«</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">»</a></li>
		</ul>
	</div>
</div>


<script type="text/javascript">
	var result = '${result}';
	
	if(result == 'REGOK'){
		alert('글쓰기 완료!!');
	}
	
	if(result == 'MODOK'){
		alert('글 수정 완료!!');
	}
	
	if(result == 'DELOK'){
		alert('글 삭제 완료!!!');
	}
</script>



<%@ include file="../include/footer.jsp"%>