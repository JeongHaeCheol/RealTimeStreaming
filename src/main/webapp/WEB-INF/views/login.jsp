<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.87.0">
<title>Signin Template · Bootstrap v5.1</title>


<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>




<!-- Bootstrap core CSS -->
<link href="/resources/docs/5.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="/resources/static/docs/5.1/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon"
	href="/resources/static/docs/5.1/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon"
	href="/resources/docs/5.1/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest"
	href="/resources/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/resources/docs/5.1/assets/img/favicons/safari-pinned-tab.svg"
	color="#7952b3">
<link rel="icon"
	href="/resources/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link href="/resources/custom/signin.css" rel="stylesheet">
</head>
<body class="text-center">

	<main class="form-signin">
		<sf:form action="${pageContext.request.contextPath}/login"
			method="post" modelAttribute="account">

			<img class="mb-4"
				src="/resources/docs/5.1/assets/brand/bootstrap-logo.svg" alt=""
				width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

			<div class="form-floating">
				<sf:input class="form-control" id="floatingInput" path="id" />
				<label for="floatingInput">ID</label>
			</div>
			<div class="form-floating">
				<sf:password class="form-control" id="floatingPassword"
					path="password" />
				<label for="floatingPassword">Password</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>

			<div style="magin: 15px; padding: 5px;">
				<sf:button type="submit" class="w-100 btn btn-lg btn-primary">로그인</sf:button>
			</div>
			<div style="magin: 15px; padding: 5px;">
				<a href="<c:url value="/register"/>"
					class="w-100 mx-0 mb-2 btn btn-lg btn-primary">회원가입</a>
			</div>

		</sf:form>
	</main>



</body>
</html>
