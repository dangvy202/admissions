<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<!--com.java.project.controller.admin;-->
<%@page import="com.sch.mgmt.entity.ApplicationFormEntity"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="jakarta.servlet.jsp.tagext.TagLibraryValidator"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE> <html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<jsp:include page="../template/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<!-- Preloader -->
		<div
			class="preloader flex-column justify-content-center align-items-center">
			<img class="animation__shake"
				src="${pageContext.servletContext.contextPath}/dist/img/angry-nerds-logo-2.png"
				alt="AdminLTELogo" height="260" width="260">

		</div>
		<jsp:include page="../template/nav-bar.jsp"></jsp:include>
		<jsp:include page="../template/side-bar.jsp"></jsp:include>
		<div class="content-wrapper" style="min-height: 116.365px;">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Order Manager :: List</h1>
						</div>
					</div>
				</div>
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<!-- Message -->
					<!-- <div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">x</button>
				<h5>
					Success!
				</h5>
				<ul class="list-unstyled mb-0">
					<li class="text-black">Update Success!</li>
				</ul>
			</div> -->
					<!-- end Message -->
					<!-- List -->
					<div class="card card-info card-outline">
						<div class="card-header">
							<h4 class="card-title">List</h4>
							<div class="card-tools">
								<a href="${pageContext.servletContext.contextPath}/admin/user"
									class="btn btn-tool"><i class="fas fa-sync"></i></a>
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse" data-toggle="tooltip"
									title="Collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<div class="card-body">
							<!-- Control -->
							<div
								class="d-flex flex-wrap align-items-center justify-content-between mb-2">
								<div class="mb-1">
									<form action="" method="GET" name="search-form">
										<div class="input-group">
											<input type="text" class="form-control form-control-sm"
												name="search_value" placeholder="Search..." value=""
												style="min-width: 200px">
											<div class="input-group-append">
												<button type="button" class="btn btn-sm btn-danger"
													id="btn-clear-search">Clear</button>
												<button type="submit" class="btn btn-sm btn-info"
													id="btn-search">Search</button>
											</div>
										</div>
									</form>
								</div>
								<div class="mb-2">
									<a href="" class="btn btn-sm btn-info"> Copy </a> <a href=""
										class="btn btn-sm btn-info"> CSV </a> <a href=""
										class="btn btn-sm btn-info"> Excel </a> <a href=""
										class="btn btn-sm btn-info"> PDF </a> <a href=""
										class="btn btn-sm btn-info"> Print </a>
								</div>
							</div>
							<!-- List Content -->
							<form action="" method="GET" class="table-responsive"
								id="form-table">
								<table
									class="table table-bordered table-hover text-nowrap btn-table mb-0">
									<thead>
										<tr>
											                <th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1">STT</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1">SỐ CCCD/MÃ ĐỊNH DANH</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1">NGÀY CẤP</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1">HỌ ĐỆM</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1">TÊN</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1">PHÁI</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1">NGÀY SINH</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1">NƠI SINH TỈNH/TP TW</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">THƯỜNG TRÚ TỈNH/TP TW</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">THƯỜNG TRÚ HUYỆN/QUẬN/TP</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">THƯỜNG TRÚ XÃ/PHƯỜNG</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">ĐỊA CHỈ THƯỜNG TRÚ</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">ĐIỆN THOẠI LIÊN LẠC</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">SĐT CỦA AI</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">ĐỊA CHỈ EMAIL</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">DÂN TỘC</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP 9</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">TÊN TRƯỜNG THCS LỚP 9</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">TỈNH TRƯỜNG THCS</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">HUYỆN/QUẬN/TP TRƯỜNG THCS</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">XÃ/PHƯỜNG TRƯỜNG THCS</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">ĐỊA CHỈ TRƯỜNG THCS</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">MÔN TOÁN</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">MÔN VĂN</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">MÔN TIN</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">MÔN LÝ</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">MÔN HÓA</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">MÔN SINH</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">MÔN ANH</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP TOÁN CS1</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP VĂN CS1</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP TIN CS1</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP LÝ CS1</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP HÓA CS1</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP SINH CS1</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP ANH CS1</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP TOÁN CS2</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP VĂN CS2</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP TIN CS2</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP LÝ CS2</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP HÓA CS2</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP SINH CS2</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
                                                            	rowspan="1" colspan="1">LỚP ANH CS2</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="applicationForm" items="${applicationForm}">
															<tr>
																<td>${applicationForm.id}</td>
																<td>${applicationForm.account.identifierCode}</td>
																<td></td>
																<td>${applicationForm.schUser.firstName}</td>
																<td>${applicationForm.schUser.lastName}</td>
																<c:choose>
																	<c:when test="${applicationForm.schUser.sex == 1}">												
																		<td>Nam</td>
																	</c:when>
																	<c:otherwise>
																		<td>Nữ</td>
																	</c:otherwise>
																</c:choose>
																<td>${applicationForm.schUser.birthday}</td>
																<td>${applicationForm.schUser.placeOfBirth}</td>
																<td>${applicationForm.schUser.province}</td>
																<td>${applicationForm.schUser.district}</td>
																<td>${applicationForm.schUser.ward}</td>	
																<td>${applicationForm.schUser.address}</td>
																<td>${applicationForm.schUser.phoneNumber}</td>
																<td>${applicationForm.schUser.optionPhone}</td>
																<td>${applicationForm.account.email}</td>
																<td>${applicationForm.schUser.ethnicity}</td>
																<td>${applicationForm.schReport.nameClass}</td>
																<td>${applicationForm.schReport.schoolPassed}</td>
																<td>${applicationForm.schReport.province}</td>
																<td>${applicationForm.schReport.district}</td>
																<td>${applicationForm.schReport.ward}</td>
																<td>${applicationForm.schReport.schoolAddress}</td>
																<td>${applicationForm.subject.math}</td>
																<td>${applicationForm.subject.literature}</td>
																<td>${applicationForm.subject.informatics}</td>
																<td>${applicationForm.subject.physics}</td>
																<td>${applicationForm.subject.chemistry}</td>
																<td>${applicationForm.subject.biology}</td>
																<td>${applicationForm.subject.english}</td>
																<td>${applicationForm.schOption.mathCS1}</td>
																<td>${applicationForm.schOption.literatureCS1}</td>
																<td>${applicationForm.schOption.informaticsCS1}</td>
																<td>${applicationForm.schOption.physicsCS1}</td>
																<td>${applicationForm.schOption.chemistryCS1}</td>
																<td>${applicationForm.schOption.biologycs1}</td>
																<td>${applicationForm.schOption.englishCS1}</td>
																
																<td>${applicationForm.schOption.mathCS2}</td>
																<td>${applicationForm.schOption.literatureCS2}</td>
																<td>${applicationForm.schOption.informaticsCS2}</td>
																<td>${applicationForm.schOption.physicsCS2}</td>
																<td>${applicationForm.schOption.chemistryCS2}</td>
																<td>${applicationForm.schOption.biologycs2}</td>
																<td>${applicationForm.schOption.englishCS2}</td>
																
																<td class="project-actions text-center"><a
																	class="btn btn-primary btn-sm"
																	href="${pageContext.request.contextPath}/admin/actor/detail?id=${actor.id_actor}"><i
																		class="fas fa-folder"></i>View</a> <a
																	class="btn btn-info btn-sm"
																	href="${pageContext.request.contextPath}/admin/actor/edit?id=${actor.id_actor}"><i
																		class="fas fa-pencil-alt"></i>Edit</a></td>
															</tr>
														</c:forEach>



										<!-- END SHOW DỮ LIỆU  -->
									</tbody>
								</table>
							</form>
						</div>
						<ul style="padding: 20px"
							class="pagination pagination-sm m-0 float-right">
							<li class="page-item"><a href="" class="page-link"><i
									class="fas fa-angle-double-left"></i></a></li>
							<li class="page-item"><a href="" class="page-link"><i
									class="fas fa-angle-left"></i></a></li>
							<li class="page-item active"><a class="page-link" href="#"
								onclick="javascript:changePage(1)">1</a></li>
							<a class="page-link" href="#" onclick="javascript:changePage(2)">2</a>
							<a class="page-link" href="#" onclick="javascript:changePage(3)">3</a>
							<li class="page-item"><a class="page-link"
								onclick="javascript:changePage(2)" href="#"><i
									class="fas fa-angle-right"></i></a></li>
							<li class="page-item"><a class="page-link" href="#"
								onclick="javascript:changePage(3)"><i
									class="fas fa-angle-double-right"></i></a></li>
							<div style="margin-left: 20px" class="limit">Page 1 of 3</div>
						</ul>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>

		<jsp:include page="../template/footer.jsp"></jsp:include>
	</div>
	<!-- ./wrapper -->
	<jsp:include page="../template/script.jsp"></jsp:include>
</body>
</html>