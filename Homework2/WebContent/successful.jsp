<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>空氣輻射監控</title>
</head>
<body>
	<h2> 資料新增成功</h2>
	汙染的地方: ${ MemberBean.place}
	<br> 監測地點:  ${MemberBean.station}
	<br> 測量值: ${MemberBean.measurements}
	<br> 即時監控 :${MemberBean.live}
	<br> 地點的經度: ${MemberBean.longitude}
	<br> 地點的緯度: ${MemberBean.latitude}
	<br>
</body>
</html>