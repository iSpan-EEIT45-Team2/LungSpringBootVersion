<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/resources/includes/head.jsp"%>
<meta charset="UTF-8">
<title>Lung-Hi Peace認養系統</title>
<link href="/Lung-springmvc/URLToReachResourcesFolder/css/dataTable.css"
	rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/icon?family=Material+Icons'>
</head>
<body>

	<!-- _navbar -->
	<%@include file="/resources/includes/navbar.jsp"%>
	<!-- partial -->
	<div class="container-fluid page-body-wrapper">
		<!-- partial:partials/_settings-panel.jsp -->
		<div id="right-sidebar" class="settings-panel">
			<i class="settings-close ti-close"></i>
			<ul class="nav nav-tabs border-top" id="setting-panel" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="todo-tab"
					data-bs-toggle="tab" href="#todo-section" role="tab"
					aria-controls="todo-section" aria-expanded="true">TO DO LIST</a></li>
				<li class="nav-item"><a class="nav-link" id="chats-tab"
					data-bs-toggle="tab" href="#chats-section" role="tab"
					aria-controls="chats-section">CHATS</a></li>
			</ul>
		</div>
		<!-- partial -->
		<!-- partial:partials/_sidebar.jsp -->
		<%@include file="/resources/includes/sidebar.jsp"%>
		<!-- partial -->
		<!-- 顯示區域從這開始 -->
		<div class="main-panel">
			<div class="content-wrapper">
				<div class="row">
					<div class="col-lg grid-margin stretch-card">
						<div class="card material-table">
							<div class="table-header">
								<!-- Table標題 -->
								<span class="table-title">Animal Table</span>
								<div class="actions">
									<!-- 新增 -->
									<a href="showForm"
										class="modal-trigger waves-effect btn-flat nopadding"><i
										class="mdi mdi-plus"></i></a>
									<!-- i標籤是icon -->
									<!-- 搜尋 -->
									<a href="#"
										class="search-toggle waves-effect btn-flat nopadding"><i
										class="material-icons">search</i></a>
								</div>
							</div>
							<div class="table-responsive">
								<table class="table table-hover" id="datatable">
									<thead>
										<tr>
											<th>棄養編號</th>
											<th>聯絡人姓名</th>
											<th>電話</th>
											<th>信箱</th>
											<th>動物名</th>
											<th>圖片</th>
											<th>地址來源</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<!-- Loop Star -->
										<c:forEach var="abdog" items="${abdogbean}">
											<!-- update link -->
											<c:url var="updateLink" value="/BackendAnimal/updateForm">
												<c:param name="Id" value="${abdog.id}" />
											</c:url>
											<!-- delete link -->
											<c:url var="deleteLink" value="/BackendAnimal/delete">
												<c:param name="Id" value="${abdog.id}" />
											</c:url>
											<tr>
												<td>${abdog.abid}</td>
												<td>${abdog.abname}</td>
												<td>${abdog.abphone}</td>
												<td>${abdog.abemail}</td>
												<td>${abdog.abdogname}</td>
												<td>${abdog.abimage}</td>
												<td>${abdog.abaddress}</td>
												<td>
													<button type="button" class="btn btn-sm btn-success"
														onclick="edit('${updateLink}');" id="edit">
														<i class="bi bi-pencil-fill"></i>
													</button>
													<button type="button" class="btn btn-sm btn-danger"
														onclick="deleteajax('${deleteLink}');" id="deleteajax">
														<i class="bi bi-trash-fill"></i>
													</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.jsp -->
				<%@include file="/resources/includes/footer.jsp"%>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- 主畫面結束 -->
	<!-- container-scroller -->

	<!-- Js匯入 -->
	<!-- plugins:js -->
	<%@include file="/resources/includes/JavaScript.jsp"%>
	<!-- End custom js for this page-->

	<!-- 寫自己的Js -->
	<script>
	function edit(updateLink){
		window.location.href = updateLink
	}
	
	function deleteajax(deleteLink){
		 Swal.fire({
		        title: '請問是否要刪除此訂單?',
		        text: "已刪除的訂單無法復原，請再次確認",
		        icon: 'warning',
		        showCancelButton: true,
		        cancelButtonText: '取消',
		        confirmButtonColor: '#d33',
		        cancelButtonColor: '#3085d6',
		        confirmButtonText: '刪除'
		    }).then((result) => {
		        if (result.isConfirmed) {
		            $.ajax({
		                type: "get",
		                url: deleteLink,
		                success: function (msg) {
		                    Swal.fire(
		                        '已刪除!',
		                        '訂單已成功刪除!',
		                        'success'
		                    ).then((result) => {
		                        if (result.isConfirmed) {
		                            location.reload();
		                        }
		                    })
		                },
		                error: function (msg) {
		                    // console.log(msg.status)
		                    Swal.fire({
		                        icon: 'error',
		                        title: '發生錯誤',
		                        text: 'HTTP 狀態碼為 ' + msg.status,
		                        footer: '<a href="https://developer.mozilla.org/zh-TW/docs/Web/HTTP/Status"  target="_blank">怎麼有這錯誤?</a>'
		                    })
		                }
		            });


		        }
		    })
	}
	
	</script>
</body>
</html>