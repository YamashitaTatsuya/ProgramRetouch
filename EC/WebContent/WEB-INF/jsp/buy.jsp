<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入</title>
<jsp:include page="/baselayout/head.html" />
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<br>
	<br>
	<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">カートアイテム</h5>
		</div>
		<div class="row">
			<div class="section"></div>
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<form action="BuyConfirm" method="POST">
							<div class="row">
								<table class="bordered">
									<thead>
										<tr>
											<th class="center" style="width: 20%">商品名</th>
											<th class="center">単価</th>
											<th class="center" style="width: 20%">小計</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cartInItem" items="${cart}" >
											<tr>
												<td class="center">${cartInItem.name}</td>
												<td class="center">${cartInItem.price}円</td>
												<td class="center">${cartInItem.price}円</td>

											</tr>
										</c:forEach>
										<tr>
											<td class="center"></td>
											<td class="center"></td>
											<td class="center">
												<div class="input-field col s8 offset-s2 ">
													<select name="delivery_method_id">
														<c:forEach var="dmdb" items="${dmdbList}" >
															<option value="${dmdb.id}">${dmdb.name}</option>
														</c:forEach>
													</select> <label>配送方法</label>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="row">
								<div class="col s12">
									<button class="btn  waves-effect waves-light  col s4 offset-s4" type="submit" name="action">購入確認</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/baselayout/footer.jsp" />
</body>
</html>