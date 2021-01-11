<!-- пример # 3 :  стартовая страница : index.jsp-->
<%@ page language="java" contentType=
"text/html; charset=utf-8" pageEncoding="utf-8"%>
<html><body>
<TITLE>laba8</TITLE>
<FORM action="testform" method=POST >
<H3>Объем какого тела:<H3>

<TABLE BORDER=5> <tr>

<td>Параллелепипед</td><td><INPUT type="radio" 
		name="v"
		onclick='javascript: a.style.display = "block"; b.style.display = "block";
		c.style.display = "block"; d.style.display = "none"; e.style.display = "none";'
		value="1"></td>
<td>Тетраидер</td><td><INPUT type="radio" 
		name="v"
		onclick='javascript: a.style.display = "block"; b.style.display = "none";
		c.style.display = "none"; d.style.display = "none"; e.style.display = "none";'
		value="2"></td>			
<td>Куб</td><td><INPUT type="radio"
		name="v"
		onclick='javascript: a.style.display = "block"; b.style.display = "none";
		c.style.display = "none"; d.style.display = "none"; e.style.display = "none";'
		value="3"></td>
<td>Шар</td><td><INPUT type="radio" 
		name="v"
		onclick='javascript: a.style.display = "none"; b.style.display = "none";
		c.style.display = "none"; d.style.display = "block"; e.style.display = "none";'
		value="4"></td>
<td>Тор</td><td><INPUT type="radio" 
		name="v"
		onclick='javascript: a.style.display = "none"; b.style.display = "none";
		c.style.display = "none"; d.style.display = "block"; e.style.display = "block";'
		value="5"></td>		
		</tr></TABLE><H3>
		 	
<H3>Введите параметр а: 
<INPUT id = "a" type="text" name="a" value="" visibility: hidden>
<H3>Введите параметр b:
<INPUT id = "b" type="text" name="b" value="" visibility: hidden>
<H3>Введите параметр c:
<INPUT id = "c" type="text" name="c" value="" visibility: hidden>
<H3>Введите параметр R:
<INPUT id = "d" type="text" name="d" value="" visibility: hidden>
<H3>Введите параметр r:
<INPUT id = "e" type="text" name="e" value="" visibility: hidden> 
<H3>
      <INPUT type="submit" value="Посчитать"> <BR>
</FORM>		  
</body></html>
