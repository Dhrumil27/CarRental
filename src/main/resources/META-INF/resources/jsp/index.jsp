<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Car Rental Application ${name}!</title>
    <link href="/css/main.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>  
    <script src="/js/main.js"></script>
</head>
<body>
	<div class="container">
		<div class="action">
			<button onClick='refreshFreeData()'>Show Free Cars</button>
			<button onClick='refreshRentedData()'>Show Rented Cars</button>
			<div id="cars" >
			</div>
		</div>
	</div>
</body>
</html>