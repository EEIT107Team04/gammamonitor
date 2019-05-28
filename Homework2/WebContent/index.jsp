<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>index</h1>
	<form action="/Homework2/Test1" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='gold'>
					<th height="60" colspan="2" align="center">新增空氣輻射資料</th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">地方:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="place" type="text" size="14">
				</tr>
				<tr bgcolor='pink'>
					<td width="120" height="40">監控地點:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="station" type="text" size="14">
					</td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">監控值:</td>
					<td width="600" height="40" align="left"><input
						name="measurements" type="text" size="20"></td>
				</tr>
				<tr bgcolor='orange'>
					<td width="120" height="40">即時監控:</td>
					<td width="600" height="40" align="left"><input name="live"
						type="text" size="54"></td>
				</tr>
				<tr bgcolor='lightpink'>
					<td width="120" height="40">地點的經度:</td>
					<td width="600" height="40" align="left"><input
						name="longitude" type="text" size="20"></td>
				</tr>
				<tr bgcolor='dimgreen'>
					<td width="120" height="40">地點的緯度:</td>
					<td width="600" height="40" align="left"><input
						name="latitude" type="text" size="14"><font color='blue'
						size="20"></font></td>
				<tr>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="新增" /> <input type="submit" value="修改"
						onclick="msg()" /> <input type="submit" value="刪除"
						onclick="msg()" /> <input type="submit" value="查詢"
						onclick="msg()" />
				</tr>
				<tr bgcolor='dimgreen'>
		</table>
		<div style="color: pink; display: inline">${ErrorMsg.exception}</div>
	</form>
</body>
</html>