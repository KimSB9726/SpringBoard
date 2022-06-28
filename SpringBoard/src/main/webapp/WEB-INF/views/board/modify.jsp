<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">스프링 게시판(글 수정)</h3>
				</div>
				<!-- /.box-header -->


				<form action="" method="post" role="form">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">글 제목</label>
							<input type="text" class="form-control" id="exampleInputEmail1"
								name="title" value="${uvo.title }">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">글쓴이</label>
							<input type="text" class="form-control" id="exampleInputPassword1"
								name="writer" value="${uvo.writer }">
						</div>
						<div class="form-group">
							<label>글 내용</label>
							<textarea class="form-control" rows="3" name="content">${uvo.content }</textarea>
						</div>
					</div>

					<div class="box-footer">
						<button type="submit" class="btn btn-primary">수정하기</button>
					</div>
				</form>



			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@ include file="../include/footer.jsp" %>
